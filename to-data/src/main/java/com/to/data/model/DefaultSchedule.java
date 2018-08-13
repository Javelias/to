package com.to.data.model;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Current schedule received from TO
 */
public class DefaultSchedule implements ISchedule {

    private final LocalDate from;
    private final LocalDate till;

    private List<TimeSlot> schedule = new ArrayList<>();

    private static final List<TimeInterval> TIME_INTERVALS = new ArrayList<>();

    static {
        TIME_INTERVALS.add(new TimeInterval(2,7,"Nanacht"));
        TIME_INTERVALS.add(new TimeInterval(7, 10));
        TIME_INTERVALS.add(new TimeInterval(8, 11));
        TIME_INTERVALS.add(new TimeInterval(11,14));
        TIME_INTERVALS.add(new TimeInterval(12,15));
        TIME_INTERVALS.add(new TimeInterval(14, 17));
        TIME_INTERVALS.add(new TimeInterval(15,30,18,30));
        TIME_INTERVALS.add(new TimeInterval(17, 20));
        TIME_INTERVALS.add(new TimeInterval(19, 22));
        TIME_INTERVALS.add(new TimeInterval(20, 23));
        TIME_INTERVALS.add(new TimeInterval(22, 1));
        TIME_INTERVALS.add(new TimeInterval(23, 2, "Voornacht"));
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
    public DefaultSchedule(LocalDate from, LocalDate till) {

        this.from = from;
        this.till = till;

        // call slot = always on entry, absolute time, no recurrence
        TIME_INTERVALS.stream().forEach(timeInterval -> {
            schedule.add(new TimeSlot(timeInterval, SlotType.CALL));
        });

        // online slot = always on day basis, recurrence pattern
        Period weekly = Period.ofWeeks(1);
        addOnlineSlot(19,22, DayOfWeek.MONDAY, weekly);
        addOnlineSlot(20,23, DayOfWeek.MONDAY, weekly);
        addOnlineSlot(20,23, DayOfWeek.MONDAY, weekly);
        addOnlineSlot(19,22, DayOfWeek.TUESDAY, weekly);
        addOnlineSlot(19,22, DayOfWeek.SATURDAY, weekly);
        addOnlineSlot(20,23, DayOfWeek.SATURDAY, weekly);

        // TODO 15-18 chat op zondag (2x, niet elke week)
    }

    private void addOnlineSlot(int startHour, int endHour, DayOfWeek dayOfWeek, Period recurrence) {
        schedule.add(new TimeSlot(getInterval(startHour, endHour), SlotType.ONLINE, new DayRecurrence(dayOfWeek, recurrence)));
    }

    public List<TimeSlot> getTimeSlots() {
        return schedule;
    }

    public static TimeInterval getInterval(int start, int end) {
        return TIME_INTERVALS.stream()
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
