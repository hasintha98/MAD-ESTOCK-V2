package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class App_Info extends AppCompatActivity {
    DatabaseHelper_UpdateAppInfo mydb;

    TextView aboutUs;
    TextView contactUs;
    TextView txtAboutUs;
    TextView txtContactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);

        mydb = new DatabaseHelper_UpdateAppInfo(getApplicationContext());

        aboutUs = (TextView) findViewById(R.id.textView_about);
        contactUs = (TextView)findViewById(R.id.textView_contactus);
        txtAboutUs = (TextView) findViewById(R.id.editText_aboutUs);
        txtContactUs = (TextView) findViewById(R.id.editText_contactUs);



      Cursor cursor = mydb.getAllData();
        if(cursor.getCount()==0){
            Toast.makeText(getApplicationContext(),"NO DATA ",Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                Toast.makeText(getApplicationContext(),"About Us "+cursor.getString(2) ,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),"Contact Us "+cursor.getString(3) ,Toast.LENGTH_SHORT).show();


            }
        }
    }
}
