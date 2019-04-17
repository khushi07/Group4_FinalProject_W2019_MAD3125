package com.example.group_4_shoppingapp.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group_4_shoppingapp.R;

public class MyAdapter extends BaseAdapter {

    Context c;

    String[] names = {"S928 Sports Watch","Pebble Time Watch","Samsung Gear S3","Motorola Moto 360 Sport","Xiaomi Amazfit",
            "Huawei Watch 2","ASUS ZenWatch 3","Apple Watch Series 3","Germin Fenix 3","KingWear KW88"};
    String[] price = {"$124.65","$199.99","$219.20","$324.50","$333.33","$119.32","$204.56","$217.99",
            "$320.21","$240.45"};
    int[] images = {R.drawable.watch1,R.drawable.watch2,R.drawable.watch3,R.drawable.watch4,R.drawable.watch5,R.drawable.watch6,
            R.drawable.watch7,R.drawable.watch8,R.drawable.watch9,R.drawable.watch10,};

    public MyAdapter (Context ctx)
    {
        this.c = ctx;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView==null)
        {
            LayoutInflater inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.watches,null);
        }

        //get view
        TextView nametxt = (TextView) convertView.findViewById(R.id.name);
        TextView pricetxt = (TextView) convertView.findViewById(R.id.price);
        ImageView img = (ImageView) convertView.findViewById(R.id.imgid);

        //set data
        nametxt.setText(names[position]);
        pricetxt.setText(price[position]);
        img.setImageResource(images[position]);

        return convertView;
    }
}





