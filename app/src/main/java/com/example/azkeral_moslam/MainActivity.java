package com.example.azkeral_moslam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;


public class MainActivity extends AppCompatActivity {
    private final int Splash_Display_Length = 1000;
    Data datainput;
    long timeDiff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(MainActivity.this, first.class);
                startActivity(mainIntent);
                finish();
            }
        }, Splash_Display_Length);

        sheredprefrence shareddata = new sheredprefrence(getApplicationContext());
        int hour = shareddata.getPickerhour();
        int minn = shareddata.getPickermin();

        String time = hour + "" + ":" + minn + "";
        try {
            Calendar currentTime = Calendar.getInstance();
            Calendar prayerCalendar = Calendar.getInstance();

            prayerCalendar.setTime(new SimpleDateFormat("HH:mm", Locale.getDefault()).parse(time));
            prayerCalendar.set(Calendar.DAY_OF_MONTH, currentTime.get(Calendar.DAY_OF_MONTH));
            prayerCalendar.set(Calendar.MONTH, currentTime.get(Calendar.MONTH));
            prayerCalendar.set(Calendar.YEAR, currentTime.get(Calendar.YEAR));
            prayerCalendar.set(Calendar.SECOND, 0);
            if (prayerCalendar.before(currentTime.getTimeInMillis())) {
                prayerCalendar.add(Calendar.DAY_OF_MONTH, 1);
            }
             timeDiff = prayerCalendar.getTimeInMillis() - currentTime.getTimeInMillis();
             datainput =  new Data.Builder().putLong("delay",timeDiff).build();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        enqueueDailyPrayers();
        enqueueDailysleep(datainput,timeDiff);
    }

        private void enqueueDailyPrayers() {
      PeriodicWorkRequest prayersWorkRequest =
              new PeriodicWorkRequest
                      .Builder(PraysApiworker.class, 1, TimeUnit.DAYS, 25, TimeUnit.HOURS)
                      .addTag("API_WORKER")
                      .build();
      WorkManager.
              getInstance(this).
              enqueueUniquePeriodicWork("API_WORKER",
                      ExistingPeriodicWorkPolicy.REPLACE,
                      prayersWorkRequest);
  }
    private void enqueueDailysleep(Data data,Long delay) {
        PeriodicWorkRequest sleepWorkRequest =
                new PeriodicWorkRequest
                        .Builder(sleepworker.class, 1, TimeUnit.DAYS, 25, TimeUnit.HOURS)
                        .setInputData(data)
                        .setInitialDelay(delay,TimeUnit.MILLISECONDS)
                        .addTag("sleep_worker")
                        .build();
        WorkManager.
                getInstance(this).
                enqueueUniquePeriodicWork("sleep_worker",
                        ExistingPeriodicWorkPolicy.REPLACE,
                        sleepWorkRequest);
    }






}