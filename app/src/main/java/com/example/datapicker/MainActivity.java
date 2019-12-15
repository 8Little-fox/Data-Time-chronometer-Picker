package com.example.datapicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        private Button button;
        private Button button1;
        private TextView textView;
        private TextView textView1;
        Calendar calendar=Calendar.getInstance();
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv1);
        textView1=findViewById(R.id.tv);
        button=findViewById(R.id.but);
        button1=findViewById(R.id.time);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        showdata();
        showTime();
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showdata() {
        this.calendar=Calendar.getInstance();
        DatePickerDialog dialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int data) {
                textView.setText(year+"年"+month+"月"+data+"日");
            }
        },this.calendar.get(Calendar.YEAR),
                this.calendar.get(Calendar.MONTH),
                this.calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    private void showTime() {
        this.calendar=Calendar.getInstance();
        TimePickerDialog dialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int  minute) {
                 textView1.setText(hour+"时"+minute+"分");
            }
        },this.calendar.get(Calendar.HOUR),
                this.calendar.get(Calendar.MINUTE),true);
        dialog.show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.but:
                showdata();
                break;
            case R.id.time:
                showTime();
                break;
        }
    }
}
