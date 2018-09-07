package com.to.data.model;

import java.time.DayOfWeek;
import java.time.Period;

// TODO recurrence via rfc5545 ?
public class DayRecurrence {

    private DayOfWeek dayOfWeek;
    private Period recurrence;

    public DayRecurrence(DayOfWeek dayOfWeek) {
        this(dayOfWeek, Period.ofWeeks(1)); // default is weekly recurrence
    }

    public DayRecurrence(DayOfWeek dayOfWeek, Period recurrence) {
        this.dayOfWeek = dayOfWeek;
        this.recurrence = recurrence;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Period getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(Period recurrence) {
        this.recurrence = recurrence;
    }

    @Override
    public String toString() {
        return "DayRecurrence{" +
                "dayOfWeek=" + dayOfWeek +
                ", recurrence=" + recurrence +
                '}';
    }
}
