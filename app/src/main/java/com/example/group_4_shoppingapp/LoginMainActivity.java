package com.example.group_4_shoppingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class LoginMainActivity extends AppCompatActivity {

    private EditText edtUserEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        edtUserEmail = findViewById(R.id.edtUserEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtUserEmail.getText().toString();
                String pwd = edtPassword.getText().toString();

                if (email.equals("admin") && pwd.equals("admin@123")) {
                    //Navigate to NEXT Activity
                    Intent mIntent = new Intent(LoginMainActivity.this, HomeActivity.class);
                    //Set value to pass on next activity
                    startActivity(mIntent);
                } else if (email.equals("") && pwd.equals("")) {
                    String err = "Empty Fields Not Allowed";
                    Toast.makeText(LoginMainActivity.this, err, Toast.LENGTH_LONG).show();
                } else {
                    String err1 = "Invalid E-mail/Password";
                    Toast.makeText(LoginMainActivity.this, err1, Toast.LENGTH_LONG).show();
                }
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(LoginMainActivity.this, Signup.class);
                //Set value to pass on next activity
                startActivity(mIntent);
            }
        });
    }
}
