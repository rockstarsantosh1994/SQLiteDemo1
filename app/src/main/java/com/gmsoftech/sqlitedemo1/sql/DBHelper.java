package com.gmsoftech.sqlitedemo1.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 9/19/2018.
 */

public class DBHelper extends SQLiteOpenHelper{
    final static int version = 1;
    static final String name = "shopDb";
    Context context;

    public DBHelper(Context context) {
        super(context, name, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(Tables.Product.CREATE_PRODUCT_TABLE);
        } catch(SQLiteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
