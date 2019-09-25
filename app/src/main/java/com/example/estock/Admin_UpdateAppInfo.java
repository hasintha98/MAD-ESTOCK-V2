package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_UpdateAppInfo extends AppCompatActivity {
    DatabaseHelper_UpdateAppInfo mydb;

    TextView aboutUs;
    TextView contactUs;
    EditText AboutUs;
    EditText ContactUs;
    Button update;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__update_app_info);

        mydb = new DatabaseHelper_UpdateAppInfo(getApplicationContext());

        aboutUs = (TextView) findViewById(R.id.textView_about);
        contactUs = (TextView)findViewById(R.id.textView_contactus);
        AboutUs = (EditText)findViewById(R.id.editText_aboutUs);
        ContactUs = (EditText)findViewById(R.id.editText_contactUs);
        update = (Button)findViewById(R.id.btn_update);
        add = (Button)findViewById(R.id.button_add);



        Cursor data = mydb.getDataById(1);
        while(data.moveToNext()) {
            aboutUs.setText(data.getString(1));
            contactUs.setText(data.getString(2));
        }


        AddData();
        UpdateData();


    }
    public void AddData(){
        add.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Toast.makeText(ProductPage.this, "Data lol inserted", Toast.LENGTH_LONG).show();
                        String abouUs = AboutUs.getText().toString();
                        String contactUs = ContactUs.getText().toString();


                        boolean isInserted = mydb.insertData(abouUs,contactUs);

                        if(isInserted == true) {
                            Toast.makeText(Admin_UpdateAppInfo.this, "Data inserted", Toast.LENGTH_LONG).show();
                            // startActivity(new Intent(ProductPage.this, paymentPage.class));
                        }
                        else
                            Toast.makeText(Admin_UpdateAppInfo.this,"Data not inserted",Toast.LENGTH_LONG).show();


                    }

                }
        );
    }



    public void UpdateData() {
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String App_Info = AboutUs.getText().toString();
                String Contact_Us = ContactUs.getText().toString();

                boolean isUpdated = mydb.updateData("1",App_Info, Contact_Us);

                if(isUpdated == true) {
                    Toast.makeText(Admin_UpdateAppInfo.this, "You have successfully updated the item", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Admin_UpdateAppInfo.this, com.example.estock.App_Info.class));
                } else {
                    Toast.makeText(Admin_UpdateAppInfo.this, "Data not Updated", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
