package com.example.group_4_shoppingapp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group_4_shoppingapp.R;

public class WatchActivity extends AppCompatActivity {

    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Product Details");

        Intent intent = getIntent();
        position = intent.getExtras().getInt("Position");

        final MyAdapter adapter = new MyAdapter(this);
        final ImageView img = (ImageView) findViewById(R.id.imgid);
        final TextView name = (TextView) findViewById(R.id.MobileName);
        final TextView price = (TextView) findViewById(R.id.MobilePrice);


        //set data
        img.setImageResource(adapter.images[position]);
        name.setText(adapter.names[position]);
        price.setText(adapter.price[position]);

        Button btnnext = (Button) findViewById(R.id.btnnext);

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

    }
}
