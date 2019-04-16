package com.example.group_4_shoppingapp.models;

import android.widget.ImageView;


public class ListItem {

    private String head;
    private String desc;
   // private ImageView imageUrl;


    public ListItem() {
    }

    public ListItem(String head, String desc) {

        this.head = head;
        this.desc = desc;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "head='" + head + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

//cart view SQLite

//https://www.youtube.com/watch?v=5ISNPFmuOU8&list=PLrnPJCHvNZuBMJmll0xy2L2McYInT3aiu