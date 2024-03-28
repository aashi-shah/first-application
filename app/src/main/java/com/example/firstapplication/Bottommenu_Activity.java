package com.example.firstapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bottommenu_Activity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottommenu);

        bottomNavigationView = findViewById(R.id.bottommenu);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.item_home) {
                    Toast.makeText(Bottommenu_Activity.this, "HOME", Toast.LENGTH_SHORT).show();
                    toolbar.setTitle("HOME");
                }else if(id==R.id.item_cart){
                    Toast.makeText(Bottommenu_Activity.this, "CART", Toast.LENGTH_SHORT).show();
                    toolbar.setTitle("SHOPPING CART");
                }else if(id==R.id.item_setting){
                    Toast.makeText(Bottommenu_Activity.this, "SETTING", Toast.LENGTH_SHORT).show();
                    toolbar.setTitle("SETTING");
                }else if(id==R.id.item_profile){
                    Toast.makeText(Bottommenu_Activity.this, "PROFILE", Toast.LENGTH_SHORT).show();
                    toolbar.setTitle("PROFILE");
                }
                return true;
            }
        });
    }
}