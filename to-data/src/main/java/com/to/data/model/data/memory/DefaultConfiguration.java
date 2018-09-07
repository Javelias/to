package com.to.data.model.data.memory;

import com.to.data.model.DayRecurrence;
import com.to.data.model.SlotType;
import com.to.data.model.TimeInterval;
import com.to.data.model.TimeSlot;
import com.to.data.model.data.IConfiguration;

import java.time.*;
import java.util.*;

/**
 * Current schedule received from TO
 */
public class DefaultConfiguration implements IConfiguration {

    private final Long id;
    private final String name;

    private List<TimeSlot> schedule = new ArrayList<>();
    List<TimeInterval> timeIntervals = new ArrayList<>();

    public DefaultConfiguration() {
        this.id = 1L;
        this.name = "Default";
    }

    /*
        Call
        ----
        Each time interval single entry

        Online
        ------
        19-22  chat op monday
        20-23  chat op monday (2x)
        19-22  chat at tuesday
        19-22  chat op saterday
        20-23  chat op saterday
        15-18 chat op sunday (2x, niet elke week)
    */
    public Map<DayOfWeek,List<TimeInterval>> getDayOfWeekIntervals() {
        Map<DayOfWeek,List<TimeInterval>> dayOfWeekIntervals = new HashMap<>();
        // 11 shifts of each 3 hours, one night-shift of 5 hours
        timeIntervals.add(new TimeInterval(2,7,"Nanacht"));
        timeIntervals.add(new TimeInterval(7, 10));
        timeIntervals.add(new TimeInterval(8, 11));
        timeIntervals.add(new TimeInterval(11,14));
        timeIntervals.add(new TimeInterval(12,15));
        timeIntervals.add(new TimeInterval(14, 17));
        timeIntervals.add(new TimeInterval(15,30,18,30));
        timeIntervals.add(new TimeInterval(17, 20));
        timeIntervals.add(new TimeInterval(19, 22));
        timeIntervals.add(new TimeInterval(20, 23));
        timeIntervals.add(new TimeInterval(22, 1));
        timeIntervals.add(new TimeInterval(23, 2, "Voornacht"));
        // template reused for all days in the week
        dayOfWeekIntervals.put(DayOfWeek.MONDAY, new ArrayList<>(timeIntervals));
        dayOfWeekIntervals.put(DayOfWeek.TUESDAY, new ArrayList<>(timeIntervals));
        dayOfWeekIntervals.put(DayOfWeek.WEDNESDAY, new ArrayList<>(timeIntervals));
        dayOfWeekIntervals.put(DayOfWeek.THURSDAY, new ArrayList<>(timeIntervals));
        dayOfWeekIntervals.put(DayOfWeek.FRIDAY, new ArrayList<>(timeIntervals));
        dayOfWeekIntervals.put(DayOfWeek.SATURDAY, new ArrayList<>(timeIntervals));
        dayOfWeekIntervals.put(DayOfWeek.SUNDAY, new ArrayList<>(timeIntervals));
        // call slot = always on entry, absolute time, no recurrence
        timeIntervals.stream().forEach(timeInterval -> {
            schedule.add(new TimeSlot(timeInterval, SlotType.CALL));
        });
        // online slot = always on day basis, recurrence pattern
        Period weekly = Period.ofWeeks(1);
        schedule.add(new TimeSlot(getInterval(19, 22), SlotType.ONLINE, new DayRecurrence(DayOfWeek.MONDAY, weekly)));
        schedule.add(new TimeSlot(getInterval(20, 23), SlotType.ONLINE, new DayRecurrence(DayOfWeek.MONDAY, weekly)));
        schedule.add(new TimeSlot(getInterval(20, 23), SlotType.ONLINE, new DayRecurrence(DayOfWeek.MONDAY, weekly)));
        schedule.add(new TimeSlot(getInterval(19, 22), SlotType.ONLINE, new DayRecurrence(DayOfWeek.TUESDAY, weekly)));
        schedule.add(new TimeSlot(getInterval(19, 22), SlotType.ONLINE, new DayRecurrence(DayOfWeek.SATURDAY, weekly)));
        schedule.add(new TimeSlot(getInterval(20, 23), SlotType.ONLINE, new DayRecurrence(DayOfWeek.SATURDAY, weekly)));
        // TODO 15-18 chat op zondag (2x, niet elke week)
        return dayOfWeekIntervals;
    }

    public List<TimeSlot> getTimeSlots() {
        return schedule;
    }

    public TimeInterval getInterval(int start, int end) {
        return timeIntervals.stream()
                .filter( timeInterval -> timeInterval.getStart().getHour() == start && timeInterval.getEnd().getHour() == end)
                .findFirst()
                .get();
    }

    public TimeSlot getTimeSlot(String hourString) {
        int dashIndex = hourString.indexOf("-");
        if (dashIndex != -1) {
            int start = Integer.valueOf(hourString.substring(0, dashIndex));
            int end = Integer.valueOf(hourString.substring(dashIndex+1, hourString.length()));
            return getTimeSlots().stream().filter(timeSlot -> timeSlot.getInterval().getStart().getHour() == start
                    && timeSlot.getInterval().getEnd().getHour() == end).findFirst().orElse(null);
        }
        return null;
    }
}
