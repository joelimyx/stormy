package com.example.joe.stormy.Weather;

import com.example.joe.stormy.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static com.squareup.okhttp.internal.http.HttpDate.format;

/**
 * Created by Joe on 9/10/2015.
 */
public class Current {
    private String mIcon;
    private String mSummary;
    private String mTimeZone;
    private long mTime;
    private double mPrecipChance, mTemperature;
    private double mHumidity;

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String timeZone) {
        mTimeZone = timeZone;
    }

    public Current(double humidity, String icon, String summary, long time, double precipChance, double temperature, String timeZone) {
        mHumidity = humidity;
        mIcon = icon;
        mSummary = summary;
        mTime = time;
        mPrecipChance = precipChance;
        mTemperature = temperature;
        mTimeZone = timeZone;
    }

    public int getPrecipChance() {
        return (int) Math.round(mPrecipChance*100);
    }

    public void setPrecipChance(double precipChance) {
        mPrecipChance = precipChance;
    }

    public String getIcon() {
        return mIcon;
    }

    public int getIconId(){
        return Forecast.getIconId(mIcon);
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public long getTime() {
        return mTime;
    }

    public String getFormattedTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone(mTimeZone));
        Date dateTime = new Date(mTime * 1000);
        String timeString = formatter.format(dateTime);
        return timeString;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public int getTemperature() {
        return (int) Math.round(mTemperature);
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        mHumidity = humidity;
    }
}
