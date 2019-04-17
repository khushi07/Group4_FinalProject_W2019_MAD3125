package com.example.group_4_shoppingapp.Fragment;


import android.content.Intent;

import com.example.group_4_shoppingapp.Activities.CartActivity;

import androidx.appcompat.app.AppCompatActivity;

public class CartFragment extends AppCompatActivity {

    Intent intent = new Intent(CartFragment.this, CartActivity.class);
}




/*<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@drawable/back" >

    <WebView
        android:id="@+id/webview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />
</LinearLayout>*/