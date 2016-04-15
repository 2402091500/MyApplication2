package com.example.administrator.myapplication;

import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/3/24.
 */
public class MyAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=LayoutInflater.from(parent.getContext()).inflate(R.layout.name,null);
        TextView textView= (TextView) convertView.findViewById(R.id.textview);
        textView.setText("ddddddddddddddddddddddddd");
        return convertView;
    }
}
