package com.example.saher.first_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by saher on 12/9/2015.
 */
public class DataBaseManager extends SQLiteOpenHelper {

    public static final String Database_name="contactsmanager.sqlite";
    public static final String table_name="contacts";
    public static final String col_1="id";
    public static final String col_2="first_name";
    public static final String col_3="last_name";
    public static final String col_4="mobile";


    public DataBaseManager(Context context) {
        super(context, Database_name,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String ss = ("create table contacts ( id integer primary key autoincrement, first_name text not null,last_name text,mobile text unique)");
        try {
            db.execSQL(ss);
        } catch (Exception sd) {}
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public Boolean addcontacts (String first_name, String last_name , String mobile ){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_2,first_name);
        contentValues.put(col_3,last_name);
        contentValues.put(col_4,mobile);
        long raw = db.insert(table_name, null, contentValues);
        if (raw == -1)
            return false;
        else
            return true;

    }
    public Cursor viewdata(){

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor=db.query(table_name, null, null, null, null, null, null);
        return cursor;

    }
    public boolean update(String id,String first_name, String last_name , String mobile){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,id);
        contentValues.put(col_2,first_name);
        contentValues.put(col_3,last_name);
        contentValues.put(col_4,mobile);
        db.update(table_name, contentValues, "ID = ?",new String[] {id} );
        return true;

    }
    public boolean delete(){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(table_name, null, null);
        db.close();
        return true;
    }

}
