package com.example.estock;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ProductListPage extends AppCompatActivity {

    ImageView mobileProduct2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mobileProduct2 = (ImageView) findViewById(R.id.mobileProduct2);

        mobileProduct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ProductListPage.this, "IphoneX Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProductListPage.this, ProductPage.class));
            }
        });
    }
}
