package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyAccount extends AppCompatActivity {

    ImageView Button_logout,Button_myprofile,Button_myorders;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        TextView Text_myorder = findViewById(R.id.Text_Payment_Header2);
        Text_myorder.setText(R.string.Text_myorder);
        TextView Text_myprofile = findViewById(R.id.Text_Product_ProductName);
        Text_myprofile.setText(R.string.Text_myprofile);
        TextView Text_logout = findViewById(R.id.Text_Payment_Card_Number);
        Text_logout.setText(R.string.Text_logout);
        TextView Text_profilename = findViewById(R.id.Text_Profile_name);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String Uname = prefs.getString("username", "No name defined");
        Text_profilename.setText(Uname);

        Button_myorders = (ImageView) findViewById(R.id.Button_myorders);
        Button_myprofile = (ImageView) findViewById(R.id.Button_changeAddress);
        Button_logout = (ImageView) findViewById(R.id.Button_logout);



        Button_myprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MyAccount.this, "My Profile...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MyAccount.this, MyProfile.class));
            }
        });

        Button_myorders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MyAccount.this, "My orders...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MyAccount.this, OrdersPage.class));
            }
        });

        Button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MyAccount.this, "Loging out...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

