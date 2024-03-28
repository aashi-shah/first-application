package com.example.firstapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Spinner_Activity extends AppCompatActivity {

    Spinner spinner;
    TextView textdata;

    String str[] = {"Select any language","Android","C++","C","PHP","IOS"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = findViewById(R.id.spin);
        textdata = findViewById(R.id.data);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,str){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView textdata = (TextView) super.getView(position, convertView, parent);

                textdata.setBackgroundColor(Color.DKGRAY);

                return textdata;
            }

            @Override
            public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                TextView textdata = (TextView) super.getDropDownView(position, convertView, parent);

                if(position == 0) {
                    textdata.setTextColor(Color.DKGRAY);
                    textdata.setBackgroundColor(Color.WHITE);
                } else{
                    textdata.setTextColor(Color.GRAY);
                }
                return textdata;
            }
        };


        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0){
                    String strdata = parent.getItemAtPosition(position).toString();
                    textdata.setText("Selected language is : " + strdata);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}