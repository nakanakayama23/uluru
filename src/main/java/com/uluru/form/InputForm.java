package com.uluru.form;

import java.util.List;

import javax.ws.rs.QueryParam;

/**
 * 入力情報フォーム
 * @author imazato
 *
 */
public class InputForm {
	
    @QueryParam("year")
    private String year;

    @QueryParam("month")
    private String month;

    @QueryParam("day")
    private String day;

    @QueryParam("hour")
    private String hour;

    @QueryParam("minute")
    private String minute;

    @QueryParam("stationList")
    private List<String> stationList;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public List<String> getStationList() {
        return stationList;
    }

    public void setStationList(List<String> stationList) {
        this.stationList = stationList;
    }

}
