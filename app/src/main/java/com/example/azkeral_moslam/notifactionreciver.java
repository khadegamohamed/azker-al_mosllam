package com.example.azkeral_moslam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;

import androidx.core.app.NotificationCompat;

public class notifactionreciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
NotificationManager notificationmang= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
       Uri azezsound =Uri.parse("android.resource" + context.getApplicationContext().getOpPackageName()+"/" + R.raw.azan);
String title= intent.getStringExtra("pray name");
        Intent intentt = new Intent(context,homeactivity.class);
        intentt.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pending = PendingIntent.getBroadcast(context,100,intentt,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder build = new NotificationCompat.Builder(context)
                .setContentIntent(pending)
                .setSmallIcon(R.drawable.ic_baseline_bedtime_24)
                .setContentTitle(title)
                .setContentText("قال الرسول صلي الله عليه وسلم(( إذا سمعتم المؤذن فقولوا مثلما يقول))")
                .setAutoCancel(true)
                .setSound(azezsound);
       notificationmang.notify(100,build.build());

    }
}
