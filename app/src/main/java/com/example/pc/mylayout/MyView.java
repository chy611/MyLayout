package com.example.pc.mylayout;

import android.content.Context;
import android.text.method.HideReturnsTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import javax.security.auth.login.LoginException;

/**
 * Created by pc on 2017/4/17.
 */

public class MyView extends View {

    public String TAG =getClass().getSimpleName();

    public MyView(Context context){
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "MyView onTouchEvent.");
        Log.e(TAG,"MyView onTouchEvent default return false");
//                + super.onTouchEvent(event));
//        return super.onTouchEvent(event);
        return false;
    }

//    // 拦截系统热键
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

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int key = event.getKeyCode();
        Log.i(TAG, "[test] dispatchKeyEvent  event = " + event);
        if (key == KeyEvent.KEYCODE_VOLUME_DOWN
                || key == KeyEvent.KEYCODE_VOLUME_UP) {
            Log.i(TAG, "[test] catch  event!! return true! ");
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.e(TAG, "onKeyDown: "+keyCode);
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
        Log.e(TAG, "onKeyUp: "+keyCode);
        return super.onKeyUp(keyCode, event);
    }

    private static float[]  mValue = new float[46];

    @Override
    public boolean onGenericMotionEvent(MotionEvent event) {

//        Log.e(TAG, "onGenericMotionEvent: "+"Action: "+event.getAction());
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:

                break;
        }

        for (int n = 0; n<46; n++){
            float move = event.getAxisValue(n);
            if (mValue[n] != move){
                Log.e(TAG, "onGenericMotionEvent: "+n+" "+move);
                mValue[n] = move;
            }


        }
        return false;
    }

}
