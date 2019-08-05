package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyProfile extends AppCompatActivity {
    ImageView Button_changeUname,Button_changeAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);


        TextView Text_myprofileheader = findViewById(R.id.Text_Payment_Name);
        Text_myprofileheader.setText(R.string.Text_myprofileheader);
        TextView Text_profilename = findViewById(R.id.Text_Payment_Done);
        Text_profilename.setText(R.string.Text_profilename);
        TextView Text_changename = findViewById(R.id.Text_Payment_Header2);
        Text_changename.setText(R.string.Text_changename);
        TextView Text_changeaddress = findViewById(R.id.Text_Product_ProductName);
        Text_changeaddress.setText(R.string.Text_changeaddress);

        Button_changeAddress = (ImageView) findViewById(R.id.Button_changeAddress);
        Button_changeUname = (ImageView) findViewById(R.id.Button_changeUname);

        Button_changeAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MyProfile.this, "changing address...", Toast.LENGTH_SHORT).show();

            }
        });

        Button_changeUname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MyProfile.this, "changing name...", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
