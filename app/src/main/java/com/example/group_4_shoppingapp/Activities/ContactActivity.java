package com.example.group_4_shoppingapp.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.group_4_shoppingapp.R;

public class ContactActivity extends AppCompatActivity {

    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Contact Us");

        mEditTextTo = findViewById(R.id.edit_text_to);
        mEditTextSubject = findViewById(R.id.edit_text_subject);
        mEditTextMessage = findViewById(R.id.edit_text_message);

        Button buttonSend = findViewById(R.id.button_send);
        Button buttonCall = findViewById(R.id.button_call);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }

            private void call() {
               Intent intent =new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+14374888996"));
                startActivity(intent);
            }
        });
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
    }

        private void sendMail()
        {
            String recipientList = mEditTextTo.getText().toString();
            String[] recipients = recipientList.split(",");

            String subject = mEditTextSubject.getText().toString();
            String message = mEditTextMessage.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, recipients);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);

            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent, "Choose an Email client"));
        }
}
