package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SharedPrefActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText1,editText2;
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);
        editText1 = findViewById(R.id.firstname);
        editText2 = findViewById(R.id.lastname);
        button1 = findViewById(R.id.addname);
        button2 = findViewById(R.id.displayname);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addname:
                String fn = editText1.getText().toString();
                String ln = editText2.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("MY_APP",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("SP_FN_KEY",fn);
                editor.putString("SP_LN_KEY",ln);
                editor.commit();

                editText1.setText("");
                editText2.setText("");

                break;

            case R.id.displayname:
                SharedPreferences sharedPreferences1 = getSharedPreferences("MY_APP",MODE_PRIVATE);

                String strfn = sharedPreferences1.getString("SP_FN_KEY","");
                String strln = sharedPreferences1.getString("SP_LN_KEY","");

                editText1.setText(strfn);
                editText2.setText(strln);

                break;
        }
    }
}