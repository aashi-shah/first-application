package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class Gridview_Activity extends AppCompatActivity {

    GridView gridView;

    String str[] = {"Android","Java","Python",".net","PHP","C","C++","Flutter"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        gridView = findViewById(R.id.grid_view1);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,str);
        gridView.setAdapter(arrayAdapter);
    }
}