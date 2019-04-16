package com.example.group_4_shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import android.widget.Toast;


public class Signup extends AppCompatActivity {

    private Button done;
    private Button clear;
    private EditText edtFname,edtLname,edtEmail,edtNpass,edtCpass;
    private RadioButton radioFemale, radioMale;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        done = findViewById(R.id.done);
        clear = findViewById(R.id.clear);
        edtFname = findViewById(R.id.edtFname);
        edtLname = findViewById(R.id.edtLname);
        edtEmail = findViewById(R.id.edtEmail);
        edtNpass = findViewById(R.id.edtNpass);
        edtCpass = findViewById(R.id.edtCpass);
        radioFemale = findViewById(R.id.radioFemale);
        radioMale = findViewById(R.id.radioMale);


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(Signup.this, LoginMainActivity.class);
                //Set value to pass on next activity
                startActivity(mIntent);
                String SignedIn = "Successfully Signed In";
                Toast.makeText(Signup.this, SignedIn, Toast.LENGTH_LONG).show();

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the first EditText empty
                edtCpass.setText("");
                edtEmail.setText("");
                edtNpass.setText("");
                edtFname.setText("");
                edtLname.setText("");
                radioFemale.setChecked(false);
                radioMale.setChecked(false);

            }
        });
    }}

