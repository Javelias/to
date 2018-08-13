package com.to.data.model;

import java.time.LocalTime;

public class TimeInterval {

    private final LocalTime start;
    private final LocalTime end;
    private String name;


    public TimeInterval(int startHour, int endHour) {
        this(startHour, 0, endHour, 0);
    }

    public TimeInterval(int startHour, int endHour, String name) {
        this(startHour, 0, endHour, 0, name);
    }

    public TimeInterval(int startHour, int startMinute, int endHour, int endMinute) {
        this(startHour, startMinute, endHour, endMinute,null);
    }

    public TimeInterval(int startHour, int startMinute, int endHour, int endMinute, String name) {
        this.start = LocalTime.of(startHour, startMinute);
        this.end = LocalTime.of(endHour, endMinute);
        this.name = name;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
