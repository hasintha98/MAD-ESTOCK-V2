package com.example.estock;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class UpdateDeleteMyProducts extends AppCompatActivity {
    DatabaseHelper_Products myDb;
    ImageView productPhoto;
    EditText editName,editType,editQty,editId,editPrice,editDesc;

    Button btnUpdate,btnDelete;

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
        setContentView(R.layout.activity_update_delete_my_products);
        myDb = new DatabaseHelper_Products(getApplicationContext());

        productPhoto = (ImageView) findViewById(R.id.addPhoto);
        editName = (EditText)findViewById(R.id.editText_name);
        editType = (EditText) findViewById(R.id.editText_type);
        editQty = (EditText)findViewById(R.id.editText_qty);
        editPrice = (EditText) findViewById(R.id.editText_price);
        editDesc = (EditText) findViewById(R.id.editText_desc);
        editId = (EditText) findViewById(R.id.editText_id);
        btnUpdate = (Button) findViewById(R.id.button_update);
        btnDelete = (Button) findViewById(R.id.button_delete);



        int id = Integer.parseInt(getIntent().getStringExtra("id"));
        // Text_Product_ProductName.setText(String.valueOf(id));

        Cursor data = myDb.getDataById(id);
        Bitmap bt = null;
        while(data.moveToNext()) {
            byte[] imag = data.getBlob(1);
            bt = BitmapFactory.decodeByteArray(imag,0,imag.length);
            productPhoto.setImageBitmap(bt);
            editName.setText(data.getString(2));
            editType.setText(data.getString(3));
            editQty.setText(data.getString(4));
            editId.setText(data.getString(0));
            editPrice.setText(data.getString(5));
            editDesc.setText(data.getString(6));

        }


        //------Functions-----
        UpdateData();
        DeleteData();
        //--------------------

        productPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                showFileChooser();
            }
        });


    }
    private void showFileChooser()
    {
        ActivityCompat.requestPermissions(UpdateDeleteMyProducts.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PICK_IMAGE_REQUEST);

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    public void UpdateData() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productName = editName.getText().toString();
                String Type = editType.getText().toString();
                int qty = Integer.parseInt(editQty.getText().toString());
                double price = Double.parseDouble(editPrice.getText().toString());
                String productDesc = editDesc.getText().toString();
                boolean isUpdated = myDb.updateData(editId.getText().toString(),myDb.getBytes(bitmap),productName, Type, qty,price,productDesc);

                if(isUpdated == true) {
                    Toast.makeText(UpdateDeleteMyProducts.this, "You have successfully updated the item", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(UpdateDeleteMyProducts.this, MyProducts.class));
                } else {
                    Toast.makeText(UpdateDeleteMyProducts.this, "Data not Updated", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void DeleteData() {

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer DeletedRows = myDb.deleteDAata(editId.getText().toString());
                if(DeletedRows > 0) {
                    Toast.makeText(UpdateDeleteMyProducts.this, "You have successfully deleted the item", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(UpdateDeleteMyProducts.this, MainActivity.class));
                } else {
                    Toast.makeText(UpdateDeleteMyProducts.this, "Data not Deleted", Toast.LENGTH_LONG).show();
                }
            }

            });
        }


}
