package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class List_Grid_Activity extends AppCompatActivity {

    Button changeview;
    GridView gridView;
    ListView listView;
    boolean change = false;

    String str[] = {"Android","Java","Python",".net","PHP","C","C++","Flutter"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_grid);

        changeview = findViewById(R.id.change_view);
        gridView = findViewById(R.id.grid_view);
        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,str);
        gridView.setAdapter(arrayAdapter);
        gridView.setVisibility(View.GONE);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,str);
        listView.setAdapter(arrayAdapter1);

        changeview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(change == false){
                    changeview.setHint("change to grid view");
                    listView.setVisibility(View.VISIBLE);
                    gridView.setVisibility(View.GONE);
                    change = true;

                }else{
                    changeview.setHint("change to list view");
                    listView.setVisibility(View.GONE);
                    gridView.setVisibility(View.VISIBLE);
                    change = false;
                }
            }
        });
    }
}