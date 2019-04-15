package com.example.group_4_shoppingapp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.group_4_shoppingapp.Database.DatabaseHelper;
import com.example.group_4_shoppingapp.R;

public class LoginMainActivity extends AppCompatActivity {

    private EditText edtUserEmail, edtPassword;
    private Button btnLogin, btnSignup;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Login Here");

        edtUserEmail = findViewById(R.id.edtUserEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignup = findViewById(R.id.btnSignup);
        db = new DatabaseHelper(this);

       btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtUserEmail.getText().toString();
                String password = edtPassword.getText().toString();
                Boolean chkemailpass = db.emailpassword(email,password);
                  if(chkemailpass==true){
                      Toast.makeText(getApplicationContext(),"Successful Login",Toast.LENGTH_SHORT).show();
                Intent mIntent = new Intent(LoginMainActivity.this, HomeActivity.class);
                //Set value to pass on next activity
                startActivity(mIntent);}
                  else {
                      Toast.makeText(getApplicationContext(), "Wrong email/password", Toast.LENGTH_SHORT).show();
                  }
            }

        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(LoginMainActivity.this, SignupActivity.class);
                //Set value to pass on next activity
                startActivity(mIntent);
            }
        });
    }
}
