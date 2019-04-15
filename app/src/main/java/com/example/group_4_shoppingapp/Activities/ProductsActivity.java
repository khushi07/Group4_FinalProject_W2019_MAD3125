package com.example.group_4_shoppingapp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.group_4_shoppingapp.ListItem;

import com.example.group_4_shoppingapp.MyAdapter;
import com.example.group_4_shoppingapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {



   private static final String URL_DATA = "http://www.json-generator.com/api/json/get/cpNxCGuopu?indent=2";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        //actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Products List");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        ListItem listItem1 = new ListItem("S928 Sports Watch" , "Android 4.3+ / iOS 8.0+");
        listItems.add(listItem1);
        ListItem listItem2 = new ListItem("Pebble Time Smart Watch" , "Android 4.3+ / iOS 6.0+");
        listItems.add(listItem2);
        ListItem listItem3 = new ListItem("Samsung Gear S3" , "Android 4.3+ / iOS 8.0+");
        listItems.add(listItem3);
        ListItem listItem4 = new ListItem("Motorola MOTO 360 Sport" , "Android 4.3+ / iOS 8.2+");
        listItems.add(listItem4);
        ListItem listItem5 = new ListItem("Xiaomi Amazfit" , "Android 4.4+ / iOS 9.0+");
        listItems.add(listItem5);
        ListItem listItem6 = new ListItem("Huawie Watch 2" , "Android 4.4+ / iOS 9.0+");
        listItems.add(listItem6);
        ListItem listItem7 = new ListItem("ASUS ZenWatch 3" , "Android 4.3+ / iOS 8.4+");
        listItems.add(listItem7);
        ListItem listItem8 = new ListItem("Apple Watch Series 3" , "iOS 11+");
        listItems.add(listItem8);
        ListItem listItem9 = new ListItem("Garmin Fenix 3" , "Android 4.3+ / iOS 7.0+");
        listItems.add(listItem9);
        ListItem listItem10 = new ListItem("KingWear KW88" , "Android 5.1+");
        listItems.add(listItem10);




       /* for(int i = 0; i<=10; i ++)
        {
            ListItem listItem = new ListItem("heading" + (i+1) , "hi");
            listItems.add(listItem);
        }*/

        adapter = new MyAdapter(listItems,this);

        recyclerView.setAdapter(adapter);
    }}
/*
       loadRecyclerViewData();
    }

    private void loadRecyclerViewData() {
       final ProgressDialog progressDialog = new ProgressDialog(this);
       progressDialog.setMessage("Loading data...");
       progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
               progressDialog.dismiss();
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray array = jsonObject.getJSONArray("watches");

                    for(int i = 0; i<array.length(); i++)
                    {
                        JSONObject o = array.getJSONObject(i);
                        ListItem item = new ListItem(
                                o.getString("id") ,
                                o.getString("name") ,
                                o.getString("operating system") ,
                                o.getString("color") ,
                                o.getString("warranty") ,
                                o.getString("price") ,
                                o.getString("weight") ,
                                o.getString("image") ) ;
                          listItems.add(item);
                    }

                    adapter = new MyAdapter(listItems, getApplicationContext());
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}*/
