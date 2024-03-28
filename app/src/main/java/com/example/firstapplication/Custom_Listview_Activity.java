package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Custom_Listview_Activity extends AppCompatActivity {
    ListView listView;

    String lang[] = {"Android","Java","Python","PHP","C","C++","IOS"};
    int imglang[] = {R.mipmap.ic_launcher_round,R.drawable.ic_java,R.drawable.ic_python,
            R.drawable.ic_php,R.drawable.ic_c,R.drawable.ic_cc,R.drawable.ic_ios};
    ArrayList<LangModel> langModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview);
        listView = findViewById(R.id.custom_listview);

        langModelArrayList = new ArrayList<LangModel>();
        for(int i=0;i<imglang.length;i++){
            LangModel langModel = new LangModel(lang[i],imglang[i]);
            langModelArrayList.add(langModel);
        }
        MybaseAdapter mybaseAdapter = new MybaseAdapter(this,langModelArrayList);
        listView.setAdapter(mybaseAdapter);

    }
}