package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class medicines extends AppCompatActivity {

    public EditText name;
    public Button submit;
    public Button addtocart;
    public TextView result_address,result_rate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicines);

        name = (EditText)findViewById(R.id.edit1);
        submit = (Button) findViewById(R.id.button1);
        addtocart = (Button) findViewById(R.id.button2);
        result_address = (TextView) findViewById(R.id.TextW1);
        result_rate = (TextView) findViewById(R.id.textView87);

    }

    public void Click2(View view){
        Toast.makeText(medicines.this,"Added to Cart",Toast.LENGTH_SHORT).show();
    }
    public void Click(View view){
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();

        //String s = name.getText().toString();
        String n = name.getText().toString();
        String address = databaseAccess.getAddress(n);
        String rate = databaseAccess.getRate(n);
        result_address.setText(address);
        result_rate.setText(rate);
        databaseAccess.close();

    }
}