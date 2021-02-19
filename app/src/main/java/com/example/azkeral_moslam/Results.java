package com.example.azkeral_moslam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Results {

    @SerializedName("datetime")
    @Expose
    private List<Datetime> datetime = null;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("settings")
    @Expose
    private Settings settings;

    public List<Datetime> getDatetime() {
        return datetime;
    }

    public void setDatetime(List<Datetime> datetime) {
        this.datetime = datetime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

}
