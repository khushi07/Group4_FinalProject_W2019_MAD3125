package com.example.group_4_shoppingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.group_4_shoppingapp.UserData;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "notes_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(UserData.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + UserData.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }


    public long insertNote(UserData note) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        //values.put(UserData.COLUMN_NOTE,note);

        // insert row
        long id = db.insert(UserData.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public UserData getNote(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(UserData.TABLE_NAME,
                new String[]{UserData.COLUMN_ID, UserData.COLUMN_NOTE, UserData.COLUMN_TIMESTAMP},
                UserData.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        UserData note = new UserData(
                cursor.getInt(cursor.getColumnIndex(UserData.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(UserData.COLUMN_NOTE)),
                cursor.getString(cursor.getColumnIndex(UserData.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return note;
    }

    public List<UserData> getAllNotes() {
        List<UserData> notes = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + UserData.TABLE_NAME + " ORDER BY " +
                UserData.COLUMN_TIMESTAMP + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UserData note = new UserData();
                note.setId(cursor.getInt(cursor.getColumnIndex(UserData.COLUMN_ID)));
                note.setNote(cursor.getString(cursor.getColumnIndex(UserData.COLUMN_NOTE)));
                note.setTimestamp(cursor.getString(cursor.getColumnIndex(UserData.COLUMN_TIMESTAMP)));

                notes.add(note);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return notes;
    }

    public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + UserData.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(UserData note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserData.COLUMN_NOTE, note.getNote());

        // updating row
        return db.update(UserData.TABLE_NAME, values, UserData.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }

    public void deleteNote(UserData note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UserData.TABLE_NAME, UserData.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }
}
