package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

public class Admin_DeleteProducts extends AppCompatActivity {

    Button btnDelete;
    ImageView productPhoto;
    DatabaseHelper_Products myDb;
    TextView Text_id,Text_name,Text_type,Text_qty,Text_price,Text_desc,Text_seller;

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    private static final int PICK_IMAGE_REQUEST = 234;
    Bitmap bitmap;
    Uri filePath;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try
            {

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                productPhoto.setImageBitmap(bitmap);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__delete_products);

        myDb = new DatabaseHelper_Products(this);

        btnDelete = findViewById(R.id.btnDelete);
        productPhoto = (ImageView) findViewById(R.id.productPhoto);
        Text_id = (TextView) findViewById(R.id.Text_id);
        Text_name = (TextView) findViewById(R.id.Text_name);
        Text_type = (TextView) findViewById(R.id.Text_type);
        Text_qty = (TextView) findViewById(R.id.Text_qty);
        Text_price = (TextView) findViewById(R.id.Text_price);
        Text_desc = (TextView) findViewById(R.id.Text_desc);
        Text_seller = (TextView) findViewById(R.id.Text_seller);

        int id = Integer.parseInt(getIntent().getStringExtra("id"));
        // Text_Product_ProductName.setText(String.valueOf(id));

        Cursor data = myDb.getDataById(id);
        Bitmap bt = null;
        while(data.moveToNext()) {
            byte[] imag = data.getBlob(1);
            bt = BitmapFactory.decodeByteArray(imag,0,imag.length);
            productPhoto.setImageBitmap(bt);
            Text_name.setText(data.getString(2));
            Text_type.setText(data.getString(3));
            Text_qty.setText(data.getString(4));
            Text_id.setText(data.getString(0));
            Text_price.setText(data.getString(5));
            Text_desc.setText(data.getString(6));
            Text_seller.setText(data.getString(7));

        }

        DeleteData();
    }

    public void DeleteData() {

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer DeletedRows = myDb.deleteDAata(Text_id.getText().toString());
                if(DeletedRows > 0) {
                    Toast.makeText(Admin_DeleteProducts.this, "You have successfully deleted the item", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Admin_DeleteProducts.this, Admin_ViewAll.class));
                } else {
                    Toast.makeText(Admin_DeleteProducts.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
