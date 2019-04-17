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

    DatabaseHelper db;

    private Button done,login;
    private EditText edtFname,edtLname,edtEmail,edtNpass,edtCpass;
    private RadioButton radioFemale, radioMale;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = new DatabaseHelper(this);

        done = findViewById(R.id.done);
        login = findViewById(R.id.login);
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
                String email = edtEmail.getText().toString();
                String Npass = edtNpass.getText().toString();
                String Cpass = edtCpass.getText().toString();
                if (email.equals("") || Npass.equals("") || Cpass.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields Are Empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (Npass.equals(Cpass)) {
                        Boolean chkemail = db.chkemail(email);

                        if (chkemail == true) {
                            Boolean insert = db.insert(email, Npass);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email Already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the first EditText empty
                Intent mIntent = new Intent(Signup.this, LoginMainActivity.class);
                //Set value to pass on next activity
                startActivity(mIntent);

            }
        });
    }}

