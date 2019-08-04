package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MyAccount extends AppCompatActivity {

    TextView nav_myAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        nav_myAccount = (TextView) findViewById(R.id.nav_myAccount) ;

        nav_myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MyAccount.this, "nav_myAccount Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MyAccount.this, MyProfile.class));
            }
        });
    }
}
