package com.example.pc.mylayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.pc.mylayout.RockerView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private View layout;
    private View layout2;
    private RockerView rockerView1;
    private RockerView rockerView2;
    private View myView;
    private View RockerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout2 = findViewById(R.id.mylayout2);
        layout2.setFocusable(true);
        layout2.requestFocus();
        layout2.setFocusableInTouchMode(true);
        layout2.requestFocusFromTouch();

//        myView = (View) findViewById(R.id.myView);
//        myView.setFocusable(true);
//        myView.setFocusableInTouchMode(true);
//        myView.requestFocus();
//        myView.requestFocusFromTouch();

//        RockerView = (View) findViewById(R.id.rockerView1);
//        RockerView.setFocusable(true);
//        RockerView.setFocusableInTouchMode(true);
//        RockerView.requestFocus();
//        RockerView.requestFocusFromTouch();

//        layout = (MyLayout1) findViewById(R.id.MyLayout1);
//        myView = new MyView(this);
//        myView.setText("hello world!!!");
//        layout.addView(myView);
//        layout = findViewById(R.id.mylayout);
//        layout.setOnGenericMotionListener(new View.OnGenericMotionListener(){
//
//            @Override
//            public boolean onGenericMotion(View v, MotionEvent event) {
//                Log.e(TAG, "onGenericMotion00: ");
//                return false;
//            }
//        });
//        rockerView1 = (RockerView) findViewById(R.id.rockerView1);
//        rockerView1.setOnGenericMotionListener(new View.OnGenericMotionListener(){
//
//            @Override
//            public boolean onGenericMotion(View v, MotionEvent event) {
//                Log.e(TAG, "onGenericMotion1: ");
//                return false;
//            }
//        });
//        rockerView2 = (RockerView) findViewById(R.id.rockerView2);
//        rockerView2.setOnGenericMotionListener(new View.OnGenericMotionListener(){
//
//            @Override
//            public boolean onGenericMotion(View v, MotionEvent event) {
//                Log.e(TAG, "onGenericMotion2: ");
//                return false;
//            }
//        });

    }
}
