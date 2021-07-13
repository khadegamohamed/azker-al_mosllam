package com.example.azkeral_moslam;


import android.app.AlarmManager;
import android.app.PendingIntent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRequest extends BroadcastReceiver {
    private static ApiRequest instance = null;
   public static String ishaaaa;
public static  String  dhur;
public static String fjer;
public static String asrrr;
public static  String Maghred;
   public static ArrayList<String>  times ;
   private ApiRequest(){};
   public static ApiRequest getttInstance(){
       if(instance == null){
           instance = new ApiRequest();
       }
       return (instance);
   }


    @Override
    public void onReceive(Context context, Intent intent) {
sheredprefrence spp = new sheredprefrence(context);
      Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.pray.zone/v2/times/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         ArrayList<String>  times = new ArrayList<>();
        Interfaceretriofit intrface = retrofit.create(Interfaceretriofit.class);
        Call<TimeResponse> call =intrface.getpost("CAIRO",5 ,1);

        call.enqueue(new Callback<TimeResponse>() {
            @Override
            public void onResponse(Call<TimeResponse> call, Response<TimeResponse> response) {
                times.add(response.body().getResults().getDatetime().get(0).getTimes().getImsak());
                times.add(response.body().getResults().getDatetime().get(0).getTimes().getDhuhr());
                times.add(response.body().getResults().getDatetime().get(0).getTimes().getAsr());
                times.add(response.body().getResults().getDatetime().get(0).getTimes().getMaghrib());
                times.add(response.body().getResults().getDatetime().get(0).getTimes().getIsha());
                 fjer = times.get(0);
                 dhur = times.get(1);
                 asrrr =times.get(2);
                 Maghred = times.get(3);
                 ishaaaa = times.get(4);
                Log.d("Request",fjer);
                Log.d("Request",dhur);
                Log.d("Request",asrrr);
                Log.d("Request",Maghred);
                Log.d("Request",ishaaaa);
                Log.d("RE","THE GOOD");
             spp.setFager(fjer,dhur,asrrr,Maghred,ishaaaa);
            String test =  spp.getAsr();
                Log.d("hello", test);
            }

            @Override
            public void onFailure(Call<TimeResponse> call, Throwable t) {
                Log.d("ERROR","ERROR");
            }
        });



    }
}
