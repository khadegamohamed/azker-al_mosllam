package com.example.azkeral_moslam;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class sleeptimer extends AppCompatActivity {
    Button selectalarm, setalarm, cancelalarm;
    TextView texttime;
    Calendar calandersleep;
    AlarmManager alarmmanger;
    private MaterialTimePicker timepicker;
sheredprefrence timepickerdata;
    Data datainput;
    long timeDiff;
    MediaPlayer mediaplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleeptimer);
        selectalarm = findViewById(R.id.selectalarm);

        cancelalarm = findViewById(R.id.cancelalarm);
        texttime = findViewById(R.id.texttime);

        cancelalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaplayer = MediaPlayer.create(sleeptimer.this,R.raw.azan);
                mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaplayer.release();
                        mediaplayer =null;
                    }
                });
            }
        });
        timepickerdata = new sheredprefrence(getApplicationContext());
      selectalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showtimepicker();
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
        timepicker.show(getSupportFragmentManager(), "sleep timer");
        timepicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timepicker.getHour() >= 12) {
                    texttime.setText(String.format(Locale.getDefault(), "%02d:%02d PM", timepicker.getHour(), timepicker.getMinute()));
                } else {
                    texttime.setText(timepicker.getHour() + " : " + timepicker.getMinute() + " AM");
                }
               int hour = timepicker.getHour();
                int min = timepicker.getMinute();

                timepickerdata.setPickerhour(hour);
                timepickerdata.setPickermin(min);
                String time = hour + "" + ":" + min + "";
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
                PeriodicWorkRequest sleepWorkRequest =
                        new PeriodicWorkRequest
                                .Builder(sleepworker.class, 1, TimeUnit.DAYS, 25, TimeUnit.HOURS)
                                .setInputData(datainput)
                                .setInitialDelay(timeDiff,TimeUnit.MILLISECONDS)
                                .addTag("sleep_worker")
                                .build();
                WorkManager.
                        getInstance(getApplicationContext()).
                        enqueueUniquePeriodicWork("sleep_worker",
                                ExistingPeriodicWorkPolicy.REPLACE,
                                sleepWorkRequest);

            }
        });

    }



    }
