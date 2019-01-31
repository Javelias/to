package com.to.data.model.time;


import com.to.data.model.SlotType;

import java.time.LocalDate;

public class IntervalSlot {

    // day (mo, tu, etc)


    // time slot (8-10)
    private TimeInterval timeInterval;

    // see RFC5545 https://tools.ietf.org/html/rfc5545#section-3.8.5
    private String recurrence;

    private SlotType slotType;

    public IntervalSlot(TimeInterval timeInterval, SlotType slotType) {
        this(timeInterval, slotType, null);
    }

    public IntervalSlot(TimeInterval timeInterval, SlotType slotType, String recurrence) {
        this.timeInterval = timeInterval;
        this.slotType = slotType;
        this.recurrence = recurrence;
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    @Override
    public String toString() {
        return "IntervalSlot{" +
                "timeInterval=" + timeInterval +
                ", slotType=" + slotType +
                ", recurrence=" + recurrence +
                '}';
    }

    public LocalDate getDay() {
    }
}
