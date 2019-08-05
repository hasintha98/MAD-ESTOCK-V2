package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class ProductPage extends AppCompatActivity {

    String [] SPINNERLIST={"1","2","3","4","5"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,SPINNERLIST);
        MaterialBetterSpinner betterSpinner=(MaterialBetterSpinner)findViewById(R.id.android_material_design_spinner);
        betterSpinner.setAdapter(arrayAdapter);


        TextView Text_Product_ProductName = findViewById(R.id.Text_Product_ProductName);
        Text_Product_ProductName.setText(R.string.Text_Product_ProductName);

        TextView Text_Product_Price = findViewById(R.id.Text_Product_Price);
        Text_Product_Price.setText(R.string.Text_Product_Price);

        TextView Text_Product_Description = findViewById(R.id.Text_Product_Description);
        Text_Product_Description.setText(R.string.Text_Product_Description);

        TextView Text_Product_Price2 = findViewById(R.id.Text_Product_Price2);
        Text_Product_Price2.setText(R.string.Text_Product_Price2);

        TextView Text_Product_Cart = findViewById(R.id.Text_Product_Cart);
        Text_Product_Cart.setText(R.string.Text_Product_Cart);
    }
}
