package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Java_Fragment_Activity extends AppCompatActivity {

    Button buttona,buttonb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_fragment);
        buttona = findViewById(R.id.button_a);
        buttonb = findViewById(R.id.button_b);

        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AFragment aFragment = new AFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frame,aFragment);
                fragmentTransaction.commit();
            }
        });


        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BFragment bFragment = new BFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.frame,bFragment);
                fragmentTransaction.commit();
            }
        });
    }
}