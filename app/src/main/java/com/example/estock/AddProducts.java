package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

public class AddProducts extends AppCompatActivity {
    DatabaseHelper_Products myDb;
    ImageView productPhoto;
    EditText editName,editType,editQty,editdesc,editPrice;
    Spinner spinnerType;
    Button btnAddData;
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
        setContentView(R.layout.activity_add_products);

        myDb = new DatabaseHelper_Products(getApplicationContext());

        productPhoto = (ImageView) findViewById(R.id.productPhoto);
        editName = (EditText)findViewById(R.id.Text_name);
        spinnerType = (Spinner) findViewById(R.id.spinner_type);
        editQty = (EditText)findViewById(R.id.Text_qty);
        editPrice = (EditText) findViewById(R.id.Text_price);
        editdesc = (EditText) findViewById(R.id.Text_desc);
        btnAddData = (Button) findViewById(R.id.button_add);


        //------------functions--------
        AddData();
        //-----------------------------


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
        ActivityCompat.requestPermissions(AddProducts.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                PICK_IMAGE_REQUEST);

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }


    public void AddData() {
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bitmap == null)
                {
                    Toast.makeText(AddProducts.this, "No Image Selected", Toast.LENGTH_SHORT).show();
                    return;
                }
                String productName = editName.getText().toString();
                String Type = spinnerType.getSelectedItem().toString();
                int qty = Integer.parseInt(editQty.getText().toString());
                double price = Double.parseDouble(editPrice.getText().toString());
                String productDesc = editdesc.getText().toString();
                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                String Uname = prefs.getString("username", "No name defined");
                boolean isInserted =  myDb.insertData(myDb.getBytes(bitmap),productName, Type, qty,price,productDesc,Uname);

               if(isInserted == true) {
                    Toast.makeText(AddProducts.this, "You have successfully sell the item", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(AddProducts.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
