package com.example.pharmacyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText UserName,PassWord;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserName = (EditText) findViewById(R.id.username);
        PassWord = (EditText) findViewById(R.id.password);
        button = (Button) findViewById(R.id.loginbtn);
        db = new DBHelper(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = UserName.getText().toString();
                String pass = PassWord.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this,"Please enter the details",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuser = db.checkusernamepassword(user,pass);
                    if(checkuser==false){
                        Toast.makeText(MainActivity.this,"Check User or go to sign up ",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(MainActivity.this,"Users Already exists",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(),Home.class);
                        startActivity(i);
                    }
                }

            }
        });
    }
    public void clicksignup(View view){
        Intent i = new Intent(getApplicationContext(),signup.class);
        startActivity(i);
    }

    public void clickforget(View view){
        Intent i = new Intent(getApplicationContext(),forword.class);
        startActivity(i);
    }


}