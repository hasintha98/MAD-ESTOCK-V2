package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class DatabaseHelper_UpdateAppInfo extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Estock.db";
    public static final String TABLE_NAME = "APP_INFO";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "APPINFO";
    public static final String COL_3 = "CONTACTINFO";



    public DatabaseHelper_UpdateAppInfo(Context context) {

        super(context, DATABASE_NAME,null,11);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,APPINFO TEXT NOT NULL,CONTACTINFO TEXT NOT NULL)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public  boolean insertData(String aboutUs, String contactUs){
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,aboutUs);
        contentValues.put(COL_3,contactUs);

        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);

        if (result == -1)
            return false;
        else
            return true;

    }

    public Cursor getDataById(int id) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME+" where ID = '"+id+"'",null);
        return res;
    }

    public boolean updateData(String ID, String appinfo,String contactinfo) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,ID);
        contentValues.put(COL_2,appinfo);
        contentValues.put(COL_3,contactinfo);

        sqLiteDatabase.update(TABLE_NAME,contentValues,"ID = ?", new String[] { ID });
        return true;

    }



}
