package com.gmsoftech.sqlitedemo1.sql;

/**
 * Created by Admin on 9/19/2018.
 */

public class Tables {

    public static class Product {
        public static final String TABLE_NAME = "product";
        public static final String CREATE_PRODUCT_TABLE =
                "CREATE TABLE product" +
                        "(" +
                        "productId integer primary key autoincrement," +
                        "productName text," +
                        "price float," +
                        "category text," +
                        "stockQty integer" +
                        ")";

        public static class Columns {
            public static final String PRODUCT_ID = "productId",
                PRODUCT_NAME = "productName",
                PRICE = "price",
                CATEGORY = "category",
                STOCK_QTY = "stockQty";
        }
    }
}
