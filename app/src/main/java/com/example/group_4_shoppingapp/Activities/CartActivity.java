package com.example.group_4_shoppingapp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.group_4_shoppingapp.Database.DatabaseHelper;
import com.example.group_4_shoppingapp.ModelUser;
import com.example.group_4_shoppingapp.R;

public class CartActivity extends AppCompatActivity {
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cart View");
        db = new DatabaseHelper(this);
        Boolean checkCart=db.chkCart(ModelUser.email);
        if(checkCart){
            Toast.makeText(getApplicationContext(), "Cart exists", Toast.LENGTH_LONG).show();
            System.out.println("Cart exists");
        }
        else{
            Toast.makeText(getApplicationContext(), "Cart is non-existant/emppty", Toast.LENGTH_LONG).show();
            System.out.println("Cart doesn't exists");
        }
    }
}


//https://www.youtube.com/watch?v=_9o_ZJUgUWE
