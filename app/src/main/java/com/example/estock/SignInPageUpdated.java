package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class SignInPageUpdated extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    private DatabaseHelper_SignUp DatabaseHelper_SignUp;//l
    DatabaseHelper_SignUp myDB;
    public static final String MY_PREFS_NAME = "MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page_updated);

        myDB = new DatabaseHelper_SignUp(this);

        TextView Text_signin = findViewById(R.id.Text_Signin_header);
        Text_signin.setText(R.string.Text_signin);

        TextView Text_name = findViewById(R.id.Text_name_signin1);
        Text_name.setText(R.string.Text_name);

        EditText Input_uname = findViewById(R.id.Input_uname);
        Input_uname.setText(R.string.Input_uname);

        TextView Text_password = findViewById(R.id.Text_Pwd_signin1);
        Text_password.setText(R.string.Text_pw);

        EditText Input_password = findViewById(R.id.Input_password);
        Input_password.setText("");

        Button Button_signinbtn = findViewById(R.id.Text_sign_in_button);
        Button_signinbtn.setText(R.string.Button_signinbtn);

        TextView Text_forgot = findViewById(R.id.foget);
        Text_forgot.setText(R.string.Text_forgot);

        TextView Text_register = findViewById(R.id.register_signin);
        Text_register.setText(R.string.Text_register);

        TextView attemptCount = findViewById(R.id.attemt_count);
        attemptCount.setText(R.string.attemptCount);

        TextView Text_attemptCount = findViewById(R.id.attemt_count_text);
        Text_attemptCount.setText(R.string.Text_attemptCount);

        CheckBox Text_check = findViewById(R.id.checkBox);
        Text_check.setText(R.string.Text_check);

        Text_register.setOnClickListener(new View.OnClickListener(){
            public void  onClick(View view){
                Intent registerIntent = new Intent(SignInPageUpdated.this, SignUpPage.class);
                startActivity(registerIntent);
            }
        });

        username = (EditText)findViewById(R.id.Input_uname);
        password = (EditText)findViewById(R.id.Input_password);
        login = (Button)findViewById(R.id.Text_sign_in_button);

        DatabaseHelper_SignUp = new DatabaseHelper_SignUp(SignInPageUpdated.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isExist = DatabaseHelper_SignUp.checkUserExist(username.getText().toString(), password.getText().toString());

                if(isExist){
                    SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putString("username", username.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(SignInPageUpdated.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(SignInPageUpdated.this, "You have successfully sign in", Toast.LENGTH_SHORT).show();

                } else if(username.getText().toString().equals("123") && password.getText().toString().equals("123")) {
                    Intent intent = new Intent(SignInPageUpdated.this, Admin.class);
                    startActivity(intent);
                    Toast.makeText(SignInPageUpdated.this, "success", Toast.LENGTH_SHORT).show();

                }else {
                    password.setText(null);
                    Toast.makeText(SignInPageUpdated.this, "Login failed. Invalid username or password.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    void checkUsername(){
        boolean isValid = true;
        if(isEmpty(username)){
            username.setError("You must enter username to login!");
            isValid = false;
        }else{
            if(!isEmail(username)){
                username.setError("Enter valid emai!");
                isValid = false;
            }
        }

        if (isEmpty(password)){
            password.setError("You must enter password to login!");
            isValid = false;
        }else {
            if (password.getText().toString().length()<8){
                password.setError("Password must be at least 8 chars long!");
            }
        }

        if (isValid){
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();
//mmmmmmmmmmmmmmmmmmm
        }
    }

    boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}
