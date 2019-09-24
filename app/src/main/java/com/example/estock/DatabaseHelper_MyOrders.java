package com.example.estock;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper_MyOrders extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Estock.db";
    public static final String TABLE_NAME="Order_table";
    public static final String COL_1="ORDERID";
    public static final String COL_2="PID";
    public static final String COL_3="QUANTITY";
    public static final String COL_4="TOTPRICE";

    public DatabaseHelper_MyOrders(Context context) {

        super(context,DATABASE_NAME,null,3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME+" (ORDERID INTEGER PRIMARY KEY AUTOINCREMENT,PID TEXT NOT NULL, QUANTITY TEXT NOT NULL,TOTPRICE TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public  boolean insertData(String pid, String quantity,String totPrice){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,pid);
        contentValues.put(COL_3,quantity);
        contentValues.put(COL_4,totPrice);

        long result=db.insert(TABLE_NAME,null,contentValues);

        if (result == -1)
            return false;
        else
         return true;

    }
}
