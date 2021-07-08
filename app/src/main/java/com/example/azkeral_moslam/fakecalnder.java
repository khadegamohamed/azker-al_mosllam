package com.example.azkeral_moslam;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class fakecalnder extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"khadegamoghad ",Toast.LENGTH_LONG).show();
        Toast.makeText(context," HELLO API TIMER",Toast.LENGTH_LONG).show();
        Log.d("khadega", "onReceive: sucessfuly");
    }
}
