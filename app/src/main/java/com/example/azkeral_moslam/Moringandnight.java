package com.example.azkeral_moslam;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class Moringandnight extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notification= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        String title= intent.getStringExtra("title");
        Intent intennn = new Intent(context,homeactivity.class);
        intennn.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pending = PendingIntent.getBroadcast(context,100,intennn,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder build = new NotificationCompat.Builder(context)
                .setContentIntent(pending)
                .setSmallIcon(R.drawable.ic_baseline_bedtime_24)
                .setContentTitle(title)
                .setContentText("قَالَ رَسُولُ اللَّه ﷺ: إِنَّ اللَّه تَعَالَى قَالَ: منْ عادى لي وَلِيّاً. فقدْ آذنتهُ بالْحرْب. وَمَا تقرَّبَ إِلَيَ عبْدِي بِشْيءٍ أَحبَّ إِلَيَ مِمَّا افْتَرَضْت عليْهِ: وَمَا يَزالُ عَبْدِي يتقرَّبُ إِلى بالنَّوافِل حَتَّى أُحِبَّه، فَإِذا أَحبَبْتُه كُنْتُ سمعهُ الَّذي يسْمعُ بِهِ، وبَصره الَّذِي يُبصِرُ بِهِ، ويدَهُ الَّتي يَبْطِش بِهَا، ورِجلَهُ الَّتِي يمْشِي بِهَا، وَإِنْ سأَلنِي أَعْطيْتَه، ولَئِنِ اسْتَعَاذَنِي لأُعِيذَّنه)) رواه البخاري.")
                .setAutoCancel(true);

        notification.notify(100,build.build());

    }
}
