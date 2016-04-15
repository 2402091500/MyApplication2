package com.example.administrator.myapplication;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public class MyPagerAdapter extends PagerAdapter{
    List<View> viewList;
    private final String [] TITLES = {"SPEED DIAL", "RECENTS", "CONTACTS", "CONTACTS","CONTACTS"};
    public MyPagerAdapter(List<View> viewList){
    this.viewList=viewList;
    }
    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       View v= viewList.get(position);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView( viewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}
