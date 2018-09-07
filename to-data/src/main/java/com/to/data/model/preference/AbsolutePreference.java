package com.to.data.model.preference;

import com.to.data.model.TimeInterval;

import java.time.LocalDate;

public class AbsolutePreference {

    private LocalDate date;
    private TimeInterval timeInterval;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }
}
