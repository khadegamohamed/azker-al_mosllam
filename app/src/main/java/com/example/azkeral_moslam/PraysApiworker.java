package com.example.azkeral_moslam;

import android.content.Context;

import androidx.annotation.NonNull;

import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Scheduler;
import retrofit2.Call;
import retrofit2.Response;
import java.util.Calendar;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class PraysApiworker  extends Worker {

     public PraysApiworker(@NonNull Context context,@NonNull WorkerParameters workerParams ) {
        super(context , workerParams);
     }
    sheredprefrence spp = new sheredprefrence(getApplicationContext());
    @NonNull
    @Override
    public Result doWork() {
       Call<TimeResponse> prayersRequest = PrayApiclient.getRequest().getpost("CAIRO",5,1);
try{

    Response<TimeResponse> prayresponse= prayersRequest.execute();
    TimeResponse apirespons = prayresponse.body();
Times prayerTimes = apirespons.getResults().getDatetime().get(0).getTimes();
    HashMap<String, String> prayerTimesString = new HashMap<>();
spp.setFager(prayerTimes.getFajr(),prayerTimes.getSunrise(),prayerTimes.getDhuhr(),prayerTimes.getAsr(),prayerTimes.getMaghrib(),prayerTimes.getIsha());
   String fajer1[] = prayerTimes.getFajr().split(":");
   int houroffajer=Integer.parseInt(fajer1[0]);
    int minoffajer=Integer.parseInt(fajer1[1]);
   int morninghhh = houroffajer;
   int morningmin = minoffajer+20;
   if(morningmin>= 60 ){
       morninghhh = houroffajer+1;
   }
   String Moring  = morninghhh+""+":"+morningmin+"";
    String ASer[] = prayerTimes.getAsr().split(":");
    int hourofaser=Integer.parseInt(ASer[0]);
    int minoffaser=Integer.parseInt(ASer[1]);
    int nighthh = hourofaser;
    int nightmm= minoffaser+20;
    if(nightmm>= 60 ){
      nighthh = hourofaser+1;
    }
    String night= nighthh+""+":"+nightmm+"";
    prayerTimesString.put("صلاة الفجر", prayerTimes.getFajr());
    prayerTimesString.put("شروق الشمس", prayerTimes.getSunrise());
    prayerTimesString.put("صلاة الظهر", prayerTimes.getDhuhr());
    prayerTimesString.put("صلاة العصر", prayerTimes.getAsr());
    prayerTimesString.put("صلاة المغرب", prayerTimes.getMaghrib());
    prayerTimesString.put("صلاة العشاء", prayerTimes.getIsha());
   // prayerTimesString.put("Imsak", prayerTimes.getImsak());
   // prayerTimesString.put("Mid night", prayerTimes.getMidnight());
   // prayerTimesString.put("Sunset", prayerTimes.getSunset());
    prayerTimesString.put("اذكار الصباح",Moring);
    prayerTimesString.put("اذكار المساء",night);
for(Map.Entry<String,String> prayer : prayerTimesString.entrySet()){
    Calendar currentTime = Calendar.getInstance();
    Calendar prayerCalendar = Calendar.getInstance();
    prayerCalendar.setTime(new SimpleDateFormat("HH:mm", Locale.getDefault()).parse(prayer.getValue()));
    prayerCalendar.set(Calendar.DAY_OF_MONTH, currentTime.get(Calendar.DAY_OF_MONTH));
    prayerCalendar.set(Calendar.MONTH, currentTime.get(Calendar.MONTH));
    prayerCalendar.set(Calendar.YEAR, currentTime.get(Calendar.YEAR));
    prayerCalendar.set(Calendar.SECOND, 0);
    if (prayerCalendar.before(currentTime.getTimeInMillis())) {
        prayerCalendar.add(Calendar.DAY_OF_MONTH, 1);
    }
    long timeDiff = prayerCalendar.getTimeInMillis() - currentTime.getTimeInMillis();
Data input = new Data.Builder().putString("PRAYER", prayer.getKey())
        .putLong("TIME_DIFF", timeDiff)
        .build();
    OneTimeWorkRequest prayworkerrequest=new OneTimeWorkRequest.Builder(PrayNotificationWorker.class)
            .setInitialDelay(timeDiff, TimeUnit.MILLISECONDS)
            .setInputData(input)
            .build();
    WorkManager.getInstance(getApplicationContext()).enqueue(prayworkerrequest);
}
    if(prayresponse.isSuccessful()){
    return Result.success();
}else {
    return Result.failure();
}
} catch (IOException | ParseException e) {
    e.printStackTrace();
    return Result.failure();
}
    }
}
