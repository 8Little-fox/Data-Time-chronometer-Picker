package com.example.datapicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DataPickerDemo extends AppCompatActivity {
    private DatePicker datePicker;
    private int year,month,data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_picker_demo);
        datePicker=findViewById(R.id.data);
        final Calendar calendar=Calendar.getInstance();
        calendar.get(Calendar.YEAR);
        calendar.get(Calendar.MONTH);
        calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, month, data, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int m, int d) {
                year=y;
                month=m;
                data=d;
                show(year,month,data);
            }
        });
    }

    private void show(int year, int month, int data) {
        String str=year+"年"+month+"月"+data+"日";
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}
