package com.example.midterm_android;

public class Exercise {
    private String name;
    private String day;
    private String time;
    private int imageResourceID;

    public Exercise() {
    }

    public Exercise(String name, String day, String time, int imageResourceID) {
        this.name = name;
        this.day = day;
        this.time = time;
        this.imageResourceID = imageResourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }
}

