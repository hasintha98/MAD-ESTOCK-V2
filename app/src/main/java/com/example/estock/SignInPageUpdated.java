package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SignInPageUpdated extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page_updated);

        TextView Text_signin = findViewById(R.id.Text_Payment_Header);
        Text_signin.setText(R.string.Text_signin);

        TextView Text_name = findViewById(R.id.Text_Payment_Done);
        Text_name.setText(R.string.Text_name);

        EditText Input_uname = findViewById(R.id.Input_uname);
        Input_uname.setText(R.string.Input_uname);

        TextView Text_password = findViewById(R.id.Text_Payment_Footer);
        Text_password.setText(R.string.Text_pw);

        EditText Input_password = findViewById(R.id.Input_password);
        Input_password.setText("");

        TextView Text_signinbtn = findViewById(R.id.Text_Payment_Name);
        Text_signinbtn.setText(R.string.Text_signinbtn);
    }
}
