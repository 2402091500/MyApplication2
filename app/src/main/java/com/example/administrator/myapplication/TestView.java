package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/3/21.
 */
public class TestView  extends View {
    Paint paint=new Paint();
    int width=200;
    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint.setColor(Color.BLUE);
        paint.setTextSize(5);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher),0,0,paint);
    }

    private int measureWidth(int measureSpec)
    {
        int mode = MeasureSpec.getMode(measureSpec);
        int val = MeasureSpec.getSize(measureSpec);
        int result = 0;
        switch (mode){
            case MeasureSpec.EXACTLY:
                result = val;
                break;
            case MeasureSpec.AT_MOST:
                result=getPaddingLeft()+getPaddingRight();
                break;
            case MeasureSpec.UNSPECIFIED:
                result=getPaddingLeft()+getPaddingRight();
                break;
        }
        return result;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        setMeasuredDimension(measureWidth(widthMeasureSpec),getDefaultSize(0, heightMeasureSpec));
    }
}
