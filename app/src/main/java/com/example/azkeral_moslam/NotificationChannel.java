package com.example.azkeral_moslam;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Build;

public class NotificationChannel extends Application {
public static final String channel_1="channel1";
    @Override
    public void onCreate() {
        super.onCreate();
        creatchannel();
    }

    private void creatchannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
           android.app.NotificationChannel channnel1 = new android.app.NotificationChannel(
                   channel_1,
                   "channel 1",
                   NotificationManager.IMPORTANCE_HIGH
           );
           channnel1.enableVibration(true);
           NotificationManager manger =getSystemService(NotificationManager.class);
           manger.createNotificationChannel(channnel1);
        }
    }
}
