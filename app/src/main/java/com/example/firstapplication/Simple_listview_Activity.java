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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Simple_listview_Activity extends AppCompatActivity {

    ListView listView;
    TextView text1;
    String str[] = {"Android","Flutter","C","C++","PHP","Java"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_listview);
        listView = findViewById(R.id.listview);
        text1 = findViewById(R.id.text1);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,android.R.id.text1,str){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                TextView text1 = (TextView) super.getView(position, convertView, parent);
                if(position%2==0) {
                    text1.setBackgroundColor(Color.GRAY);
                    text1.setTextColor(Color.WHITE);
                }else{
                    text1.setBackgroundColor(Color.DKGRAY);
                    text1.setTextColor(Color.WHITE);
                }

                return text1;
            }

        };

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = parent.getItemAtPosition(position).toString();
                Toast.makeText(Simple_listview_Activity.this,""+data,Toast.LENGTH_SHORT).show();
            }
        });

    }
}