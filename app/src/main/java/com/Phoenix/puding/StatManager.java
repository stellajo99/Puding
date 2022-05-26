package com.Phoenix.puding;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class StatManager extends AppCompatActivity{
    ProgressBar hungryBar;
    ProgressBar funBar;
    TextView timeTest;
    Timer timer;
    Handler handler;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bind view
        hungryBar = (ProgressBar) findViewById(R.id.hungerBar);
        funBar = (ProgressBar) findViewById(R.id.funBar);

        timeTest = (TextView) findViewById(R.id.time_test);
        timeTest.setText("start");

        TimerTask timerTask = new TimerTask() {
            public void run() {
                decreaseBar();
            }
        };

        timer = new Timer();
        timer.schedule(timerTask,0,1000);
    }

    private String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        String getTime = dateFormat.format(date);

        return getTime;
    }

    private void decreaseBar(){
        timeTest.setText("run");
        Log.d("", "Timer work");
        hungryBar.incrementProgressBy(-2);
        funBar.incrementProgressBy(-1);
        if(hungryBar.getProgress() < 0)
            hungryBar.setProgress(0);
        if(funBar.getProgress() < 0)
            funBar.setProgress(0);
    }
}
