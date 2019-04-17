package com.example.group_4_shoppingapp.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.group_4_shoppingapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

public class AboutFragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

/*
        WebView webView = (WebView)view.findViewById(R.id.webview);
        webView.loadUrl("https://www.google.com/");
        webView.getSettings().setJavaScriptEnabled(true); //enable javascript
        webView.setWebViewClient(new WebViewClient()); //important to open url in app*/
        return view;


    }

}
