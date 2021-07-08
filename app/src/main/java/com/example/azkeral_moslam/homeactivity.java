package com.example.azkeral_moslam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class homeactivity extends AppCompatActivity {
ImageView moring,night,sleep,pray;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);
        moring = findViewById(R.id.moring);
        night = findViewById(R.id.night);
        sleep = findViewById(R.id.sleep);
        pray = findViewById(R.id.pray);
b1= findViewById(R.id.buttonapi);


        moring.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent mornning = new Intent(homeactivity.this,Morning.class);
        startActivity(mornning);
    }
});
night.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent night= new Intent(homeactivity.this, night.class);
        startActivity(night);
    }
});
sleep.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent sleep = new Intent(homeactivity.this, sleep.class);
        startActivity(sleep);
    }
});

pray.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent pray = new Intent(homeactivity.this, pray.class );
        startActivity(pray);
    }
});


    }
}