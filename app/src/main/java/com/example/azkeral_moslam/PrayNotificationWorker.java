package com.example.azkeral_moslam;

import androidx.work.Worker;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.azkeral_moslam.R;

public class PrayNotificationWorker extends Worker {

    private static final String PRAYER_CHANNEL_ID = "PRAYER_CHANNEL";
    private static final String TAG = "PrayerNotification";
    NotificationManager notificationManager;


    public PrayNotificationWorker(@NonNull  Context context, @NonNull  WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Data data = getInputData();
        Log.d(TAG, "doWork: " + data.getString("PRAYER"));
        long timeDiff = data.getLong("TIME_DIFF", -1);
        if (timeDiff>=0) {
            sendNotification(data);
            return Result.success();
        }
        else return Result.failure();
    }
    private void sendNotification(Data data) {
        Intent intentt = new Intent(getApplicationContext(), first.class);
        intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pending = PendingIntent.getActivity(getApplicationContext(),15,intentt, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), PRAYER_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_bedtime_24)
                .setContentTitle(data.getString("PRAYER"))
                .setContentText("حي على الصلاة")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
               .setContentIntent(pending);
builder.setSound(Uri.parse("android.resource://"+getApplicationContext().getPackageName()+"/"+R.raw.azan));
        notificationManager =
                (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        // Create notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Prayer Azan's notification channel";
            String description = "Channel for Prayer Azan";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel notificationChannel = new NotificationChannel(PRAYER_CHANNEL_ID, name, importance);
            notificationChannel.setDescription(description);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManager.notify(1, builder.build());
    }







}
