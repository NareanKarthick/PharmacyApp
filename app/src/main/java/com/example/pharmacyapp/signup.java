package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    String Name;
    String Email;
    DBHelper db;
    String Pword;
    String Address;
    String Gender;
    EditText name;
    EditText email;
    EditText pword;
    EditText age;
    EditText address;
    RadioButton rb;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = (EditText) findViewById(R.id.namebox);
        email = (EditText) findViewById(R.id.mailid);
        pword = (EditText) findViewById(R.id.userpassword);
        age = (EditText) findViewById(R.id.age);
        address = (EditText) findViewById(R.id.address);
        rg = (RadioGroup) findViewById(R.id.radiogroup);
        db = new DBHelper(this);

    }
    public void updateText(View view){
        int Radioid = rg.getCheckedRadioButtonId();
        if(Radioid != -1){
            rb = findViewById(Radioid);
            Name = name.getText().toString();
            Email = email.getText().toString();
            Pword = pword.getText().toString();
            Address = address.getText().toString();
            Gender = rb.getText().toString();
        }

        System.out.println("Button clicked");
    }
    public void details(View view){
        String user = name.getText().toString();
        String pass = pword.getText().toString();
        String mailid = email.getText().toString();
        String addr = address.getText().toString();
        String gender = null;
        int Radioid = rg.getCheckedRadioButtonId();
        if(Radioid != -1){
            rb = findViewById(Radioid);
            gender = rb.getText().toString();
        }
        String ag;
        ag = age.getText().toString();
        if(user.equals("")||mailid.equals("")||pass.equals("")||addr.equals("")||ag.equals("")||gender.equals("")){
            Toast.makeText(signup.this,"Please enter the details",Toast.LENGTH_SHORT).show();
        }
        else{
            Boolean checkuser = db.checkusername(user);
            if(checkuser ==false){
                Boolean insert = db.insertData(user,pass,mailid,addr,gender,ag);
                if(insert == true){
                    Toast.makeText(signup.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(signup.this,"Registered failed",Toast.LENGTH_SHORT).show();
                }
                }
                else{
                    Toast.makeText(signup.this,"User Already exists",Toast.LENGTH_SHORT).show();
                }
            }
        }


    }
