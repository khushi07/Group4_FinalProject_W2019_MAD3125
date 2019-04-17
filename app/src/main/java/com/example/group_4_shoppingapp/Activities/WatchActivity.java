package com.example.group_4_shoppingapp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.group_4_shoppingapp.Database.DatabaseHelper;
import com.example.group_4_shoppingapp.Fragment.CartFragment;
import com.example.group_4_shoppingapp.ModelUser;
import com.example.group_4_shoppingapp.R;

public class WatchActivity extends AppCompatActivity {

    int position = 0;
    int value=1;
    Button btnadd;
    Button btnsub;
    Button btnaddCart;
    TextView q;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Product Details");

        db = new DatabaseHelper(this);
        Intent intent = getIntent();
        position = intent.getExtras().getInt("Position");

        final MyAdapter adapter = new MyAdapter(this);
        final ImageView img = (ImageView) findViewById(R.id.imgid);
        final TextView name = (TextView) findViewById(R.id.MobileName);
        final TextView price = (TextView) findViewById(R.id.MobilePrice);
        btnaddCart=(Button) findViewById(R.id.addcart);


        //set data
        img.setImageResource(adapter.images[position]);
        name.setText(adapter.names[position]);
        price.setText(adapter.price[position]);

        Button btnnext = (Button) findViewById(R.id.btnnext);
        btnadd = (Button) findViewById(R.id.add);
        btnsub = (Button) findViewById(R.id.subtract);
        q=(TextView) findViewById(R.id.quantity);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((value+1)<=10) {
                    value += 1;
                    q.setText(Integer.toString(value));
                }
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((value-1)>0) {
                    value -= 1;
                    q.setText(Integer.toString(value));
                }
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int pos = position + 1 ;

                img.setImageResource(adapter.images[pos]);
                name.setText(adapter.names[pos]);
                price.setText("Price : " + adapter.price[pos]);

                if(!(pos>= adapter.getCount()-1))
                {
                    position += 1;
                }else
                {
                    position = -1;
                }
            }
        });
        btnaddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double total;
                Double price=Double.parseDouble(adapter.price[position]);
                total=price*value;
                Boolean chkInsert=db.insert(adapter.names[position],total.toString(),adapter.images[position], ModelUser.email);
                if(chkInsert){
                    Intent cIntent = new Intent(WatchActivity.this, CartActivity.class);
                    //Set value to pass on next activity
                    startActivity(cIntent);
                    Toast.makeText(getApplicationContext(), "Product added", Toast.LENGTH_SHORT).show();
                    System.out.println("Product Added");
                }
                else{
                    Toast.makeText(getApplicationContext(), "Product not added", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
