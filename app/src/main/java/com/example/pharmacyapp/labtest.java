package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class labtest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_labtest);
    }

    public void Click(View view){
        Toast.makeText(labtest.this,"Test Booked",Toast.LENGTH_SHORT).show();
    }
}