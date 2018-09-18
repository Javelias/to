package com.to.data.model.time;

import com.to.data.model.volunteer.Volunteer;

import java.time.LocalDateTime;

public class VolunteerSlot {

    private LocalDateTime dateTime;
    private Volunteer volunteer;

    public VolunteerSlot(LocalDateTime dateTime, Volunteer volunteer) {
        this.dateTime = dateTime;
        this.volunteer = volunteer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }
}
