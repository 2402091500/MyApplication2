package com.example.administrator.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.saulmm.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ViewPager viewpager;
    private SlidingTabLayout tabLayout;
    private List<View> viewList=new ArrayList<>();
    GridView gridView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager=(ViewPager)findViewById(R.id.viewpager);
        tabLayout=(SlidingTabLayout)findViewById(R.id.tabLayou);
        for (int i=0;i<5;i++){
            View v=LayoutInflater.from(this).inflate(R.layout.content_main,null);
            viewList.add(v);
        }
        viewpager.setAdapter(new MyPagerAdapter(viewList));
        tabLayout.setViewPager(viewpager);
        tabLayout.setCustomTabView(R.layout.name, R.id.textview);
    }


}
