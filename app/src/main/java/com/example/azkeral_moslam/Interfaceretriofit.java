package com.example.azkeral_moslam;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interfaceretriofit {
    @GET("today.json")
    public Call<Times> getpost(@Query("city") String city );


}
