package com.example.pc.mylayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by pc on 2017/4/17.
 */

public class MyLayout extends LinearLayout {

    public String TAG =getClass().getSimpleName();
    public MyLayout(Context context){
        super(context);
    }

    public RockerView rockerView1;
    public RockerView rockerView2;

    public float rocker_x1,rocker_y1,rocker_x2,rocker_y2,triger_l2,triger_r2;


    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.e(TAG, "MyLayout onInterceptTouchEvent.");
//        Log.e(TAG,"MyLayout onInterceptTouchEvent default return "
//                + super.onInterceptTouchEvent(ev));
//        return super.onInterceptTouchEvent(ev);
////        return true;
//    }



//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.e(TAG, "MyLayout onTouchEvent.");
//        Log.e(TAG,"MyLayout onTouchEvent default return true");
////                + super.onTouchEvent(event));
////        return super.onTouchEvent(event);
//        return true;
//    }
//
//    @Override
//    public boolean dispatchKeyEvent(KeyEvent event) {
//        int key = event.getKeyCode();
//        Log.i(TAG, "[test] dispatchKeyEvent  event = " + event);
//        if (key == KeyEvent.KEYCODE_VOLUME_DOWN
//                || key == KeyEvent.KEYCODE_VOLUME_UP) {
//            Log.i(TAG, "[test] catch  event!! return true! ");
//            return true;
//        }
//        return super.dispatchKeyEvent(event);
//    }
//
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        Log.e(TAG, "onKeyDown: "+keyCode);
        switch (keyCode){

            case KeyEvent.KEYCODE_CALL:return true;
            case KeyEvent.KEYCODE_SYM: return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN: return true;
            case KeyEvent.KEYCODE_VOLUME_UP: return true;
            case KeyEvent.KEYCODE_STAR: return true;

            case KeyEvent.KEYCODE_BACK:
                //返回按键拦截
                return true;
            case KeyEvent.KEYCODE_HOME:
                //Home按键拦截
                return true;

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
//        Log.e(TAG, "onKeyUp: "+keyCode);
        return super.onKeyUp(keyCode, event);
    }

    private static float[]  mValue = new float[46];

//    @Override
//    public boolean onGenericMotionEvent(MotionEvent event) {
//
//        Log.e(TAG, "onGenericMotionEvent11: "+"Action: "+event.getAction());
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_MOVE:
//
//                break;
//        }
//
//        for (int n = 0; n<46; n++){
//            float move = event.getAxisValue(n);
//            if (mValue[n] != move){
//                Log.e(TAG, "onGenericMotionEvent: "+n+" "+move);
//                mValue[n] = move;
//            }
//
//        }
////        final float movex = event.getAxisValue(MotionEvent.AXIS_X);
////        final float movey = event.getAxisValue(MotionEvent.AXIS_Y);
////        final float moverx = event.getAxisValue(MotionEvent.AXIS_RX);
////        final float movery = event.getAxisValue(MotionEvent.AXIS_RY);
////
////        Log.e(TAG, "onGenericMotionEvent: "+movex+" "+movey+" "+moverx+" "+movery);
////        return super.onGenericMotionEvent(event);
//        return false;
//    }

}



