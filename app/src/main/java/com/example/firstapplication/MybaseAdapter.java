package com.example.firstapplication;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MybaseAdapter extends BaseAdapter {
    Context context;
    ArrayList<LangModel> langModelArrayList;

    public MybaseAdapter(Context context, ArrayList<LangModel> langModelArrayList) {
        this.context = context;
        this.langModelArrayList = langModelArrayList;
    }

    @Override
    public int getCount() {
        return langModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return langModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contextview = layoutInflater.inflate(R.layout.raw_custom_list, null);

        CircleImageView circleImageView = contextview.findViewById(R.id.img_data);
        TextView tvdata = contextview.findViewById(R.id.tv_data1);

        LangModel langModel = langModelArrayList.get(position);
        circleImageView.setImageResource(langModelArrayList.get(position).getImglang());
        tvdata.setText(langModel.getLang());

        return contextview;
    }
}
