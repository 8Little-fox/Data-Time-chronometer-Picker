package com.example.datapicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

public class chronometerTest extends AppCompatActivity {
    private Chronometer chronometer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chronometer_test);
        chronometer=findViewById(R.id.ch);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.setFormat("%s");
        chronometer.start();
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime()-chronometer.getBase()>60000){
                    chronometer.stop();
                }
            }
        });
    }
}
