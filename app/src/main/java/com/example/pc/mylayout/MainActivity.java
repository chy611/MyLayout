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

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.RecursiveTask;

public class MainActivity extends AppCompatActivity implements OnProgressBarListener {

    public static final String TAG = "MainActivity";

    private MyLayout layout2;
    private MyRockerView rockerView1;
    private MyRockerView rockerView2;
    private NumberProgressBar triger_r2;
    private NumberProgressBar triger_l2;
    private Timer timer;

    private View showkey;

    private TextView keyname;
    private TextView keycode;

    private static float[]  mValue = new float[46];

//    private DiscreteSeekBar discreteSeekBar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keyname = (TextView) findViewById(R.id.keyname);
        keycode = (TextView) findViewById(R.id.keycode);
        showkey = findViewById(R.id.keycode);
        showkey.setVisibility(View.GONE);

        layout2 = (MyLayout) findViewById(R.id.mylayout2);
        layout2.setFocusable(true);
        layout2.requestFocus();
        layout2.setFocusableInTouchMode(true);
        layout2.requestFocusFromTouch();

        rockerView1 = (MyRockerView) findViewById(R.id.rockerView1);
        rockerView2 = (MyRockerView) findViewById(R.id.rockerView2);

        triger_r2 = (NumberProgressBar)findViewById(R.id.numberbar_r2);
        triger_r2.setOnProgressBarListener(this);
        triger_r2.setMax(256);
        triger_r2.setReachedBarHeight(20);
//        triger_r2.setProgressTextSize(20);

        triger_l2 = (NumberProgressBar)findViewById(R.id.numberbar_l2);
        triger_l2.setOnProgressBarListener(this);
        triger_l2.setMax(256);
        triger_l2.setReachedBarHeight(20);
//        triger_l2.setProgressTextSize(20);

//        discreteSeekBar1 = (DiscreteSeekBar) findViewById(R.id.newbar1);
//        discreteSeekBar1.setOnProgressChangeListener(this);
//        discreteSeekBar1.setMax(256);

        layout2.setOnGenericMotionListener(new View.OnGenericMotionListener() {
            @Override
            public boolean onGenericMotion(View v, MotionEvent event) {
                float x1,y1,x2,y2,l2,r2,axis_x,axis_y;

                for (int n = 0; n<46; n++){
                    float move = event.getAxisValue(n);
                    if (mValue[n] != move){
                        Log.e(TAG, "onGenericMotionEvent: "+n+" "+move);
                        mValue[n] = move;
                    }


                }
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        x1 = event.getAxisValue(0);
                        y1 = event.getAxisValue(1);
                        r2 = event.getAxisValue(22);
                        l2 = event.getAxisValue(23);
                        x2 = event.getAxisValue(11);
                        y2 = event.getAxisValue(14);
                        axis_x = event.getAxisValue(15);
                        axis_y = event.getAxisValue(16);

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
                            Log.e(TAG, "onGenericMotion--3: "+r2);
                            layout2.triger_r2 = r2;
                            triger_r2.setProgress((int)(layout2.triger_r2*256));
                        }
                        if (layout2.triger_l2 != l2) {
                            Log.e(TAG, "onGenericMotion--4: "+l2);
                            layout2.triger_l2 = l2;
                            triger_l2.setProgress((int)(layout2.triger_l2*256));
//                            discreteSeekBar1.setProgress((int)(layout2.triger_l2*256));
                        }
                        if (axis_x == -1){

                        }else if (axis_x == 1){

                        }else if (axis_x == 0){

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
                if (action == event.ACTION_UP){
                    showkey.setVisibility(View.GONE);
                    return true;
                }
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

                    case KeyEvent.KEYCODE_BUTTON_A:
                    case KeyEvent.KEYCODE_BUTTON_B:
                    case KeyEvent.KEYCODE_BUTTON_X:
                    case KeyEvent.KEYCODE_BUTTON_Y:
                    case KeyEvent.KEYCODE_BUTTON_L1:
                    case KeyEvent.KEYCODE_BUTTON_R1:
                    case KeyEvent.KEYCODE_BUTTON_L2:
                    case KeyEvent.KEYCODE_BUTTON_R2:
                    case KeyEvent.KEYCODE_BUTTON_THUMBL:
                    case KeyEvent.KEYCODE_BUTTON_THUMBR:
                    case KeyEvent.KEYCODE_BUTTON_START:
                    case KeyEvent.KEYCODE_BUTTON_SELECT:
                        showkey(keyCode);
                        return true;

                }

//                Toast.makeText(MainActivity.this, key_msg+keyCode, Toast.LENGTH_SHORT).show();
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
        if(current == max) {
//            Toast.makeText(getApplicationContext(), getString(R.string.finish), Toast.LENGTH_SHORT).show();
            triger_r2.setProgress(0);
        }
    }

    private void showkey(int key){

        showkey.setVisibility(View.VISIBLE);

        switch (key){
            case KeyEvent.KEYCODE_BUTTON_A:
                keyname.setText("BUTTON_A");
                keycode.setText("96");
                return;
            case KeyEvent.KEYCODE_BUTTON_B:
                keyname.setText("BUTTON_B");
                keycode.setText("97");
                return;
            case KeyEvent.KEYCODE_BUTTON_X:
                keyname.setText("BUTTON_X");
                keycode.setText("99");
                return;
            case KeyEvent.KEYCODE_BUTTON_Y:
                keyname.setText("BUTTON_Y");
                keycode.setText("100");
                return;
            case KeyEvent.KEYCODE_BUTTON_L1:
                keyname.setText("BUTTON_L1");
                keycode.setText("102");
                return;
            case KeyEvent.KEYCODE_BUTTON_R1:
                keyname.setText("BUTTON_R1");
                keycode.setText("103");
                return;
            case KeyEvent.KEYCODE_BUTTON_L2:
                keyname.setText("BUTTON_L2");
                keycode.setText("104");
                return;
            case KeyEvent.KEYCODE_BUTTON_R2:
                keyname.setText("BUTTON_R2");
                keycode.setText("105");
                return;
            case KeyEvent.KEYCODE_BUTTON_THUMBL:
                keyname.setText("BUTTON_THUMBL");
                keycode.setText("106");
                return;
            case KeyEvent.KEYCODE_BUTTON_THUMBR:
                keyname.setText("BUTTON_THUMBR");
                keycode.setText("107");
                return;
            case KeyEvent.KEYCODE_BUTTON_START:
                keyname.setText("BUTTON_START");
                keycode.setText("108");
                return;
            case KeyEvent.KEYCODE_BUTTON_SELECT:
                keyname.setText("BUTTON_SELECT");
                keycode.setText("109");
                return;
        }

    }
}
