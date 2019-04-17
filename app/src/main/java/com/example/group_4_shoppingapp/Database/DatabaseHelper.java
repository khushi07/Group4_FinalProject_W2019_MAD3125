package com.example.group_4_shoppingapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mylist.db";
    public static final String TABLE_NAME = "mylist.data";
    public static final String COL1 = "ID";
    public static final String COL2 = "name";


    public DatabaseHelper(@Nullable Context context) {
        super(context, "Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("Create table user(email text primary key,password text)");
      db.execSQL("Create table cart(prod_name text,total_price text,image text,email text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("drop table if exists user");
     db.execSQL("drop table if exists cart");
    }

    //inserting in database
    public boolean insert(String email,String password){
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins = db.insert("user", null, contentValues);
        if(ins==-1) return false;
        else return true;
    }
    public boolean insert(String prod_name,String total_price, int image,String email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("prod_name",prod_name);
        contentValues.put("total_price",total_price);
        contentValues.put("image",Integer.toString(image));
        contentValues.put("email",email);
        long ins=db.insert("cart",null,contentValues);
        if(ins==-1) return false;
        else return true;
    }

    //checking cart exists
    public Boolean chkCart(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from cart where email=?",new String[] {email});
        if(cursor.getCount()>=1) return true;
        else return false;
    }

    public Cursor getCartDetails(String email){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c= db.rawQuery("Select * from cart where email=?",new String[]{email});
        System.out.println("cursor passed with size"+c.getCount()+"+"+c.getColumnCount());
        return c;
    }

    //checking if email exists
     public Boolean chkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
         Cursor cursor = db.rawQuery("Select * from user where email=?",new String[] {email});
         if(cursor.getCount()>0) return false;
         else return true;
     }

     //checking the email and password
    public Boolean emailpassword(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if(cursor.getCount()>0) return true;
        else return false;
    }

}
