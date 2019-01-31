package com.to.data.model.data.memory;

import com.to.data.model.Constraint;
import com.to.data.model.SlotType;
import com.to.data.model.preference.ICriteria;
import com.to.data.model.service.IScheduleConfiguration;
import com.to.data.model.time.IntervalSlot;
import com.to.data.model.time.TimeInterval;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Current intervalSlots received from TOA
 */
public class InMemoryScheduleConfiguration implements IScheduleConfiguration {

    private final String name;

    private List<IntervalSlot> intervalSlots = new ArrayList<>();
    private List<TimeInterval> timeIntervals = new ArrayList<>();

    public InMemoryScheduleConfiguration() {
        this.name = "TOA";
    }

    @Override
    public void setTelephoneSchema(String s) {

    }

    @Override
    public void setPeriod(Period period) {

    }

    @Override
    public void addVolunteerConstraint(Constraint<Integer> integerConstraint) {

    }

    @Override
    public void addSchemaConstraint(Constraint<Integer> integerConstraint) {

    }

    @Override
    public void setChatSchema(String s) {

    }

    /*
            Call
            ----
            Each time getTimeInterval single entry

            Online
            ------
            19-22  chat op monday
            20-23  chat op monday (2x)
            19-22  chat at tuesday
            19-22  chat op saterday
            20-23  chat op saterday
            15-18 chat op zondag (2x, 1e en 3e zondag van de maand)
        */
    public List<IntervalSlot> getEmptySchedule() {
        if (this.intervalSlots == null) {
            // call slot = daily, 11 shifts of each 3 hours, one night-shift of 5 hours
            intervalSlots.add(new IntervalSlot(new TimeInterval(2,7,"Nanacht"), SlotType.CALL, "RRULE:FREQ=DAILY"));
            intervalSlots.add(new IntervalSlot(new TimeInterval(7, 10), SlotType.CALL, "RRULE:FREQ=DAILY"));
            intervalSlots.add(new IntervalSlot(new TimeInterval(8, 11), SlotType.CALL, "RRULE:FREQ=DAILY"));
            intervalSlots.add(new IntervalSlot(new TimeInterval(11,14), SlotType.CALL, "RRULE:FREQ=DAILY"));
            intervalSlots.add(new IntervalSlot(new TimeInterval(12,15), SlotType.CALL, "RRULE:FREQ=DAILY"));
            intervalSlots.add(new IntervalSlot(new TimeInterval(14, 17), SlotType.CALL, "RRULE:FREQ=DAILY"));
            intervalSlots.add(new IntervalSlot(new TimeInterval(15,30,18,30), SlotType.CALL, "RRULE:FREQ=DAILY"));
            intervalSlots.add(new IntervalSlot(new TimeInterval(17, 20), SlotType.CALL, "RRULE:FREQ=DAILY"));
            intervalSlots.add(new IntervalSlot(new TimeInterval(19, 22), SlotType.CALL, "RRULE:FREQ=DAILY"));
            intervalSlots.add(new IntervalSlot(new TimeInterval(20, 23), SlotType.CALL, "RRULE:FREQ=DAILY"));
            intervalSlots.add(new IntervalSlot(new TimeInterval(22, 1), SlotType.CALL, "RRULE:FREQ=DAILY"));
            intervalSlots.add(new IntervalSlot(new TimeInterval(23, 2, "Voornacht"), SlotType.CALL, "RRULE:FREQ=DAILY"));
            // chat slot = always on day basis w/ recurrence pattern,
            intervalSlots.add(new IntervalSlot(getInterval(19, 22), SlotType.ONLINE, "RRULE:FREQ=WEEKLY;BYDAY=MO"));
            intervalSlots.add(new IntervalSlot(getInterval(20, 23), SlotType.ONLINE, "RRULE:FREQ=WEEKLY;BYDAY=MO"));
            intervalSlots.add(new IntervalSlot(getInterval(20, 23), SlotType.ONLINE, "RRULE:FREQ=WEEKLY;BYDAY=MO"));
            intervalSlots.add(new IntervalSlot(getInterval(18, 21), SlotType.ONLINE, "RRULE:FREQ=WEEKLY;BYDAY=TU"));
            intervalSlots.add(new IntervalSlot(getInterval(18, 21), SlotType.ONLINE, "RRULE:FREQ=WEEKLY;BYDAY=TU"));
            intervalSlots.add(new IntervalSlot(getInterval(19, 22), SlotType.ONLINE, "RRULE:FREQ=WEEKLY;BYDAY=TU"));
            intervalSlots.add(new IntervalSlot(getInterval(19, 22), SlotType.ONLINE, "RRULE:FREQ=WEEKLY;BYDAY=SA"));
            intervalSlots.add(new IntervalSlot(getInterval(20, 23), SlotType.ONLINE, "RRULE:FREQ=WEEKLY;BYDAY=SA"));
            intervalSlots.add(new IntervalSlot(getInterval(15, 18), SlotType.ONLINE, "RRULE:FREQ=MONTHLY;BYDAY=+1SU"));
            intervalSlots.add(new IntervalSlot(getInterval(15, 18), SlotType.ONLINE, "RRULE:FREQ=MONTHLY;BYDAY=+1SU"));
            intervalSlots.add(new IntervalSlot(getInterval(15, 18), SlotType.ONLINE, "RRULE:FREQ=MONTHLY;BYDAY=+1SU"));
            intervalSlots.add(new IntervalSlot(getInterval(15, 18), SlotType.ONLINE, "RRULE:FREQ=MONTHLY;BYDAY=+3SU"));
            intervalSlots.add(new IntervalSlot(getInterval(15, 18), SlotType.ONLINE, "RRULE:FREQ=MONTHLY;BYDAY=+3SU"));
            intervalSlots.add(new IntervalSlot(getInterval(15, 18), SlotType.ONLINE, "RRULE:FREQ=MONTHLY;BYDAY=+3SU"));
        }
        return intervalSlots;
    }

    public void test() {
        System.out.println("TELEPHONE=DAILY[2-7(nanacht);7-10;8-11;11-14;12-15;14-17;17-20;19-22;20-23;22-01;23-02(voornacht)]"); // telephone
        System.out.println("CHAT=WEEKLY[18-21(TUx2);19-22(MO,TU);20-23(MOx2,SA)],MONTHLY[15-18(+1SUx3,+3SUx3)]");
    }

    @Override
    public ICriteria getGeneralCriteria() {
        return new ICriteria(){

            public int getMinimumPreferenceCountInWeek() {
                return 4;
            }


            public int getMinimumDayCountInWeek() {
                return 2;
            }
        };
    }

    @Override
    public String getName() {
        return this.name;
    }

    TimeInterval getInterval(int start, int end) {
        return timeIntervals.stream()
                .filter( timeInterval -> timeInterval.getStart().getHour() == start && timeInterval.getEnd().getHour() == end)
                .findFirst()
                .get();
    }

    public IntervalSlot getTimeSlot(String hourString) {
        int dashIndex = hourString.indexOf("-");
        if (dashIndex != -1) {
            int start = Integer.valueOf(hourString.substring(0, dashIndex));
            int end = Integer.valueOf(hourString.substring(dashIndex+1));
            return getEmptySchedule().stream().filter(intervalSlot -> intervalSlot.getTimeInterval().getStart().getHour() == start
                    && intervalSlot.getTimeInterval().getEnd().getHour() == end).findFirst().orElse(null);
        }
        return null;
    }
}
