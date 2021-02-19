package com.example.azkeral_moslam;


import android.app.AlarmManager;
import android.app.PendingIntent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class reciveractivtay extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

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
                Intent moringandnight = new Intent(context,Moringandnight.class);
                moringandnight.putExtra("title","اذكار الصباح");
                moringandnight.putExtra("title","اذكار المساء");
                String fager = times.get(1);
                String fajerspilt[] = fager.split(":");
                int hourf = Integer.parseInt(fajerspilt[0]);
                int minf = Integer.parseInt(fajerspilt[1]);
                int minmoring = minf+20;
                int hourmoring = hourf;
                if(minmoring>=60){
                    hourmoring  = hourmoring+1;
                }
                Calendar fajer = Calendar.getInstance();
                fajer.set(Calendar.HOUR_OF_DAY,hourf);
                fajer.set(Calendar.MINUTE,minf);
                Calendar moring = Calendar.getInstance();
                moring.set(Calendar.HOUR_OF_DAY,hourmoring);
              moring.set(Calendar.MINUTE,minmoring);
                String dhuhr = times.get(2);
                String duherspilt[] = dhuhr.split(":");
                int hourd= Integer.parseInt(duherspilt[0]);
                int mind  = Integer.parseInt(duherspilt[1]);
                Calendar duher = Calendar.getInstance();
                duher.set(Calendar.HOUR_OF_DAY,hourd);
                duher.set(Calendar.MINUTE,mind);
                String asr = times.get(3);
                String asrspilt[] = asr.split(":");
                int houra = Integer.parseInt(asrspilt[0]);
                int mina = Integer.parseInt(asrspilt[1]);
                Calendar asrr = Calendar.getInstance();
                asrr.set(Calendar.HOUR_OF_DAY,houra);
                asrr.set(Calendar.MINUTE,mina);
                int hournigght = houra;
                int minnight = mina+20;
                Calendar night = Calendar.getInstance();
                night.set(Calendar.HOUR_OF_DAY,hournigght);
                night.set(Calendar.MINUTE,minnight);
                String maghrib = times.get(4);
                String maghribb[] = maghrib.split(":");
                int hourm = Integer.parseInt(maghribb[0]);
                int minm = Integer.parseInt(maghribb[1]);
                Calendar magh = Calendar.getInstance();
                magh.set(Calendar.HOUR_OF_DAY,hourm);
                magh.set(Calendar.MINUTE,minm);
                String isha = times.get(5);
                String ishaspilit[] = isha.split(":");
                int hourh = Integer.parseInt(ishaspilit[0]);
                int minh = Integer.parseInt(ishaspilit[1]);
                Calendar ishaa = Calendar.getInstance();
                ishaa.set(Calendar.HOUR_OF_DAY,hourh);
                ishaa.set(Calendar.MINUTE,minh);
                AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                Intent prays  = new Intent(context,notifactionreciver.class);
                PendingIntent pend  = PendingIntent.getBroadcast(context,10,prays,PendingIntent.FLAG_UPDATE_CURRENT);
                prays.putExtra("pray name","اذان الفجر ");
                alarm.setRepeating(AlarmManager.RTC_WAKEUP,fajer.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pend);
                prays.putExtra("pray name","اذان الظهر ");
                alarm.setRepeating(AlarmManager.RTC_WAKEUP,duher.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pend);
                prays.putExtra("pray name","اذان العصر ");
                alarm.setRepeating(AlarmManager.RTC_WAKEUP,asrr.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pend);
                prays.putExtra("pray name","اذان المغرب ");
                alarm.setRepeating(AlarmManager.RTC_WAKEUP,magh.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pend);
                prays.putExtra("pray name","اذان العشاء ");
                alarm.setRepeating(AlarmManager.RTC_WAKEUP,ishaa.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pend);
                Intent newintent = new Intent(context,Moringandnight.class);
                PendingIntent pendmoringandnight  = PendingIntent.getBroadcast(context,10,newintent,PendingIntent.FLAG_UPDATE_CURRENT);
                alarm.setRepeating(AlarmManager.RTC_WAKEUP,moring.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendmoringandnight);
                alarm.setRepeating(AlarmManager.RTC_WAKEUP,night.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendmoringandnight);

            }

            @Override
            public void onFailure(Call<Times> call, Throwable t) {
                Log.d("ERROR","ERROR");
            }
        });



    }
}
