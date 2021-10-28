package com.example.azkeral_moslam;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrayApiclient {
public  static Retrofit Instance;
public  static Interfaceretriofit request;
public  static Retrofit getInstance(){
    if(Instance == null){
         Instance = new Retrofit.Builder().baseUrl("https://api.pray.zone/v2/times/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();
    }
    return  Instance;
}

public  static Interfaceretriofit getRequest(){
    if (request == null){
        request = getInstance().create(Interfaceretriofit.class);
    }
    return request;
}



}
