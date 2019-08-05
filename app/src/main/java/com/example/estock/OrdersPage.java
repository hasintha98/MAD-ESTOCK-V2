package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class OrdersPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_page);

        TextView Text_MyOrders_Header = findViewById(R.id.Text_MyOrders_Header);
        Text_MyOrders_Header.setText(R.string.Text_MyOrders_Header);

        TextView Text_MyOrders_Text = findViewById(R.id.Text_MyOrders_Text);
        Text_MyOrders_Text.setText(R.string.Text_MyOrders_Text);

        TextView Text_MyOrders_Footer = findViewById(R.id.Text_MyOrders_Footer);
        Text_MyOrders_Footer.setText(R.string.Text_MyOrders_Footer);
    }
}
