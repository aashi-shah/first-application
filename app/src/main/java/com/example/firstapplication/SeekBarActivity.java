package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBarActivity extends AppCompatActivity {
    SeekBar seekbar;
    private TextView tvdata,tvstars;
    RatingBar ratingbar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        seekbar = findViewById(R.id.seekbar);
        tvdata  = findViewById(R.id.tv_seekbar) ;
        ratingbar = findViewById(R.id.stars);
        tvstars = findViewById(R.id.tv_stars);
        button = findViewById(R.id.btn_home);

        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                tvstars.setText(String.valueOf(rating));
            }
        });
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvdata.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SeekBarActivity.this,ShowBarActivity.class);
                String seeknum1 = tvdata.getText().toString();
                String ratenum = tvstars.getText().toString();
                i.putExtra("seek_bar",seeknum1);
                i.putExtra("rate_bar",ratenum);
                startActivity(i);
            }
        });
    }
}