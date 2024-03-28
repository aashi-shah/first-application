package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home_Activity extends AppCompatActivity {
    TextView Email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Email = findViewById(R.id.v_email);
        Intent i = getIntent();
        String stremail = i.getStringExtra("KEY_EMAIL");
        Email.setText("Welcome : "+stremail);

    }
}