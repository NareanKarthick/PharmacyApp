package com.example.pharmacyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBCart extends SQLiteOpenHelper {
    public static final String DBNAME = "Cart.db";

    public DBCart(Context context) {
        super(context,"Cart.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb) {
        Mydb.execSQL("create Table cart (products TEXT,rate INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int i, int i1) {
        Mydb.execSQL("drop Table if exists cart");
    }

    public Boolean insertData(String products,String rate){
        SQLiteDatabase MydB = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("products",products);
        contentvalues.put("rate",rate);

        long result;
        result = MydB.insert("cart",null,contentvalues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }


    }
}
