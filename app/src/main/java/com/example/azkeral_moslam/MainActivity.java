package com.example.azkeral_moslam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
private final int Splash_Display_Length=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     new Handler().postDelayed(new Runnable() {
         @Override
         public void run() {
             Intent mainIntent = new Intent(MainActivity.this,homeactivity.class);
             startActivity(mainIntent);
             finish();
         }
     },Splash_Display_Length);

        Calendar caland= Calendar.getInstance();
        caland.set(Calendar.HOUR_OF_DAY,01);
        caland.set(Calendar.MINUTE,20);
        caland.set(Calendar.SECOND,30);
        Intent intent = new Intent(MainActivity.this, ApiRequest.class);
        PendingIntent pending = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_ONE_SHOT);
        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,caland.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pending);



    }
}