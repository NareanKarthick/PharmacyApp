package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class supplements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplements);
    }
    public void pcfun(View view){
        Intent i = new Intent(getApplicationContext(),personalcare.class);
        startActivity(i);
    }
    public void scfun(View view){
        Intent i = new Intent(getApplicationContext(),skincare.class);
        startActivity(i);
    }
    public void hfdfun(View view){
        Intent i = new Intent(getApplicationContext(),Healthfood.class);
        startActivity(i);
    }
}