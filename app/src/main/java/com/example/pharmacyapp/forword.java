package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forword extends AppCompatActivity {

    EditText User;
    EditText pass;
    Button sub;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forword);
        User = (EditText) findViewById(R.id.username1);
        pass = (EditText) findViewById(R.id.password1);
        sub = (Button) findViewById(R.id.submitbtn);
        db = new DBHelper(this);
    }
    public void forget(View view){
        String username = User.getText().toString();
        String cursor = db.forgetpass(username);
        Toast.makeText(forword.this," "+cursor,Toast.LENGTH_SHORT).show();
        /*Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);*/
    }
}