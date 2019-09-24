package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class ProductPage extends AppCompatActivity {

    DatabaseHelper_Products myDB;
    DatabaseHelper_MyOrders mydb;
    ConstraintLayout Layout_buy;
    EditText  EditText_Product_qty;

    TextView Text_Product_ProductId, Text_Product_ProductName, Text_Product_Price, Text_Product_Description, Text_Product_Price2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        myDB = new DatabaseHelper_Products(this);


        ImageView imageView_productImage = findViewById(R.id.ImageView_productImage);
        Text_Product_ProductId = findViewById(R.id.Text_Product_ProductId);
        Text_Product_ProductName = findViewById(R.id.Text_Product_ProductName);
        Text_Product_Price = findViewById(R.id.Text_Product_Price);
        EditText_Product_qty = findViewById(R.id.EditText_Product_qty);
        Text_Product_Description = findViewById(R.id.Text_Product_Description);


        final TextView Text_Product_Price2 = findViewById(R.id.Text_Product_Price2);

        TextView Text_Product_Cart = findViewById(R.id.Text_Product_Buy);


//        Layout_buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(Cart.this, "Layout_checkout Clicked", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(Cart.this, paymentPage.class));

        TextView Text_Product_buy = findViewById(R.id.Text_Product_Buy);
        Text_Product_buy.setText("BUY");

        int id = Integer.parseInt(getIntent().getStringExtra("id"));
       // Text_Product_ProductName.setText(String.valueOf(id));

        Cursor data = myDB.getDataById(id);
        Bitmap bt = null;
        String qty = null;
        String price = null;
        while(data.moveToNext()) {
            String value= EditText_Product_qty.getText().toString();
           // int qty = Integer.parseInt(value);
            byte[] imag = data.getBlob(1);
            bt = BitmapFactory.decodeByteArray(imag,0,imag.length);
            imageView_productImage.setImageBitmap(bt);
            Text_Product_ProductName.setText(data.getString(2));
            Text_Product_ProductId.setText("Ref No. "+data.getString(0));
            Text_Product_Price.setText("Rs. "+data.getString(5)+" /=");

            price = data.getString(5);
            Text_Product_Price2.setText("Rs. "+data.getString(5));
            Text_Product_Description.setText("About the Item \n\n "+data.getString(6));
        }
        //--------functions------
        AddData();
        //-----------------------
    }
        public void AddData(){
          Layout_buy.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Toast.makeText(ProductPage.this, "Data lol inserted", Toast.LENGTH_LONG).show();

                             boolean isInserted = mydb.insertData(Text_Product_ProductId.getText().toString(),EditText_Product_qty.getText().toString(),Text_Product_Price2.getText().toString());

                            if(isInserted == true) {
                                Toast.makeText(ProductPage.this, "Data inserted", Toast.LENGTH_LONG).show();
                               // startActivity(new Intent(ProductPage.this, paymentPage.class));
                            }
                            else
                                Toast.makeText(ProductPage.this,"Data not inserted",Toast.LENGTH_LONG).show();


                        }

        }
        );
    }
}
        //String name = data.getString(2);

        //Text_Product_ProductName.setText(data.getString(2));
        //double price = Double.parseDouble(Text_Product_Price.getText().toString());
        //int qtyOut = Integer.parseInt(EditText_Product_qty.toString());
       // double priceOut = Double.parseDouble(price);

      // double total = priceOut * (double)qtyOut;
/*
        btn_qty_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
*/
       // Text_Product_Price2.setText(Double.toString(total));

       // double total = price * (double)qty;

        //Text_Product_Price2.setText(String.valueOf(total));


