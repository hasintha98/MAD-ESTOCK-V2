package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Admin_ViewAll extends AppCompatActivity {

    DatabaseHelper_Products myDB;
    String[] productId;
    ArrayAdapter listAdapter;
    EditText search_products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__view_all);

        search_products = (EditText) findViewById(R.id.search_products);

        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.listView3);
        myDB = new DatabaseHelper_Products(this);

        final ArrayList<String> thelist = new ArrayList<>();

        final Cursor data = myDB.getAllData();

        if (data.getCount() == 0) {
            Toast.makeText(Admin_ViewAll.this, "You didn't sell anything", Toast.LENGTH_LONG).show();
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
                        (Admin_ViewAll.this).listAdapter.getFilter().filter(charSequence);
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
                    Toast.makeText(Admin_ViewAll.this, "rows "+productId[i], Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Admin_DeleteProducts.class);
                    intent.putExtra("id",productId[i]);
                    startActivity(intent);

                }
            });
        }
    }
}