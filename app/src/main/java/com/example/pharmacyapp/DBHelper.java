package com.example.pharmacyapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "Login.db";

    public DBHelper(Context context) {
        super(context,"Login.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Mydb) {
        Mydb.execSQL("create Table users(username TEXT,email TEXT,password TEXT,address TEXT,age TEXT,gender TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Mydb, int i, int i1) {
        Mydb.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username,String password,String email,String address,String gender,String age){
        SQLiteDatabase MydB = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("username",username);
        contentvalues.put("email",email);
        contentvalues.put("password",password);
        contentvalues.put("address",address);
        contentvalues.put("age",age);
        contentvalues.put("gender",gender);

        long result;
        result = MydB.insert("users",null,contentvalues);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }


    }

    public Boolean checkusername(String username){
        SQLiteDatabase MydB = this.getWritableDatabase();
        Cursor cursor = MydB.rawQuery("Select * from users where username = ?",new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase MydB = this.getWritableDatabase();
        Cursor cursor = MydB.rawQuery("Select * from users where username = ? and password = ?",new String[]{username,password});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public String forgetpass(String name) {
        SQLiteDatabase MydB = this.getReadableDatabase();
        String query = "SELECT password FROM Table_Name WHERE username= name ";
        try (Cursor cursor = MydB.rawQuery(query, null)) {
            if (cursor != null) {
                cursor.moveToFirst();
            }
            return cursor.toString();
        }
        catch (Exception e){
            return "ERROR";
        }


    }
}
