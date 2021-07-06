package com.example.azkeral_moslam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.azkeral_moslam.NotificationChannel;

import static com.example.azkeral_moslam.NotificationChannel.channel_1;

public class AzanNotification extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

       Uri azezsound =Uri.parse("android.resource" + context.getApplicationContext()+"/" + R.raw.azan);
        String title= intent.getStringExtra("pray name");
        Intent intentt = new Intent(context,homeactivity.class);
        intentt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pending = PendingIntent.getBroadcast(context,15,intentt, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder build = new NotificationCompat.Builder(context,channel_1)
                .setContentIntent(pending)
                .setSmallIcon(R.drawable.ic_baseline_bedtime_24)
                .setContentTitle(title)
                .setContentText("قال الرسول صلي الله عليه وسلم(( إذا سمعتم المؤذن فقولوا مثلما يقول))")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSound(azezsound);

        NotificationManagerCompat notificationcompatazen = NotificationManagerCompat.from(context);
        notificationcompatazen.notify(25, build.build());



    }
}
