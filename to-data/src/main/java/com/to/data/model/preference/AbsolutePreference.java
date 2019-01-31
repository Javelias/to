package com.to.data.model.preference;

import com.to.data.model.time.TimeInterval;

import java.time.LocalDate;

public class AbsolutePreference implements IPreference {

    private LocalDate date;
    private TimeInterval timeInterval;
    private PreferenceType preferenceType;

    public AbsolutePreference(LocalDate date, TimeInterval timeInterval, PreferenceType preferenceType) {
        this.date = date;
        this.timeInterval = timeInterval;
        this.preferenceType = preferenceType;
    }

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

    @Override
    public PreferenceType getPreferenceType() {
        return preferenceType;
    }
}
