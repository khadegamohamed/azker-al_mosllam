package com.example.azkeral_moslam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.example.azkeral_moslam.NotificationChannel;
import android.net.Uri;

import static com.example.azkeral_moslam.NotificationChannel.channel_1;

public class sleepnotification extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
Intent i = new Intent(context,sleep.class);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
PendingIntent pend = PendingIntent.getActivity(context,0,i,0);
        NotificationCompat.Builder build = new NotificationCompat.Builder(context,channel_1)
                .setSmallIcon(R.drawable.ic_baseline_bedtime_24)
                .setContentTitle("أذكار قبل النوم")
                .setContentText("قَالَ رَسُولُ اللَّه ﷺ: إِنَّ اللَّه تَعَالَى قَالَ: منْ عادى لي وَلِيّاً. فقدْ آذنتهُ بالْحرْب. وَمَا تقرَّبَ إِلَيَ عبْدِي بِشْيءٍ أَحبَّ إِلَيَ مِمَّا افْتَرَضْت عليْهِ: وَمَا يَزالُ عَبْدِي يتقرَّبُ إِلى بالنَّوافِل حَتَّى أُحِبَّه، فَإِذا أَحبَبْتُه كُنْتُ سمعهُ الَّذي يسْمعُ بِهِ، وبَصره الَّذِي يُبصِرُ بِهِ، ويدَهُ الَّتي يَبْطِش بِهَا، ورِجلَهُ الَّتِي يمْشِي بِهَا، وَإِنْ سأَلنِي أَعْطيْتَه، ولَئِنِ اسْتَعَاذَنِي لأُعِيذَّنه)) رواه البخاري.")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pend);

        NotificationManagerCompat notificationcompat = NotificationManagerCompat.from(context);
        notificationcompat.notify(22, build.build());






    }
}
