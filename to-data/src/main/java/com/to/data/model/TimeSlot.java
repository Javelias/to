package com.to.data.model;


public class TimeSlot {

    private TimeInterval interval;
    private SlotType slotType;
    private DayRecurrence recurrence;

    public TimeSlot(TimeInterval interval, SlotType slotType) {
        this(interval, slotType, null);
    }

    public TimeSlot(TimeInterval interval, SlotType slotType, DayRecurrence recurrence) {
        this.interval = interval;
        this.slotType = slotType;
        this.recurrence = recurrence;
    }

    public TimeInterval getInterval() {
        return interval;
    }

    public void setInterval(TimeInterval interval) {
        this.interval = interval;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public DayRecurrence getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(DayRecurrence recurrence) {
        this.recurrence = recurrence;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "interval=" + interval +
                ", slotType=" + slotType +
                ", recurrence=" + recurrence +
                '}';
    }
}
