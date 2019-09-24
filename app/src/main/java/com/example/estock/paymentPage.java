package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class paymentPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);

        TextView Text_Payment_Header = findViewById(R.id.Text_Payment_Header);
        Text_Payment_Header.setText(R.string.Text_Payment_Header);

        TextView Text_Payment_Header2 = findViewById(R.id.Text_Payment_Header2);
        Text_Payment_Header2.setText(R.string.Text_Payment_Header2);

        TextView Text_Payment_Name = findViewById(R.id.Text_Payment_Name);
        Text_Payment_Name.setText(R.string.Text_Payment_Name);

        TextView Text_Payment_Card_Number = findViewById(R.id.Text_Payment_Card_Number);
        Text_Payment_Card_Number.setText(R.string.Text_Payment_Card_Number);

        TextView Text_Payment_Security = findViewById(R.id.Text_Payment_Security);
        Text_Payment_Security.setText(R.string.Text_Payment_Security);

        TextView Text_Payment_Expiry_Date = findViewById(R.id.Text_Payment_Expiry_Date);
        Text_Payment_Expiry_Date.setText(R.string.Text_Payment_Expiry_Date);

        TextView Text_Payment_Email = findViewById(R.id.Text_Payment_Email);
        Text_Payment_Email.setText(R.string.Text_Payment_Email);

        TextView Text_Payment_Cancel = findViewById(R.id.Text_Payment_Cancel);
        Text_Payment_Cancel.setText(R.string.Text_Payment_Cancel);

        TextView Text_Payment_Done = findViewById(R.id.Text_Profile_name);
        Text_Payment_Done.setText(R.string.Text_Payment_Done);

        TextView Text_Payment_Footer = findViewById(R.id.Text_Payment_Footer);
        Text_Payment_Footer.setText(R.string.Text_Payment_Footer);
    }
}
