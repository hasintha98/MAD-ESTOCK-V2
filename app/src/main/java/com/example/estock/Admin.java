package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {
    Button btn_appinfo, btn_viewall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        btn_appinfo = (Button)findViewById(R.id.btn_appinfo);
        btn_viewall = (Button)findViewById(R.id.btn_viewall);

        btn_appinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin.this, Admin_UpdateAppInfo.class));
            }
        });

        btn_viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin.this, Admin_ViewAll.class));
            }
        });



    }
}
