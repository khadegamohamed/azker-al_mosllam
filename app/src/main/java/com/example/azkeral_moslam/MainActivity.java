package com.example.azkeral_moslam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.pray.zone/v2/times/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ArrayList<String>  times = new ArrayList<>();
        Interfaceretriofit intrface = retrofit.create(Interfaceretriofit.class);
        Call<Times> call =intrface.getpost("EGYPT");
      call.enqueue(new Callback<Times>() {
          @Override
          public void onResponse(Call<Times> call, Response<Times> response) {
              times.add(response.body().getFajr());
              times.add(response.body().getDhuhr());
              times.add(response.body().getAsr());
              times.add(response.body().getMaghrib());
              times.add(response.body().getIsha());
              Log.d("Request","the request good");

          }

          @Override
          public void onFailure(Call<Times> call, Throwable t) {
              Log.d("ERROR","the request bad");

          }
      });

       /*Calendar caland= Calendar.getInstance();
       caland.set(Calendar.HOUR_OF_DAY,10);
         caland.set(Calendar.MINUTE,32);
        caland.set(Calendar.SECOND,0);
        caland.set(Calendar.MILLISECOND,0);
        Intent intent = new Intent(MainActivity.this, fakecalnder.class);
        PendingIntent pending = PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);
        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,caland.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pending);*/



    }
}