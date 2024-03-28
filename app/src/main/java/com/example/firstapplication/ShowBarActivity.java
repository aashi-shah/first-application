package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowBarActivity extends AppCompatActivity {
    TextView seek;
    TextView rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bar);
        seek = findViewById(R.id.show_seek);
        rate = findViewById(R.id.show_rate);
        Intent in = getIntent();
        String seekbar1 = in.getStringExtra("seek_bar");
        seek.setText("Seekbar : "+seekbar1);
        String ratebar = in.getStringExtra("rate_bar");
        rate.setText("Ratebar : "+ratebar);
    }
}