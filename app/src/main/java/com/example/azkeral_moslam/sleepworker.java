package com.example.azkeral_moslam;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class sleepworker extends Worker {
    NotificationManager notificationManager;
    private static final String PRAYER_CHANNEL_ID = "AL_AZKER_CHANNEL";

    public sleepworker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Data in = getInputData();
        long timeDiff = in.getLong("delay", -1);
        if (timeDiff >= 0) {
            sendNotification();
            return Result.success();
        } else return Result.failure();


    }


    private void sendNotification() {
        Intent intentt = new Intent(getApplicationContext(), first.class);
        intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pending = PendingIntent.getActivity(getApplicationContext(),15,intentt, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), PRAYER_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_bedtime_24)
                .setContentTitle("اذكار قبل النوم")
                .setContentText("قال تعالي(الا بذكر الله تطمئن القلوب)")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pending);

        notificationManager =
                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "sleep notification channel";
            String description = "Channel for Sleep ";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel notificationChannel = new NotificationChannel(PRAYER_CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManager.notify(9, builder.build());

    }


}





