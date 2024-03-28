package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Date_Time_Activity extends AppCompatActivity {
    TextView showdate,showtime;
    Button btndate,btntime;
    int date,month;
    private int year;
    private int minute;
    private int hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        showdate = findViewById(R.id.Show_date);
        btndate = findViewById(R.id.btn_date);
        showtime = findViewById(R.id.Show_time);
        btntime = findViewById(R.id.btn_time);

        Calendar calendar = Calendar.getInstance();
        date = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);

        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        btntime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Date_Time_Activity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int minute, int hour) {
                                showtime.setText(minute+" : "+hour);
                            }
            }, hour,minute,true);
            timePickerDialog.show();
            }
        });
        btndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Date_Time_Activity.this, new DatePickerDialog.OnDateSetListener(){
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayofmonth) {
                        showdate.setText(dayofmonth+"-"+(month+1)+"-"+year);
                    }
                },year,month,date);
                datePickerDialog.show();
            }
        });
    }
}