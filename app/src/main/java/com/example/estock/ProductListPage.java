package com.example.estock;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProductListPage extends AppCompatActivity {

    DatabaseHelper_Products myDB;
    String[] productId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list_page);


        android.widget.ListView listView = (android.widget.ListView) findViewById(R.id.listView);
        myDB = new DatabaseHelper_Products(this);

        final ArrayList<String> thelist = new ArrayList<>();

       int id = getIntent().getIntExtra("id",0);
        if(id == 1) {
            final Cursor data = myDB.getTypeData("Mobile");

            if (data.getCount() == 0) {
                Toast.makeText(ProductListPage.this, "Mobiles are not available", Toast.LENGTH_LONG).show();
            } else {
                productId = new String[data.getCount()];
                int count = 0;

                while (data.moveToNext()) {
                    productId[count] = data.getString(0);
                    thelist.add("Product Name : " + data.getString(2) + " \n Product type : " + data.getString(3) +"\n Price : " + data.getString(5));
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                    listView.setAdapter(listAdapter);
                    count++;

                }
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            //final String productId = data.getString(0);
                            Toast.makeText(ProductListPage.this, "rows "+productId[i], Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), ProductPage.class);
                            intent.putExtra("id",productId[i]);
                            startActivity(intent);

                    }
                });
            }
        } else if(id == 2) {
            Cursor data = myDB.getTypeData("Clothing");

            if (data.getCount() == 0) {
                Toast.makeText(ProductListPage.this, "Clothing are not available", Toast.LENGTH_LONG).show();
            } else {
                productId = new String[data.getCount()];
                int count = 0;

                while (data.moveToNext()) {
                    productId[count] = data.getString(0);
                    thelist.add("Product Name : " + data.getString(2) + " \n Product type : " + data.getString(3) +"\n Price : " + data.getString(5));
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                    listView.setAdapter(listAdapter);
                    count++;

                }
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //final String productId = data.getString(0);
                        Toast.makeText(ProductListPage.this, "rows "+productId[i], Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ProductPage.class);
                        intent.putExtra("id",productId[i]);
                        startActivity(intent);

                    }
                });
            }
        }else if(id == 3) {
            Cursor data = myDB.getTypeData("Cosmetics");

            if (data.getCount() == 0) {
                Toast.makeText(ProductListPage.this, "Cosmetics are not available", Toast.LENGTH_LONG).show();
            } else {
                productId = new String[data.getCount()];
                int count = 0;

                while (data.moveToNext()) {
                    productId[count] = data.getString(0);
                    thelist.add("Product Name : " + data.getString(2) + " \n Product type : " + data.getString(3) +"\n Price : " + data.getString(5));
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                    listView.setAdapter(listAdapter);
                    count++;

                }
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //final String productId = data.getString(0);
                        Toast.makeText(ProductListPage.this, "rows "+productId[i], Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ProductPage.class);
                        intent.putExtra("id",productId[i]);
                        startActivity(intent);

                    }
                });
            }
        } else if(id == 4) {
            Cursor data = myDB.getTypeData("Electronics");

            if (data.getCount() == 0) {
                Toast.makeText(ProductListPage.this, "Electronics are not available", Toast.LENGTH_LONG).show();
            } else {
                productId = new String[data.getCount()];
                int count = 0;

                while (data.moveToNext()) {
                    productId[count] = data.getString(0);
                    thelist.add("Product Name : " + data.getString(2) + " \n Product type : " + data.getString(3) +"\n Price : " + data.getString(5));
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                    listView.setAdapter(listAdapter);
                    count++;

                }
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //final String productId = data.getString(0);
                        Toast.makeText(ProductListPage.this, "rows "+productId[i], Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ProductPage.class);
                        intent.putExtra("id",productId[i]);
                        startActivity(intent);

                    }
                });
            }
        } else if(id == 5) {
            Cursor data = myDB.getTypeData("Furniture");

            if (data.getCount() == 0) {
                Toast.makeText(ProductListPage.this, "Furniture are not available", Toast.LENGTH_LONG).show();
            } else {
                productId = new String[data.getCount()];
                int count = 0;

                while (data.moveToNext()) {
                    productId[count] = data.getString(0);
                    thelist.add("Product Name : " + data.getString(2) + " \n Product type : " + data.getString(3) +"\n Price : " + data.getString(5));
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                    listView.setAdapter(listAdapter);
                    count++;

                }
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //final String productId = data.getString(0);
                        Toast.makeText(ProductListPage.this, "rows "+productId[i], Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ProductPage.class);
                        intent.putExtra("id",productId[i]);
                        startActivity(intent);

                    }
                });
            }
        } else if(id == 6) {
            Cursor data = myDB.getTypeData("Other");

            if (data.getCount() == 0) {
                Toast.makeText(ProductListPage.this, "Other are not available", Toast.LENGTH_LONG).show();
            } else {
                productId = new String[data.getCount()];
                int count = 0;

                while (data.moveToNext()) {
                    productId[count] = data.getString(0);
                    thelist.add("Product Name : " + data.getString(2) + " \n Product type : " + data.getString(3) +"\n Price : " + data.getString(5));
                    ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, thelist);
                    listView.setAdapter(listAdapter);
                    count++;

                }
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //final String productId = data.getString(0);
                        Toast.makeText(ProductListPage.this, "rows "+productId[i], Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ProductPage.class);
                        intent.putExtra("id",productId[i]);
                        startActivity(intent);

                    }
                });
            }
        }else {
            Toast.makeText(ProductListPage.this, "not working", Toast.LENGTH_LONG).show();
        }
    }
}
