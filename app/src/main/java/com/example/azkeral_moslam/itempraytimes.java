package com.example.azkeral_moslam;

import android.graphics.Color;

public class itempraytimes {
    String prayname;
    String praytime;
    int prayimage;
    int  praycolor;

    public itempraytimes(String prayname,String praytime,int prayimage) {
        this.prayname = prayname;
        this.praytime = praytime;
        this.prayimage = prayimage;

    }

    public String getPrayname() {
        return prayname;
    }

    public void setPrayname(String prayname) {
        this.prayname = prayname;
    }

    public String getPraytime() {
        return praytime;
    }

    public void setPraytime(String praytime) {
        this.praytime = praytime;
    }

    public int getPrayimage() {
        return prayimage;
    }

    public void setPrayimage(int prayimage) {
        this.prayimage = prayimage;
    }

    public int getPraycolor() {
        return praycolor;
    }

    public void setPraycolor(int praycolor) {
        this.praycolor = praycolor;
    }
}
