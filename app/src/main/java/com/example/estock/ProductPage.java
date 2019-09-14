package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class ProductPage extends AppCompatActivity {

    DatabaseHelper_Products myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        myDB = new DatabaseHelper_Products(this);


        ImageView imageView_productImage = findViewById(R.id.ImageView_productImage);
        TextView Text_Product_ProductId = findViewById(R.id.Text_Product_ProductId);
        TextView Text_Product_ProductName = findViewById(R.id.Text_Product_ProductName);
        TextView Text_Product_Price = findViewById(R.id.Text_Product_Price);
        EditText EditText_Product_qty = findViewById(R.id.EditText_Product_qty);
        TextView Text_Product_Description = findViewById(R.id.Text_Product_Description);


        TextView Text_Product_Price2 = findViewById(R.id.Text_Product_Price2);

        TextView Text_Product_Cart = findViewById(R.id.Text_Product_Cart);
        Text_Product_Cart.setText(R.string.Text_Product_Cart);


        int id = Integer.parseInt(getIntent().getStringExtra("id"));
       // Text_Product_ProductName.setText(String.valueOf(id));

        Cursor data = myDB.getDataById(id);
        Bitmap bt = null;
        while(data.moveToNext()) {
            String value= EditText_Product_qty.getText().toString();
           // int qty = Integer.parseInt(value);
            byte[] imag = data.getBlob(1);
            bt = BitmapFactory.decodeByteArray(imag,0,imag.length);
            imageView_productImage.setImageBitmap(bt);
            Text_Product_ProductName.setText(data.getString(2));
            Text_Product_ProductId.setText("Ref No. "+data.getString(0));
            Text_Product_Price.setText("Rs. "+data.getString(5)+" /=");
            double price = Double.parseDouble(data.getString(5));
            Text_Product_Price2.setText("Rs. "+data.getString(5));
            Text_Product_Description.setText("About the Item \n\n "+data.getString(6));
        }
        //String name = data.getString(2);

        //Text_Product_ProductName.setText(data.getString(2));
        //double price = Double.parseDouble(Text_Product_Price.getText().toString());



       // double total = price * (double)qty;

        //Text_Product_Price2.setText(String.valueOf(total));


    }
}
