package com.example.group_4_shoppingapp;

import android.widget.ImageView;

public class ListItem {

    private String head;
    private String desc;
    private ImageView imageUrl;

    public ListItem(String head, String desc) {
        this.head = head;
        this.desc = desc;
        this.imageUrl = imageUrl;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public ImageView getImageUrl() {
        return imageUrl;
    }
}

//cart view SQLite

//https://www.youtube.com/watch?v=5ISNPFmuOU8&list=PLrnPJCHvNZuBMJmll0xy2L2McYInT3aiu