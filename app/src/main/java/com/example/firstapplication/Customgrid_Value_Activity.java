package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Customgrid_Value_Activity extends AppCompatActivity {
    CircleImageView circleImageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customgrid_value);
        circleImageView = findViewById(R.id.gridimgvalue);
        textView = findViewById(R.id.gridtextvalue);
        Intent in = getIntent();

        int grid_iv = in.getIntExtra("KEY_IV",0);
        String grid_tv = in.getStringExtra("KEY_TV");

        circleImageView.setImageResource(grid_iv);
        textView.setText(grid_tv);
    }
}