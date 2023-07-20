package com.example.mycallandsaveapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   EditText phone_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        phone_txt=(EditText)findViewById(R.id.edittxt_phone);

    }
    public void clearNumber(View view) {
        phone_txt.setText("");

    }
    public void callNumber(View view) {
        String phoneNumber = phone_txt.getText().toString();
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phoneNumber));
        startActivity(intent);
    }
    public void saveNumber(View view) {
        String phoneNumber = phone_txt.getText().toString();
        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE,
                phoneNumber);
        startActivity (intent);
    }
}
