package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.regex.Pattern;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.widget.Toast;
import android.text.TextUtils;
import android.view.View;
public class SignUpPage extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-z])" +
                    "(?=.*[A-Z])" +
                    "(?=.*[@#$%^+=])" +
                    "(?=\\S+$)" + //not white spaces
                    ".{8,}" + // at least 6 characters
                    "$");
    Button b_register;
    EditText user_name, user_email, user_password, user_confirmpassword;

    DatabaseHelper_SignUp myDB;

//    String NameHolder, EmailHolder, PasswordHolder;
//    Boolean EditTextEmptyHolder;
//    SQLiteDatabase sqLiteDatabaseObj;
//    String SQLiteDataBaseQueryHolder ;
//   // DatabaseHelper_SignUp sqLiteHelper;
//    Cursor cursor;
//    String F_Result = "Not_Found";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        myDB = new DatabaseHelper_SignUp(this);

        TextView Text_signup = findViewById(R.id.Text_header_signUp);
        Text_signup.setText(R.string.Text_signup);

        TextView Text_namesignup = findViewById(R.id.Text_Security_name);
        Text_namesignup.setText(R.string.Text_namesignup);

        EditText Input_namesignup = findViewById(R.id.name_signup);
        Input_namesignup.setText(R.string.Input_namesignup);

        TextView Text_email = findViewById(R.id.Text_SignUp_Email);
        Text_email.setText(R.string.Text_email);

        EditText Input_email = findViewById(R.id.email_signup);
        Input_email.setText(R.string.Input_email);

        TextView Text_pw = findViewById(R.id.pwd_Signup);
        Text_pw.setText(R.string.Text_pw);

        EditText Input_pw = findViewById(R.id.input_pwd_signup);
        Input_pw.setText(R.string.Input_pw);

        TextView Text_con_pw = findViewById(R.id.confirm_signup_pwd);
        Text_con_pw.setText(R.string.Text_con_pw);

        EditText Input_con_pw = findViewById(R.id.input_con_pwd);
        Input_con_pw.setText(R.string.Input_con_pw);

        TextView note_si = findViewById(R.id.note_signup);
        note_si.setText(R.string.note_si);

        Button Text_signupbtn = findViewById(R.id.sign_up_button);
        Text_signupbtn.setText(R.string.Text_signupbtn);


        b_register = (Button) findViewById(R.id.sign_up_button);
        user_name = (EditText) findViewById(R.id.name_signup);
        user_email = (EditText) findViewById(R.id.email_signup);
        user_password = (EditText) findViewById(R.id.input_pwd_signup);
        user_confirmpassword = (EditText) findViewById(R.id.input_con_pwd);

        AddData();




  //      b_register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                SQLiteDataBaseBuild();
//                SQLiteTableBuild();
////                CheckEditTextStatus();
////                CheckingEmailAlreadyExistsOrNot();
////                EmptyEditTextAfterDataInsert();

//                    if (user_password.equals(user_confirmpassword)) {
//                    Intent RegisterIntent = new Intent(SignUpPage.this, SignInPageUpdated.class);
//                    startActivity(RegisterIntent);
//                     }
//
//                }
//
//        });


    }

    boolean validateUsername() {
        String usernameInput = user_name.getText().toString().trim();

        if (usernameInput.isEmpty()){
            user_name.setError("User name can't be empty");
        return false;
    }else {
            user_name.setError(null);
            return true;
        }

    }

    boolean validateEmail() {
        String emailInput = user_email.getText().toString().trim();

        if (emailInput.isEmpty()) {
            user_email.setError("Email can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            user_email.setError("Please enter a valid email address");
            return false;
        } else {
            user_email.setError(null);
            return true;
        }
    }

    boolean validatePassword() {
        String passwordInput = user_password.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            user_password.setError("Password can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            user_password.setError("Password too week");
            return false;
        } else {
            user_password.setError(null);
            return true;
        }
    }



    boolean checkDataEntered(){
        validateUsername();
        validateEmail();
        validatePassword();

        return true;
    }

    public void AddData() {
        b_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //
                checkDataEntered();
                //if (user_password == user_confirmpassword) {
                    boolean isInserted = myDB.insertData(
                            user_name.getText().toString(),
                            user_email.getText().toString(),
                            user_password.getText().toString());


                    if (isInserted == true) {
                        Toast.makeText(SignUpPage.this, "Register successful", Toast.LENGTH_LONG).show();
                        user_confirmpassword.getText().toString();

                        Intent RegisterIntent = new Intent(SignUpPage.this, SignInPageUpdated.class);
                        startActivity(RegisterIntent);
                    }
               // }
                else {
                        Toast.makeText(SignUpPage.this, "data not inserted", Toast.LENGTH_SHORT).show();
                   }
                }


           // }
        });
    }

//    public void SQLiteDataBaseBuild(){
//
//        sqLiteDatabaseObj = openOrCreateDatabase(DatabaseHelper_SignUp.DATABASE_NAME, Context.MODE_PRIVATE, null);
//
//    }
//
//    // SQLite table build method.
//    public void SQLiteTableBuild() {
//
//        //sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + DatabaseHelper_SignUp.TABLE_NAME + "(" + DatabaseHelper_SignUp.ID + " PRIMARY KEY AUTOINCREMENT NOT NULL, " + DatabaseHelper_SignUp.UserName + " VARCHAR, " + DatabaseHelper_SignUp.Email + " VARCHAR, " + DatabaseHelper_SignUp.Password + " VARCHAR);");
//
//    }
}
