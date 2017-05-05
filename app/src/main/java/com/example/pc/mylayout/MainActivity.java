package com.example.pc.mylayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.daimajia.numberprogressbar.OnProgressBarListener;

import java.math.BigDecimal;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnProgressBarListener {

    public static final String TAG = "MainActivity";
    @BindView(R.id.rockerView1)
    MyRockerView rockerView1;
    @BindView(R.id.rockerView2)
    MyRockerView rockerView2;
    @BindView(R.id.mylayout2)
    MyLayout mylayout2;
    @BindView(R.id.rocker_x2)
    TextView rocker_x2;
    @BindView(R.id.rocker_y2)
    TextView rocker_y2;
    @BindView(R.id.rocker_x1)
    TextView rocker_x1;
    @BindView(R.id.rocker_y1)
    TextView rocker_y1;
    @BindView(R.id.numberbar_r2)
    NumberProgressBar numberbarR2;
    @BindView(R.id.numberbar_l2)
    NumberProgressBar numberbarL2;
    @BindView(R.id.keyname)
    TextView keyname;
    @BindView(R.id.keycode)
    TextView keycode;
    @BindView(R.id.showkey)
    TableLayout showkey;
    @BindView(R.id.mylayout)
    MyLayout mylayout;
    private MyLayout layout2;
    private Timer timer;


//    private static float[] mValue = new float[46];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        showkey.setVisibility(View.GONE);

        layout2 = (MyLayout) findViewById(R.id.mylayout2);
        layout2.setFocusable(true);
        layout2.requestFocus();
        layout2.setFocusableInTouchMode(true);
        layout2.requestFocusFromTouch();

        numberbarR2.setOnProgressBarListener(this);
        numberbarR2.setMax(100);
        numberbarR2.setReachedBarHeight(20);
//        numberbarR2.setProgressTextSize(20);

        numberbarL2 = (NumberProgressBar) findViewById(R.id.numberbar_l2);
        numberbarL2.setOnProgressBarListener(this);
        numberbarL2.setMax(100);
        numberbarL2.setReachedBarHeight(20);
//        numberbar_l2.setProgressTextSize(20);

        layout2.setOnGenericMotionListener(new View.OnGenericMotionListener() {
            @Override
            public boolean onGenericMotion(View v, MotionEvent event) {
                float x1, y1, x2, y2, l2, r2, axis_x, axis_y;

//                for (int n = 0; n < 46; n++) {
//                    float move = event.getAxisValue(n);
//                    if (mValue[n] != move) {
//                        Log.e(TAG, "onGenericMotionEvent: " + n + " " + move);
//                        mValue[n] = move;
//                    }
//                }

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

                        Log.e(TAG, "onGenericMotion22: " + "Action: " + event.getAction() + " " + x1 + " " + y1 + " " + x2 + " " + y2 + " " + r2 + " " + l2+","+axis_x+","+axis_y);

                        if (layout2.rocker_x1 != x1 || layout2.rocker_y1 != y1) {
                            Log.e(TAG, "onGenericMotion--1: ");
                            rockerView1.move(x1, y1);
                            layout2.rocker_x1 = x1;
                            layout2.rocker_y1 = y1;
                            rocker_x1.setText(floatToStringByTruncate(x1, 2));
                            rocker_y1.setText(floatToStringByTruncate(y1, 2));
                        }
                        if (layout2.rocker_x2 != x2 || layout2.rocker_y2 != y2) {
                            Log.e(TAG, "onGenericMotion--2: ");
                            rockerView2.move(x2, y2);
                            layout2.rocker_x2 = x2;
                            layout2.rocker_y2 = y2;
                            rocker_x2.setText(floatToStringByTruncate(x2, 2));
                            rocker_y2.setText(floatToStringByTruncate(y2, 2));
                        }
                        if (layout2.triger_r2 != r2) {
                            Log.e(TAG, "onGenericMotion--3: " + r2);
                            layout2.triger_r2 = r2;
                            numberbarR2.setProgress((int) (layout2.triger_r2 * 100));
                        }
                        if (layout2.triger_l2 != l2) {
                            Log.e(TAG, "onGenericMotion--4: " + l2);
                            layout2.triger_l2 = l2;
                            numberbarL2.setProgress((int) (layout2.triger_l2 * 100));
                        }
                        if (axis_x == -1 && axis_y == 0) {
                            showkey(201);
                        } else if (axis_x == 1 && axis_y == 0) {
                            showkey(202);
                        } else if (axis_x == 0 && axis_y == 0) {
                            showkey(0);
                        } else if (axis_x == 0 && axis_y == -1) {
                            showkey(203);
                        } else if (axis_x == 0 && axis_y == 1) {
                            showkey(204);
                        } else if (axis_x == -1 && axis_y == -1) {
                            showkey(205);
                        } else if (axis_x == 1 && axis_y == -1) {
                            showkey(206);
                        } else if (axis_x == 1 && axis_y == 1) {
                            showkey(207);
                        } else if (axis_x == -1 && axis_y == 1) {
                            showkey(208);
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
                if (action == event.ACTION_UP) {
//                    showkey.setVisibility(View.GONE);
                    showkey(0);
                    return true;
                }
                Log.e(TAG, "onKey: " + keyCode + "," + action);
                switch (keyCode) {
                    case KeyEvent.KEYCODE_CALL:
                        return true;
                    case KeyEvent.KEYCODE_SYM:
                        return true;
                    case KeyEvent.KEYCODE_VOLUME_DOWN:
                        return true;
                    case KeyEvent.KEYCODE_VOLUME_UP:
                        return true;
                    case KeyEvent.KEYCODE_STAR:
                        return true;
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
                return false;
            }
        });
    }

    @Override
    public void onProgressChange(int current, int max) {

    }

    private void showkey(int key) {
//        showkey.setVisibility(View.VISIBLE);
        Log.e(TAG, "showkey: "+key);
        switch (key) {
            case 0:
                keyname.setText("");
                keycode.setText("");
                return;
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
            case 201:
                keyname.setText("AXIS_HAT_X");
                keycode.setText("-1");
                return;
            case 202:
                keyname.setText("AXIS_HAT_X");
                keycode.setText("1");
                return;
            case 203:
                keyname.setText("AXIS_HAT_Y");
                keycode.setText("-1");
                return;
            case 204:
                keyname.setText("AXIS_HAT_Y");
                keycode.setText("1");
                return;
            case 205:
                keyname.setText("AXIS_HAT_X  AXIS_HAT_Y");
                keycode.setText("-1  -1");
                return;
            case 206:
                keyname.setText("AXIS_HAT_X  AXIS_HAT_Y");
                keycode.setText("1  -1");
                return;
            case 207:
                keyname.setText("AXIS_HAT_X  AXIS_HAT_Y");
                keycode.setText("1  1");
                return;
            case 208:
                keyname.setText("AXIS_HAT_X  AXIS_HAT_Y");
                keycode.setText("-1  1");
                return;
        }

    }

    public static String floatToStringByTruncate(float num, int remainBitNum) {
        String numStr = Float.toString(num);
        BigDecimal bd = new BigDecimal(numStr);
        bd = bd.setScale(remainBitNum,BigDecimal.ROUND_DOWN);
        return bd.toString();
    }
}
