package com.example.group_4_shoppingapp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.group_4_shoppingapp.R;


public class ProductsActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        //actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Products List");

        listView = (ListView) findViewById(R.id.listview);
        MyAdapter adapter =new MyAdapter(this);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(),WatchActivity.class);
                intent.putExtra("Position", position);

                startActivity(intent);

            }
        });

    }
}


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
