package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class Splash2_Activity extends AppCompatActivity {
    int time = 3000;
    GifImageView imgGIF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        imgGIF = findViewById(R.id.img_gif);
        imgGIF.setGifImageResource(R.drawable.imggif);

        SharedPreferences sharedPreferences = getSharedPreferences("LOGIN_PAGE",MODE_PRIVATE);

        String user = sharedPreferences.getString("USERNAME_KEY","");
        String pass = sharedPreferences.getString("PASSWORD_KEY","");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(user=="" && pass==""){
                    Intent i = new Intent(Splash2_Activity.this,LoginActivity.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Intent i = new Intent(Splash2_Activity.this,Nav_Activity.class);
                    startActivity(i);
                    finish();
                }

            }
        },time);
    }
}