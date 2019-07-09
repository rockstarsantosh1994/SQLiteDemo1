package com.gmsoftech.sqlitedemo1.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.gmsoftech.sqlitedemo1.data.ProductData;

import java.util.ArrayList;

/**
 * Created by Admin on 9/19/2018.
 */

public class ProductModel {
    Context context;
    SQLiteDatabase db;

    public ProductModel(Context context) {
        this.context = context;
        DBHelper helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public long addProduct(ProductData product) {
        ContentValues values = new ContentValues();
        values.put(Tables.Product.Columns.PRODUCT_NAME, product.getProductName());
        values.put(Tables.Product.Columns.CATEGORY, product.getCategory());
        values.put(Tables.Product.Columns.PRICE, product.getPrice());
        values.put(Tables.Product.Columns.STOCK_QTY, product.getStkQty());
        long id = db.insert(Tables.Product.TABLE_NAME, null, values);
        return id;
    }

    public ArrayList<ProductData> getProducts() {
        Cursor cursor = db.query(Tables.Product.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
        ArrayList<ProductData> list = new ArrayList<>();

        while(cursor.moveToNext()) {
            long productId = cursor.getLong(cursor.getColumnIndex(Tables.Product.Columns.PRODUCT_ID));
            String productName = cursor.getString(cursor.getColumnIndex(Tables.Product.Columns.PRODUCT_NAME));
            String category = cursor.getString(cursor.getColumnIndex(Tables.Product.Columns.CATEGORY));
            float price = cursor.getFloat(cursor.getColumnIndex(Tables.Product.Columns.PRICE));
            int stkQty = cursor.getInt(cursor.getColumnIndex(Tables.Product.Columns.STOCK_QTY));

            ProductData product = new ProductData(productId, productName, category, price, stkQty);
            list.add(product);
        }

        return list;
    }

    public boolean updateProduct(ProductData product) {
        ContentValues values = new ContentValues();

        values.put(Tables.Product.Columns.PRODUCT_NAME, product.getProductName());
        values.put(Tables.Product.Columns.CATEGORY, product.getCategory());
        values.put(Tables.Product.Columns.PRICE, product.getPrice());
        values.put(Tables.Product.Columns.STOCK_QTY, product.getStkQty());

        String where = Tables.Product.Columns.PRODUCT_ID+"="+product.getProductId();
        int n = db.update(Tables.Product.TABLE_NAME, values, where, null);
        if ( n == 1 ) {
            return true;
        }

        return false;
    }

    public boolean deleteProduct(long  productId) {
        String where = Tables.Product.Columns.PRODUCT_ID+"="+productId;
        int n = db.delete(Tables.Product.TABLE_NAME, where, null);
        if ( n == 1 ) {
            return true;
        }

        return false;
    }


}
