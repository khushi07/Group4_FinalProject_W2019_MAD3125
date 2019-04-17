package com.example.group_4_shoppingapp.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.group_4_shoppingapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class ContactFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact, container, false);



    }


    private void OnSend(View view) {
        final EditText emailAddress = getView().findViewById(R.id.emailAddress);
        final EditText message = getView().findViewById(R.id.message);
        final EditText subject = getView().findViewById(R.id.subject);

        if (emailAddress.getText().toString().equals("")) {
            emailAddress.setError("Mandatory field");
        } else if (message.getText().toString().equals("")) {
            message.setError("Mandatory field");
        } else if (subject.getText().toString().equals("")) {
            subject.setError("Mandatory field");
        } else {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"chandanswan@gmail.com"});
            intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, "dear, \n" + message.getText().toString());


               startActivity(Intent.createChooser(intent, "send mail"));


        }


    }
    }
