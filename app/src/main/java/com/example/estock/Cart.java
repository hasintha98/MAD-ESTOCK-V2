package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Cart extends AppCompatActivity {

    ConstraintLayout Layout_checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Layout_checkout = (ConstraintLayout) findViewById(R.id.Layout_checkout) ;

        Layout_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Cart.this, "Layout_checkout Clicked", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Cart.this, paymentPage.class));
            }
        });
    }
}
