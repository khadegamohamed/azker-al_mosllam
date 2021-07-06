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

public class ApiRequest extends BroadcastReceiver {


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
                Log.d("Request","the request good");
                //Alarm manger
                AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
               //fajer
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
                Intent fajerintent  = new Intent(context, AzanNotification.class);
                PendingIntent fajerpend  = PendingIntent.getBroadcast(context,5,fajerintent,PendingIntent.FLAG_UPDATE_CURRENT);
                fajerintent.putExtra("pray name","اذان الفجر ");
                alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,fajer.getTimeInMillis(),AlarmManager.INTERVAL_DAY,fajerpend);
              //dhuhr
                String dhuhr = times.get(2);
                String duherspilt[] = dhuhr.split(":");
                int hourd= Integer.parseInt(duherspilt[0]);
                int mind  = Integer.parseInt(duherspilt[1]);
                Calendar duher = Calendar.getInstance();
                duher.set(Calendar.HOUR_OF_DAY,hourd);
                duher.set(Calendar.MINUTE,mind);
                Intent dhuherintent  = new Intent(context, AzanNotification.class);
                PendingIntent dhuherpend  = PendingIntent.getBroadcast(context,7,dhuherintent,PendingIntent.FLAG_UPDATE_CURRENT);
                dhuherintent.putExtra("pray name","اذان الظهر ");
                alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,duher.getTimeInMillis(),AlarmManager.INTERVAL_DAY,dhuherpend);
                //Asr
                String asr = times.get(3);
                String asrspilt[] = asr.split(":");
                int houra = Integer.parseInt(asrspilt[0]);
                int mina = Integer.parseInt(asrspilt[1]);
                Calendar asrr = Calendar.getInstance();
                asrr.set(Calendar.HOUR_OF_DAY,houra);
                asrr.set(Calendar.MINUTE,mina);
                Intent aserintent  = new Intent(context, AzanNotification.class);
                PendingIntent aserpend  = PendingIntent.getBroadcast(context,6,aserintent,PendingIntent.FLAG_UPDATE_CURRENT);
                aserintent.putExtra("pray name","اذان العصر ");
                alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,asrr.getTimeInMillis(),AlarmManager.INTERVAL_DAY,aserpend);
                //maghribb
                String maghrib = times.get(4);
                String maghribb[] = maghrib.split(":");
                int hourm = Integer.parseInt(maghribb[0]);
                int minm = Integer.parseInt(maghribb[1]);
                Calendar magh = Calendar.getInstance();
                magh.set(Calendar.HOUR_OF_DAY,hourm);
                magh.set(Calendar.MINUTE,minm);
                Intent maghribintent  = new Intent(context, AzanNotification.class);
                PendingIntent maghribpend  = PendingIntent.getBroadcast(context,8,maghribintent,PendingIntent.FLAG_UPDATE_CURRENT);
                maghribintent.putExtra("pray name","اذان المغرب ");
                alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,magh.getTimeInMillis(),AlarmManager.INTERVAL_DAY,maghribpend);
                //isha
                String isha = times.get(5);
                String ishaspilit[] = isha.split(":");
                int hourh = Integer.parseInt(ishaspilit[0]);
                int minh = Integer.parseInt(ishaspilit[1]);
                Calendar ishaa = Calendar.getInstance();
                ishaa.set(Calendar.HOUR_OF_DAY,hourh);
                ishaa.set(Calendar.MINUTE,minh);
                Intent ishaintent  = new Intent(context, AzanNotification.class);
                PendingIntent ishapend  = PendingIntent.getBroadcast(context,9,ishaintent,PendingIntent.FLAG_UPDATE_CURRENT);
                ishaintent.putExtra("pray name","اذان العشاء ");
                alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,ishaa.getTimeInMillis(),AlarmManager.INTERVAL_DAY,ishapend);
                //moringazker
                Calendar moring = Calendar.getInstance();
                moring.set(Calendar.HOUR_OF_DAY,hourmoring);
                moring.set(Calendar.MINUTE,minmoring);
                Intent morningazker = new Intent(context, AzkerMorningandnight.class);
                PendingIntent intentmorning = PendingIntent.getBroadcast(context,3,morningazker,PendingIntent.FLAG_UPDATE_CURRENT);
                morningazker.putExtra("title","اذكار الصباح");
                alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,moring.getTimeInMillis(),AlarmManager.INTERVAL_DAY,intentmorning);
                //nightazker
                int hournigght = houra;
                int minnight = mina+20;
                Calendar night = Calendar.getInstance();
                night.set(Calendar.HOUR_OF_DAY,hournigght);
                night.set(Calendar.MINUTE,minnight);
                Intent nightazker = new Intent(context, AzkerMorningandnight.class);
                nightazker.putExtra("title","اذكار المساء");
                PendingIntent intentnight = PendingIntent.getBroadcast(context,4,nightazker,PendingIntent.FLAG_UPDATE_CURRENT);
                alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,night.getTimeInMillis(),AlarmManager.INTERVAL_DAY,intentnight);

            }

            @Override
            public void onFailure(Call<Times> call, Throwable t) {
                Log.d("ERROR","ERROR");
            }
        });



    }
}
