package com.example.azkeral_moslam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import com.google.android.material.timepicker.MaterialTimePicker;

public class sleeptimer extends AppCompatActivity {
Button selectalarm,setalarm,cancelalarm;
private MaterialTimePicker timepicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleeptimer);
        selectalarm = findViewById(R.id.selectalarm);
        setalarm=findViewById(R.id.setalarm);
        cancelalarm = findViewById(R.id.cancelalarm);

        selectalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        showtimepicker();
            }


        });

        setalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cancelalarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
    private void showtimepicker() {
    }

}