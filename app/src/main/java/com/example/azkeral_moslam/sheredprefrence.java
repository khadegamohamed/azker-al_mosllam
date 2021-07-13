package com.example.azkeral_moslam;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class sheredprefrence {

    Context context;
private  String fager;
private String dhur;
private String asr;
private String mghred;
private String ishaa;
public  SharedPreferences.Editor edit;
public   SharedPreferences sp;
    public sheredprefrence(Context context) {
        this.context = context;
         sp = PreferenceManager.getDefaultSharedPreferences(context);
         edit = sp.edit();

    }

    public String getFager() {
        fager = sp.getString("fajer",fager);
        return fager;
    }

    public void setFager(String fager,String dhur,String asr , String mghred,String ishaa) {
        this.fager = fager;
        this.dhur= dhur;
        this.asr=asr;
        this.mghred = mghred;
        this.ishaa = ishaa;
        edit.putString("fajer",fager);
        edit.putString("dhur",dhur);
        edit.putString("asrr",asr);
        edit.putString("maghred",mghred);
        edit.putString("isha",ishaa);
        edit.commit();

    }

    public String getDhur() {
        dhur=sp.getString("dhur",dhur);
        return dhur;
    }

    public String getAsr() {
        asr =sp.getString("asrr",asr);
        return asr;
    }

    public String getMghred() {
        mghred=sp.getString("maghred",mghred);
        return mghred;
    }

    public String getIshaa() {
        ishaa = sp.getString("isha",ishaa);
        return ishaa;
    }
}
