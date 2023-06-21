package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    int getvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent i = getIntent();
        getvalue = i.getIntExtra("val",1);

    }
    public void movesup(View view){
        Intent i = new Intent(getApplicationContext(),supplements.class);
        startActivity(i);
    }
    public void clickoff(View view){
        Intent i = new Intent(getApplicationContext(),Best_offer.class);
        startActivity(i);
    }
    public void medicineon(View view){
        Intent i = new Intent(getApplicationContext(),medicines.class);
        startActivity(i);
    }
    public void labtests(View view){
        Intent i = new Intent(getApplicationContext(),labtest.class);
        startActivity(i);
    }
}