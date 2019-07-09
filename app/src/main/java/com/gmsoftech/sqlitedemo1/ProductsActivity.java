package com.gmsoftech.sqlitedemo1;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.gmsoftech.sqlitedemo1.adapter.ProductAdapter;
import com.gmsoftech.sqlitedemo1.data.ProductData;
import com.gmsoftech.sqlitedemo1.sql.ProductModel;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {
    Context context;
    ArrayList<ProductData> list;
    ListView lvProducts;
    ProductAdapter adapter;
    ProductModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        context = this;
        lvProducts = findViewById(R.id.lvProducts);
        model = new ProductModel(context);
        list = model.getProducts();
        adapter = new ProductAdapter(context,list);
        lvProducts.setAdapter(adapter);
        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
              showProductDetails(list.get(position));
            }
        });
    }
        private void showProductDetails(final ProductData productData) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        View view = getLayoutInflater().inflate(R.layout.dialog_product_details, null);
        final EditText etProductName = view.findViewById(R.id.etProductName);
        final EditText etCategory  = view.findViewById(R.id.etCategory);
        final EditText etPrice = view.findViewById(R.id.etPrice);
        final EditText etStockQty = view.findViewById(R.id.etStkQty);

        builder.setView(view);

        etProductName.setText(productData.getProductName());
        etCategory.setText(productData.getCategory());
        etPrice.setText(""+productData.getPrice());
        etStockQty.setText(""+productData.getStkQty());
        builder.setTitle("Product Details");
        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                long id = productData.getProductId();
                String productName = etProductName.getText().toString();
                String category = etCategory.getText().toString();
                float price = Float.parseFloat(etPrice.getText().toString());
                int stockQty= Integer.parseInt(etStockQty.getText().toString());

                ProductData newData = new ProductData(id, productName, category, price, stockQty);
                boolean updated = model.updateProduct(newData);
                if ( updated) {
                    Toast.makeText(context, "Student updated successfully", Toast.LENGTH_LONG).show();
                    reloadData();
                } else {
                    Toast.makeText(context, "Failed to update. Retry", Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean deleted = model.deleteProduct(productData.getProductId());
                if(deleted) {
                    Toast.makeText(context, "Student record deleted successfully", Toast.LENGTH_LONG).show();
                    reloadData();
                } else {
                    Toast.makeText(context, "Failed to delete product. Retry.", Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.create().show();
    }

    private void reloadData() {
        list.clear();
        list = model.getProducts();
        adapter = new ProductAdapter(context, list);
        lvProducts.setAdapter(adapter);
    }
}
