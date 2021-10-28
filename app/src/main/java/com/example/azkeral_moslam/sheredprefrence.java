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
private String sunrise;
private int  pickerhour;
private int  pickermin;
private int prikermode;
public  SharedPreferences.Editor edit;
public   SharedPreferences sp;
    public sheredprefrence(Context context) {
        this.context = context;
         sp = PreferenceManager.getDefaultSharedPreferences(context);
         edit = sp.edit();

    }

    public String getSunrise() {
        sunrise=sp.getString("sunrise","05:00");
        return sunrise;

    }



    public int getPrikermode() {
        prikermode=sp.getInt("Timepickermode",-1);
        return prikermode;
    }

    public void setPrikermode(int prikermode) {
        edit.putInt("Timepickermode",prikermode);
        this.prikermode = prikermode;
    }

    public int getPickerhour() {
        pickerhour=sp.getInt("Timepickerhour",12);
        return pickerhour;
    }


    public void setPickerhour(int  pickerhour) {
        edit.putInt("Timepickerhour",pickerhour);
        this.pickerhour = pickerhour;
    }

    public int getPickermin() {
        pickermin = sp.getInt("Timepickermin",30);
        return pickermin;
    }

    public void setPickermin(int  pickermin) {
        edit.putInt("Timepickermin",pickermin);
        this.pickermin = pickermin;
    }

    public String getFager() {
        fager = sp.getString("fajer",fager);
        return fager;
    }

    public void setFager(String fager,String sunrise,String dhur,String asr , String mghred,String ishaa) {
        this.fager = fager;
        this.dhur= dhur;
        this.asr=asr;
        this.mghred = mghred;
        this.ishaa = ishaa;
        this.sunrise = sunrise;
        edit.putString("fajer",fager);
        edit.putString("dhur",dhur);
        edit.putString("asrr",asr);
        edit.putString("maghred",mghred);
        edit.putString("isha",ishaa);
        edit.putString("sunrise",sunrise);
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
