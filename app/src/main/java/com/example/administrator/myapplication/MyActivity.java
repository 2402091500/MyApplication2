package com.example.administrator.myapplication;


import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;

/**
 * Created by Administrator on 2016/3/14.
 */
public class MyActivity extends Activity {
    PopupWindow popupWindow;
    EditText button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app);
        button=(EditText)findViewById(R.id.button);
        View view=LayoutInflater.from(this).inflate(R.layout.content_main, null);
        ListView listview= (ListView)view. findViewById(R.id.listview);
        listview.setAdapter(new MyAdapter());
        listview.setFocusable(true);
        listview.setFocusableInTouchMode(true);
        popupWindow=new PopupWindow(view,150, ViewGroup.LayoutParams.WRAP_CONTENT);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                popupWindow.dismiss();
            }
        });
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        button.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
              if (s.toString().length()!=0){
                  popupWindow.showAsDropDown(button);
              }else{
                  popupWindow.dismiss();
              }
            }
        });
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (popupWindow.isShowing()) {
//                    popupWindow.dismiss();
//                } else {
//                    popupWindow.showAsDropDown(button);
//                    WindowManager.LayoutParams lp = getWindow().getAttributes();
//                    lp.alpha = 0.5f;
//                    getWindow().setAttributes(lp);
//                }
//
//            }
//        });
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
    }
}
