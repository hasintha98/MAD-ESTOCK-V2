package com.example.estock;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);

        TextView Text_signin = findViewById(R.id.Text_signin);
        Text_signin.setText(R.string.Text_signin);

        EditText Input_uname = findViewById(R.id.Input_uname);
        Input_uname.setText(R.string.Input_uname);
    }
}


