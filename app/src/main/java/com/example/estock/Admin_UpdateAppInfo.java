package com.example.estock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_UpdateAppInfo extends AppCompatActivity {

    TextView aboutUs;
    TextView contactUs;
    EditText AboutUs;
    EditText ContactUs;
    Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__update_app_info);

        aboutUs = (TextView) findViewById(R.id.textView_about);
        contactUs = (TextView)findViewById(R.id.textView_contactus);
        AboutUs = (EditText)findViewById(R.id.editText_aboutUs);
        ContactUs = (EditText)findViewById(R.id.editText_contactUs);
        update = (Button)findViewById(R.id.btn_update);




    }


//    public void UpdateData() {
//        update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String productName = editName.getText().toString();
//                String Type = editType.getText().toString();
//                int qty = Integer.parseInt(editQty.getText().toString());
//                double price = Double.parseDouble(editPrice.getText().toString());
//                String productDesc = editDesc.getText().toString();
//                boolean isUpdated = myDb.updateData(editId.getText().toString(),myDb.getBytes(bitmap),productName, Type, qty,price,productDesc);
//
//                if(isUpdated == true) {
//                    Toast.makeText(UpdateDeleteMyProducts.this, "You have successfully updated the item", Toast.LENGTH_LONG).show();
//                    startActivity(new Intent(UpdateDeleteMyProducts.this, MyProducts.class));
//                } else {
//                    Toast.makeText(UpdateDeleteMyProducts.this, "Data not Updated", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }
}
