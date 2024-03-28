package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText1 = findViewById(R.id.username);
        editText2 = findViewById(R.id.password);
        button = findViewById(R.id.login);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = editText1.getText().toString();
                String pass = editText2.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("LOGIN_PAGE",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("USERNAME_KEY",user);
                    editor.putString("PASSWORD_KEY",pass);
                    editor.commit();

                    Intent i = new Intent(LoginActivity.this,Nav_Activity.class);
                    startActivity(i);
            }
        });
    }
}