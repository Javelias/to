package com.to.data.model.preference;

import com.to.data.model.TimeInterval;
import com.to.data.model.volunteer.Volunteer;

import java.time.DayOfWeek;

public class VolunteerGeneralPreference {

    enum PreferenceType {
        PREFERRED, POSSIBLE
    }

    private DayOfWeek dayOfWeek;
    private TimeInterval timeInterval;
    private PreferenceType preferenceType;
    private Volunteer volunteer;

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

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }
}
