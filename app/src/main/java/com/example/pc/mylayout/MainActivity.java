package com.example.pc.mylayout;

import android.app.backup.RestoreObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.daimajia.numberprogressbar.OnProgressBarListener;
import com.example.pc.mylayout.RockerView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity implements OnProgressBarListener {

    public static final String TAG = "MainActivity";

    private MyLayout layout2;
    private MyRockerView rockerView1;
    private MyRockerView rockerView2;
    private NumberProgressBar bnp;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout2 = (MyLayout) findViewById(R.id.mylayout2);
        layout2.setFocusable(true);
        layout2.requestFocus();
        layout2.setFocusableInTouchMode(true);
        layout2.requestFocusFromTouch();

        rockerView1 = (MyRockerView) findViewById(R.id.rockerView1);
        rockerView2 = (MyRockerView) findViewById(R.id.rockerView2);

        bnp = (NumberProgressBar)findViewById(R.id.numberbar1);
        bnp.setOnProgressBarListener(this);
        timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        bnp.incrementProgressBy(1);
//                    }
//                });
//            }
//        }, 1000, 100);

        layout2.setOnGenericMotionListener(new View.OnGenericMotionListener() {
            @Override
            public boolean onGenericMotion(View v, MotionEvent event) {
                float x1,y1,x2,y2,l2,r2;
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        x1 = event.getAxisValue(0);
                        y1 = event.getAxisValue(1);
                        r2 = event.getAxisValue(22);
                        l2 = event.getAxisValue(23);
                        x2 = event.getAxisValue(11);
                        y2 = event.getAxisValue(14);

                        Log.e(TAG, "onGenericMotion22: "+"Action: "+event.getAction()+" "+x1+" "+y1+" "+x2+" "+y2+" "+r2+" "+l2);

                        if (layout2.rocker_x1 != x1 || layout2.rocker_y1 != y1) {
                            Log.e(TAG, "onGenericMotion--1: ");
                            rockerView1.move(x1,y1);
                            layout2.rocker_x1 = x1;
                            layout2.rocker_y1 = y1;
                        }
                        if (layout2.rocker_x2 != x2 || layout2.rocker_y2 != y2) {
                            Log.e(TAG, "onGenericMotion--2: ");
                            rockerView2.move(x2,y2);
                            layout2.rocker_x2 = x2;
                            layout2.rocker_y2 = y2;
                        }
                        if (layout2.triger_r2 != r2) {
                            Log.e(TAG, "onGenericMotion--3: ");
                            layout2.triger_r2 = r2;
                        }
                        if (layout2.triger_l2 != l2) {
                            Log.e(TAG, "onGenericMotion--4: ");

                            layout2.triger_l2 = l2;
                        }
                        break;
                }
                return true;
            }
        });

        layout2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                int action = event.getAction();
                String key_msg = "按键: ";
//                if (action == event.ACTION_DOWN){
//                    key_msg = "key down: ";
//                }else {
//                    key_msg = "key up: ";
//                }
                Log.e(TAG, "onKey: "+keyCode+","+action);
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

                Toast.makeText(MainActivity.this, key_msg+keyCode, Toast.LENGTH_SHORT).show();
                return false;
            }


        });
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

    @Override
    public void onProgressChange(int current, int max) {

    }
}
