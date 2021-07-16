package com.example.azkeral_moslam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.example.azkeral_moslam.ApiRequest;
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


sheredprefrence sssp = new sheredprefrence(getApplicationContext());
       Calendar caland= Calendar.getInstance();
       caland.set(Calendar.HOUR_OF_DAY,20);
         caland.set(Calendar.MINUTE,14);
        caland.set(Calendar.SECOND,0);
        caland.set(Calendar.MILLISECOND,0);
      if(caland.getTime().compareTo(new Date())<0){
     caland.add(Calendar.DAY_OF_MONTH,1);
    }
        Intent intent = new Intent(MainActivity.this, ApiRequest.class);

        PendingIntent pending = PendingIntent.getBroadcast(getApplicationContext(),0,intent,0);
       intent.setData((Uri.parse("custom://"+System.currentTimeMillis())));

        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm.cancel(pending);
     if (alarm != null) {
      alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,caland.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pending);
     }

        //fajer
    // Calendar nowf = Calendar.getInstance();
String ff = sssp.getFager();
        String[] fajerspilt= ff.split(":");
        int hourf = Integer.parseInt(fajerspilt[0]);
        int minf = Integer.parseInt(fajerspilt[1]);
        Log.d("FAJER", fajerspilt[0]);
        Log.d("FAJER", fajerspilt[1]);
        int minmoring = minf+20;
        int hourmoring = hourf;

        Calendar fajer = Calendar.getInstance();
        fajer.set(Calendar.HOUR_OF_DAY,hourf);
        fajer.set(Calendar.MINUTE,minf);
     if(fajer.getTime().compareTo(new Date())<0){
     fajer.add(Calendar.DAY_OF_MONTH,1);
     }
        Log.d("hello","fajer");
        Intent fajerintent  = new Intent(MainActivity.this, AzanNotification.class);
        PendingIntent fajerpend  = PendingIntent.getBroadcast(getApplicationContext(),5,fajerintent,PendingIntent.FLAG_UPDATE_CURRENT);
     fajerintent.setData((Uri.parse("custom://"+System.currentTimeMillis())));
        fajerintent.putExtra("pray name","اذان الفجر ");

         alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, fajer.getTimeInMillis(), AlarmManager.INTERVAL_DAY, fajerpend);

        alarm.cancel(fajerpend);
       //moringazker
        Calendar moring = Calendar.getInstance();
     Calendar nowm = Calendar.getInstance();
        moring.set(Calendar.HOUR_OF_DAY,hourmoring);
        moring.set(Calendar.MINUTE,minmoring);
     if(nowm.after(moring)){
      Log.d("he", "onCreate: add aday");
      moring.add(Calendar.DATE,1);
     }
        Log.d("hello","morning");
        Intent morningazker = new Intent(MainActivity.this, AzkerMorningandnight.class);
     morningazker.setData((Uri.parse("custom://"+System.currentTimeMillis())));
        PendingIntent intentmorning = PendingIntent.getBroadcast(getApplicationContext(),3,morningazker,PendingIntent.FLAG_UPDATE_CURRENT);
        morningazker.putExtra("title","اذكار الصباح");
       alarm.cancel(intentmorning);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,moring.getTimeInMillis(),AlarmManager.INTERVAL_DAY,intentmorning);


        //dhur
        String dd  = sssp.getDhur();
        String duherspilt[] = dd.split(":");
        int hourd= Integer.parseInt(duherspilt[0]);
        int mind  = Integer.parseInt(duherspilt[1]);
        Calendar duher = Calendar.getInstance();
     Calendar nowd = Calendar.getInstance();
        duher.set(Calendar.HOUR_OF_DAY,hourd);
        duher.set(Calendar.MINUTE,mind);
     if(nowd.after(duher)){
      Log.d("he", "onCreate: add aday");
      duher.add(Calendar.DATE,1);
     }
        Log.d("hello","dhur");
        Intent dhuherintent  = new Intent(MainActivity.this, AzanNotification.class);
        PendingIntent dhuherpend  = PendingIntent.getBroadcast(getApplicationContext(),7,dhuherintent,PendingIntent.FLAG_UPDATE_CURRENT);
     dhuherintent.setData((Uri.parse("custom://"+System.currentTimeMillis())));
        dhuherintent.putExtra("pray name","اذان الظهر ");
        alarm.cancel(dhuherpend);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,duher.getTimeInMillis(),AlarmManager.INTERVAL_DAY,dhuherpend);
//Asr
String aa = sssp.getAsr();
     String asrspilt[] = aa.split(":");
        int houra = Integer.parseInt(asrspilt[0]);
        int mina = Integer.parseInt(asrspilt[1]);
        Calendar asrr = Calendar.getInstance();
     Calendar nowa = Calendar.getInstance();
        asrr.set(Calendar.HOUR_OF_DAY,houra);
        asrr.set(Calendar.MINUTE,mina);
     if(nowa.after(asrr)){
      Log.d("he", "onCreate: add aday");
      asrr.add(Calendar.DATE,1);
     }
        Log.d("hello","aasr");
        Intent aserintent  = new Intent(MainActivity.this, AzanNotification.class);
        PendingIntent aserpend  = PendingIntent.getBroadcast(getApplicationContext(),6,aserintent,PendingIntent.FLAG_UPDATE_CURRENT);
     aserintent.setData((Uri.parse("custom://"+System.currentTimeMillis())));
        aserintent.putExtra("pray name","اذان العصر ");
        alarm.cancel(aserpend);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,asrr.getTimeInMillis(),AlarmManager.INTERVAL_DAY,aserpend);
        //maghribb
String maghred = sssp.getMghred();
        String maghribb[] = maghred.split(":");
        int hourm = Integer.parseInt(maghribb[0]);
        int minm = Integer.parseInt(maghribb[1]);
        Calendar magh = Calendar.getInstance();
     Calendar nowmm = Calendar.getInstance();
        magh.set(Calendar.HOUR_OF_DAY,hourm);
        magh.set(Calendar.MINUTE,minm);
     if(nowmm.after(magh)){
      Log.d("he", "onCreate: add aday");
      magh.add(Calendar.DATE,1);
     }
        Log.d("hello","maghred");
        Intent maghribintent  = new Intent(MainActivity.this, AzanNotification.class);
        PendingIntent maghribpend  = PendingIntent.getBroadcast(getApplicationContext(),8,maghribintent,PendingIntent.FLAG_UPDATE_CURRENT);
     maghribintent.setData((Uri.parse("custom://"+System.currentTimeMillis())));
        maghribintent.putExtra("pray name","اذان المغرب ");
        alarm.cancel(maghribpend);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,magh.getTimeInMillis(),AlarmManager.INTERVAL_DAY,maghribpend);
        //isha
String ii = sssp.getIshaa();
        String ishaspilit[] = ii.split(":");
        int hourh = Integer.parseInt(ishaspilit[0]);
        int minh = Integer.parseInt(ishaspilit[1]);
        Calendar ishaa = Calendar.getInstance();
     Calendar nowii = Calendar.getInstance();
        ishaa.set(Calendar.HOUR_OF_DAY,hourh);
        ishaa.set(Calendar.MINUTE,minh);
     if(nowii.after(ishaa)){
      Log.d("he", "onCreate: add aday");
      ishaa.add(Calendar.DATE,1);
     }
        Log.d("hello","ishaaa");
        Intent ishaintent  = new Intent(MainActivity.this, AzanNotification.class);
        PendingIntent ishapend  = PendingIntent.getBroadcast(getApplicationContext(),9,ishaintent,PendingIntent.FLAG_UPDATE_CURRENT);
     ishaintent.setData((Uri.parse("custom://"+System.currentTimeMillis())));
        ishaintent.putExtra("pray name","اذان العشاء ");
      alarm.cancel(ishapend);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,ishaa.getTimeInMillis(),AlarmManager.INTERVAL_DAY,ishapend);

        //nightazker
        int hournigght = houra;
        int minnight = mina+20;
        Calendar night = Calendar.getInstance();
     Calendar nownn = Calendar.getInstance();
        night.set(Calendar.HOUR_OF_DAY,hournigght);
        night.set(Calendar.MINUTE,minnight);
     if(nownn.after(night)){
      Log.d("he", "onCreate: add aday");
      night.add(Calendar.DATE,1);
     }
        Log.d("hello","night");
        Intent nightazker = new Intent(MainActivity.this, AzkerMorningandnight.class);
        nightazker.putExtra("title","اذكار المساء");
        PendingIntent intentnight = PendingIntent.getBroadcast(getApplicationContext(),4,nightazker,PendingIntent.FLAG_UPDATE_CURRENT);
     nightazker.setData((Uri.parse("custom://"+System.currentTimeMillis())));
     alarm.cancel(intentnight);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP,night.getTimeInMillis(),AlarmManager.INTERVAL_DAY,intentnight);

    }
}