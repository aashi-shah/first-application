package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        button1 = findViewById(R.id.startsong);
        button2 = findViewById(R.id.stopsong);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startsong:
                Intent i = new Intent(ServiceActivity.this,MyService.class);
                startService(i);
                break;
            case R.id.stopsong:
                Intent i1 = new Intent(ServiceActivity.this,MyService.class);
                stopService(i1);
                break;
        }
    }
}