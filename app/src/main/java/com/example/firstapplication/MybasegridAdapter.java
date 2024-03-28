package com.example.firstapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MybasegridAdapter extends BaseAdapter {
    Context context;
    ArrayList<LangModel1> langModelArrayList;

    public MybasegridAdapter(Context context, ArrayList<LangModel1> langModelArrayList) {
        this.context = context;
        this.langModelArrayList = langModelArrayList;
    }

    @Override
    public int getCount() {
        return langModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return langModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contextview = layoutInflater.inflate(R.layout.raw_custom_gridview,null);

        CircleImageView circleImageView = contextview.findViewById(R.id.gridimg);
        TextView tv_gv = contextview.findViewById(R.id.gridtext);

        LangModel1 langModel1 = langModelArrayList.get(i);
        circleImageView.setImageResource(langModelArrayList.get(i).getGridImglang());
        tv_gv.setText(langModel1.getGridLang());

        return contextview;
    }
}
