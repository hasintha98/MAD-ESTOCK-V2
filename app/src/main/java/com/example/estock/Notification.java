package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        TextView Text_notification = findViewById(R.id.Text_notification);
        Text_notification.setText(R.string.Text_notification);
        TextView Text_noreceivenotifi = findViewById(R.id.Text_noreceivenotifi);
        Text_noreceivenotifi.setText(R.string.Text_noreceivenotifi);
    }
}
