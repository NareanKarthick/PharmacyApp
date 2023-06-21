package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class personalcare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalcare);
    }

    public void Click(View view){
        Toast.makeText(personalcare.this,"Added to Cart",Toast.LENGTH_SHORT).show();
    }
}