package com.gmsoftech.sqlitedemo1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gmsoftech.sqlitedemo1.data.ProductData;
import com.gmsoftech.sqlitedemo1.sql.ProductModel;

public class MainActivity extends AppCompatActivity {
    Context context;
    EditText etProductName, etPrice, etCategory, etStkWty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        etProductName = findViewById(R.id.etProductName);
        etPrice = findViewById(R.id.etPrice);
        etCategory = findViewById(R.id.etCategory);
        etStkWty = findViewById(R.id.etStkQty);
    }

    public void saveProduct(View view) {
        String productName = etProductName.getText().toString();
        String category = etCategory.getText().toString();
        float price = Float.parseFloat(etPrice.getText().toString());
        int stkQty = Integer.parseInt(etStkWty.getText().toString());

        ProductModel productModel = new ProductModel(context);

        ProductData data = new ProductData(productName, category, price, stkQty);
        long id = productModel.addProduct(data);
        if ( id != -1) {
            Toast.makeText(context, "Product added with id : "+id, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Failed add prodcut", Toast.LENGTH_LONG).show();
        }
    }

    public void showProducts(View view) {
        Intent intent = new Intent(this, ProductsActivity.class);
        startActivity(intent);
    }


}
