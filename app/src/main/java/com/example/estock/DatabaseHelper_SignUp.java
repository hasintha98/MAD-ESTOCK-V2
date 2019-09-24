package com.example.estock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.time.Instant;

import static android.database.sqlite.SQLiteDatabase.openDatabase;


public class DatabaseHelper_SignUp extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Estock.db";
    public static final String TABLE_NAME = "SignUp_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "UserName";
    public static final String COL_3 = "Email";
    public static final String COL_4 = "Password";



    public DatabaseHelper_SignUp(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,UserName TEXT,Email TEXT,Password TEXT)");


    }

    @Override
    //public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    //Drop older table if exists
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String uname, String email, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, uname);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, pass);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public Cursor getTypeData(String type) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " where TYPE = '" + type + "'", null);
        return res;
    }

    public Cursor getDataById(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME + " where ID = '" + id + "'", null);
        return res;
    }

    public boolean updateData(String Id, String uname, String email, String pass) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, Id);
        contentValues.put(COL_2, uname);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, pass);

        db.update(TABLE_NAME, contentValues, "id = ?", new String[]{Id});
        return true;

    }

    public Integer deleteDAata(String Id) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{Id});
    }

    public boolean checkUserExist(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        String[] columns = {"UserName"};

        String selection = "UserName=? and Password = ?";
       String[] selectionArgs = {username, password};

       Cursor cursor = db.query(TABLE_NAME, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if (count > 0) {
           return true;
        } else {
            return false;
     }

   }

    public int checkUser(User us)
    {
        int id=-1;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT ID FROM SignUp_table WHERE UserName=? AND Password=?",new String[]{us.getName(),us.getPassword()});
        if(cursor.getCount()>0) {
            cursor.moveToFirst();
            id=cursor.getInt(0);
            cursor.close();
        }
        return id;
    }

}

