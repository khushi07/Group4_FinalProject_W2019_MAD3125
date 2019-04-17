package com.example.group_4_shoppingapp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.group_4_shoppingapp.Cart;
import com.example.group_4_shoppingapp.Database.DatabaseHelper;
import com.example.group_4_shoppingapp.ModelUser;
import com.example.group_4_shoppingapp.R;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    DatabaseHelper db;
    ListView cartView;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cart View");

        cartView=(ListView) findViewById(R.id.cartlistview);



        db = new DatabaseHelper(this);
        Boolean checkCart=db.chkCart(ModelUser.email);
        if(checkCart){
            Toast.makeText(getApplicationContext(), "Cart exists", Toast.LENGTH_LONG).show();
            System.out.println("Cart exists");
            Cursor cursor=db.getCartDetails(ModelUser.email);
            System.out.println("cursor size:"+cursor.getCount());
            cursor.moveToFirst();
            System.out.println("item price"+cursor.getString(1));
            total=findViewById(R.id.totaltextView);
            ArrayList<Cart> list=new ArrayList<Cart>();
            int i=0;
                do{
                    list.add(new Cart(
                            cursor.getString(0),
                            cursor.getString(1),
                            Integer.parseInt(cursor.getString(2))
                    ));
                    i+=1;
                    ModelUser.total+=Double.parseDouble(cursor.getString(1));

                    cursor.moveToNext();
                }while (i<cursor.getCount());

                ModelUser.cartList=list;


                MyCartAdapter adapter=new MyCartAdapter(CartActivity.this);

                cartView.setAdapter(adapter);
                total.setText("Total: $"+ModelUser.total);
            //}
        }
        else{
            Toast.makeText(getApplicationContext(), "Cart is non-existant/emppty", Toast.LENGTH_LONG).show();
            System.out.println("Cart doesn't exists");
        }
    }
}



