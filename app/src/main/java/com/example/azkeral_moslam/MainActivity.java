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
        caland.set(Calendar.HOUR_OF_DAY,24);
        caland.set(Calendar.MINUTE,1);
        caland.set(Calendar.SECOND,30);
        Intent intent = new Intent(MainActivity.this, ApiRequest.class);
        PendingIntent pending = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,caland.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pending);

//Calendar sleepclander = Calendar.getInstance();
//sleepclander.set(Calendar.HOUR_OF_DAY,24);
//sleepclander.set(Calendar.MINUTE,0);
//sleepclander.set(Calendar.SECOND,30);
 //Intent sleepintent = new Intent(MainActivity.this, sleepnotification.class);
//PendingIntent pendsleep = PendingIntent.getBroadcast(getApplicationContext(),20,sleepintent,PendingIntent.FLAG_UPDATE_CURRENT);
        //alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,sleepclander.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendsleep);
//sleepintent.putExtra("sleepazker","اذكار النوم");


    }
}