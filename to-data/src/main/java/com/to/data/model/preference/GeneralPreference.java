package com.to.data.model.preference;

import com.to.data.model.time.TimeInterval;
import com.to.data.model.volunteer.Volunteer;

import java.time.DayOfWeek;

public class GeneralPreference implements IPreference {

    private DayOfWeek dayOfWeek;
    private TimeInterval timeInterval;
    private PreferenceType preferenceType;

    public GeneralPreference(DayOfWeek dayOfWeek, TimeInterval timeInterval, PreferenceType preferenceType) {
        this.dayOfWeek = dayOfWeek;
        this.timeInterval = timeInterval;
        this.preferenceType = preferenceType;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    public PreferenceType getPreferenceType() {
        return preferenceType;
    }

    public void setPreferenceType(PreferenceType preferenceType) {
        this.preferenceType = preferenceType;
    }
}
