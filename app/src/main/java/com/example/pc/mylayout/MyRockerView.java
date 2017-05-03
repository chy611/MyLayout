package com.example.pc.mylayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.example.pc.mylayout.RockerView;

/**
 * Created by pc on 2017/4/27.
 */

public class MyRockerView extends RockerView{

    private String TAG = getClass().getSimpleName();

    public static float x1,y1,x2,y2;

    public MyRockerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

//    @Override
//    public boolean onGenericMotionEvent(MotionEvent event) {
//        Log.e(TAG, "onGenericMotionEvent: ");
//        return super.onGenericMotionEvent(event);
//    }

    public void move(float x, float y){
        float movex, movey;
        movex = (x+1)*256 + 1;
        movey = (y+1)*256 + 1;

        this.callBackStart();
        this.moveRocker(movex, movey);

        Log.e(TAG, "move: "+movex+","+movey);

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
            move(mValue[0], mValue[1]);

        }
        return false;
    }
}
