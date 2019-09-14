package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MyProducts extends AppCompatActivity {

    DatabaseHelper_Products myDB;
    String[] productId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_products);

        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.listView2);
        myDB = new DatabaseHelper_Products(this);

        final ArrayList<String> thelist = new ArrayList<>();

        final Cursor data = myDB.getAllData();

        if (data.getCount() == 0) {
            Toast.makeText(MyProducts.this, "You didn't sell anything", Toast.LENGTH_LONG).show();
        } else {
            productId = new String[data.getCount()];
            int count = 0;

            while (data.moveToNext()) {
                productId[count] = data.getString(0);
                thelist.add("ID : "+data.getString(0)+" \n Product Name : " + data.getString(2) + " \n Product type : " + data.getString(3) +"\n Price : " + data.getString(5));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                listView.setAdapter(listAdapter);
                count++;

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
