package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MyAccount extends AppCompatActivity {

    ImageView Button_mypro;
    ImageView Button_myorders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        Button_mypro = (ImageView) findViewById(R.id.Button_changeAddress) ;
        Button_myorders = (ImageView) findViewById(R.id.Button_myorders);

        Button_mypro.setOnClickListener(new View.OnClickListener() {
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
    }
}

