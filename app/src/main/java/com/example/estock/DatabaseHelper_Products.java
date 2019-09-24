package com.example.estock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

public class DatabaseHelper_Products extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Estock.db";
    public static final String TABLE_NAME = "Product_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "IMAGE";
    public static final String COL_3 = "NAME";
    public static final String COL_4 = "TYPE";
    public static final String COL_5 = "QTY";
    public static final String COL_6 = "PRICE";
    public static final String COL_7 = "DESCRIPTION";
    public static final String COL_8 = "USERNAME";


    public DatabaseHelper_Products(Context context) {
        super(context, DATABASE_NAME, null, 11);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT,IMAGE BLOB NOT NULL,NAME TEXT NOT NULL,TYPE TEXT NOT NULL,QTY INTEGER NOT NULL,PRICE DOUBLE NOT NULL,DESCRIPTION TEXT NOT NULL,USERNAME TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(byte[] image, String name, String type, int qty, double price, String desc, String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,image);
        contentValues.put(COL_3,name);
        contentValues.put(COL_4,type);
        contentValues.put(COL_5,qty);
        contentValues.put(COL_6,price);
        contentValues.put(COL_7,desc);
        contentValues.put(COL_8,username);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

//    public Cursor getDataByUser(int uid) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where UID = '"+uid+"'",null);
//        return res;
//    }

    public Cursor getTypeData(String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where TYPE = '"+type+"'",null);
        return res;
    }

    public Cursor getDataById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where ID = '"+id+"'",null);
        return res;
    }

    public Cursor getDataByUsername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME+" where USERNAME = '"+username+"'",null);
        return res;
    }

    public boolean updateData(String Id, byte[] image, String name, String type, int qty, double price, String desc, String username) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,Id);
        contentValues.put(COL_2,image);
        contentValues.put(COL_3,name);
        contentValues.put(COL_4,type);
        contentValues.put(COL_5,qty);
        contentValues.put(COL_6,price);
        contentValues.put(COL_7,desc);
        contentValues.put(COL_8,username);
        db.update(TABLE_NAME,contentValues,"id = ?", new String[] { Id });
        return true;

    }

    public Integer deleteDAata(String Id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] { Id });
    }

    public byte[] getBytes(Bitmap bitmap)
    {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }
    public Bitmap getImage(byte[] image)
    {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
