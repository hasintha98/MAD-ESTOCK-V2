package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;

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
    }
}
