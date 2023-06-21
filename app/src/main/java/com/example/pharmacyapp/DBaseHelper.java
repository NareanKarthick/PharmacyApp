package com.example.pharmacyapp;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DBaseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "med.db";
    private static final int DATABASE_VERSION = 1;

    public DBaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


}
