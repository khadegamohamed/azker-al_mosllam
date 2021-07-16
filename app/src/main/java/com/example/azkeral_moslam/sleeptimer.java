package com.example.azkeral_moslam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.util.Calendar;

public class sleeptimer extends AppCompatActivity {
Button selectalarm,setalarm,cancelalarm;
TextView texttime;
Calendar calandersleep;
    AlarmManager alarmmanger;
private MaterialTimePicker timepicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleeptimer);
        selectalarm = findViewById(R.id.selectalarm);
        setalarm=findViewById(R.id.setalarm);
        cancelalarm = findViewById(R.id.cancelalarm);
                texttime = findViewById(R.id.texttime);
        selectalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showtimepicker();
            }


        });



        cancelalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        cancelalarm();
            }
        });

    }
    private void showtimepicker() {
        timepicker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .setHour(12)
                .setMinute(0)
                .setTitleText("select alarm time")
                .build();
        timepicker.show(getSupportFragmentManager(),"sleep timer");
        timepicker.addOnPositiveButtonClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(timepicker.getHour() > 12){
                    texttime.setText(String.format("%02d",timepicker.getHour()+" : "+"%02d",timepicker.getMinute()+" PM"));
                }else{
                    texttime.setText(timepicker.getHour()+" : "+timepicker.getMinute()+" AM");
                }
                calandersleep =Calendar.getInstance();
                calandersleep.set(Calendar.HOUR_OF_DAY,timepicker.getHour());
                calandersleep.set(Calendar.MINUTE,timepicker.getMinute());
                calandersleep.set(Calendar.SECOND,0);
                calandersleep.set(Calendar.MILLISECOND,0);
                alarmmanger= (AlarmManager) getSystemService(ALARM_SERVICE);
                Intent intentsleep = new Intent(sleeptimer.this ,sleepnotification.class);
                PendingIntent pendslaap= PendingIntent.getBroadcast(getApplicationContext(),99,intentsleep,PendingIntent.FLAG_ONE_SHOT);
                alarmmanger.setInexactRepeating(AlarmManager.RTC_WAKEUP,calandersleep.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendslaap);
              //Toast.makeText(this,"Alarm set",Toast.LENGTH_LONG).show();


            }
        });

    }


    private void cancelalarm(){
        Intent intentsleep = new Intent(sleeptimer.this ,sleepnotification.class);
        PendingIntent pendslaap= PendingIntent.getBroadcast(getApplicationContext(),90,intentsleep,PendingIntent.FLAG_ONE_SHOT);

        if(alarmmanger  == null){
            alarmmanger = (AlarmManager)getSystemService(ALARM_SERVICE);
        }
        alarmmanger.cancel(pendslaap);
        Toast.makeText(this,"Alarm cancelled",Toast.LENGTH_SHORT).show();

    }

}