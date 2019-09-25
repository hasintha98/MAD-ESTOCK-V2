package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MyProducts extends AppCompatActivity {

    DatabaseHelper_Products myDB;
    String[] productId;
    EditText search_products;
    ArrayAdapter listAdapter;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_products);

        search_products = (EditText) findViewById(R.id.search_products);

        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.listView2);
        myDB = new DatabaseHelper_Products(this);

        final ArrayList<String> thelist = new ArrayList<>();

        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String Uname = prefs.getString("username", "No name defined");

        final Cursor data = myDB.getDataByUsername(Uname);

        if (data.getCount() == 0) {
            Toast.makeText(MyProducts.this, "You didn't sell anything", Toast.LENGTH_LONG).show();
        } else {
            productId = new String[data.getCount()];
            int count = 0;

            while (data.moveToNext()) {
                productId[count] = data.getString(0);
                thelist.add("ID : "+data.getString(0)+" \n Product Name : " + data.getString(2) + " \n Product type : " + data.getString(3) +"\n Price : " + data.getString(5));
                listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                listView.setAdapter(listAdapter);
                count++;

                search_products.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        (MyProducts.this).listAdapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

            }
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //final String productId = data.getString(0);
                    Toast.makeText(MyProducts.this, "rows "+productId[i], Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), UpdateDeleteMyProducts.class);
                    intent.putExtra("id",productId[i]);
                    startActivity(intent);

                }
            });
        }
    }
}
