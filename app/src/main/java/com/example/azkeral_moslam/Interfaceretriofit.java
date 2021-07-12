package com.example.azkeral_moslam;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interfaceretriofit {
    @GET("today.json")
    public Call<TimeResponse> getpost(@Query("city") String city ,@Query("school") int school ,@Query("juristic") int jur);


}
