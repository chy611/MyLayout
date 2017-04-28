package com.example.pc.mylayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by pc on 2017/4/17.
 */

public class MyLayout1 extends FrameLayout {

    public String TAG =getClass().getSimpleName();
    public MyLayout1(Context context){
        super(context);
    }

    public MyLayout1(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "MyLayout onInterceptTouchEvent.");
        Log.e(TAG,"MyLayout onInterceptTouchEvent default return "
                + super.onInterceptTouchEvent(ev));
        return super.onInterceptTouchEvent(ev);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "MyLayout onTouchEvent.");
        Log.e(TAG,"MyLayout onTouchEvent default return true");
//                + super.onTouchEvent(event));
//        return super.onTouchEvent(event);
        return true;
    }
}
