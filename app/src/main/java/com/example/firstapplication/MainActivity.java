package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText edtemail,edtpass;
Button btnlogin;
Button btnSend;
ImageView imglogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtemail = findViewById(R.id.edit_email);
        edtpass = findViewById(R.id.edit_pass);
        btnlogin = findViewById(R.id.edt_btn);
        btnSend = findViewById(R.id.edt_btn1);
        imglogo = findViewById(R.id.img_logo);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https:www.google.com/"));
                startActivity(i);
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                String stremail = edtemail.getText().toString();
                String strpass = edtpass.getText().toString();
                if(stremail.equals("aashishah@gmail.com") && strpass.equals("aashi")){
                    Intent i = new Intent(MainActivity.this,IntentActivity.class);
                    startActivity(i);
                    finish();
                }
                edtemail.setError("Enter email id");
                Toast.makeText(MainActivity.this, "Email is "+stremail, Toast.LENGTH_SHORT).show();


                imglogo.setImageResource(R.drawable.camera_1);
                Intent i = new Intent(MainActivity.this,Home_Activity.class);
                i.putExtra("KEY_EMAIL",stremail);
                startActivity(i);
            }
        });
    }
}