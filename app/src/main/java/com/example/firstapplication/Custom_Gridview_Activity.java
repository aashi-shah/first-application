package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class Custom_Gridview_Activity extends AppCompatActivity {
    GridView gridView;

    String gridlang[] = {"Android","Java","Python","PHP","C","C++","IOS","JS"};
    int gridimglang[] = {R.mipmap.ic_launcher_round,R.drawable.ic_java,R.drawable.ic_python, R.drawable.ic_php, R.drawable.ic_c,R.drawable.ic_cc,R.drawable.ic_ios,R.drawable.ic_js};
    ArrayList<LangModel1> langModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_gridview);
        gridView = findViewById(R.id.custom_gridview);

        langModelArrayList = new ArrayList<LangModel1>();
        for(int i=0;i<gridimglang.length;i++){
            LangModel1 langModel1 = new LangModel1(gridlang[i],gridimglang[i]);
            langModelArrayList.add(langModel1);
        }
        MybasegridAdapter mybasegridAdapter = new MybasegridAdapter(this,langModelArrayList);
        gridView.setAdapter(mybasegridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                int img = langModelArrayList.get(position).getGridImglang();
                String data = langModelArrayList.get(position).getGridLang();
                Intent in = new Intent(Custom_Gridview_Activity.this,Customgrid_Value_Activity.class);
                in.putExtra("KEY_IV",img);
                in.putExtra("KEY_TV",data);
                startActivity(in);
            }
        });
    }
}
