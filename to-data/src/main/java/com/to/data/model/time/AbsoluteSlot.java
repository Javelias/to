package com.to.data.model.time;

import com.to.data.model.SlotType;
import com.to.data.model.volunteer.Volunteer;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AbsoluteSlot {

    private Volunteer volunteer;
    private LocalDateTime from;
    private LocalDateTime to;
    private SlotType slotType;

    public AbsoluteSlot(Volunteer volunteer, LocalDateTime from, LocalDateTime to, SlotType slotType) {
        this.volunteer = volunteer;
        this.from = from;
        this.to = to;
        this.slotType = slotType;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public SlotType getSlotType() {
        return slotType;
    }
}
