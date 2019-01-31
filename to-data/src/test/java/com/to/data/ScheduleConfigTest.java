package com.to.data;

import com.to.data.model.data.memory.InMemoryScheduleConfiguration;
import com.to.data.model.time.IntervalSlot;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScheduleConfigTest {

    private InMemoryScheduleConfiguration schemaConfig;

    @Before
    public void setUp() throws Exception {
        schemaConfig = new InMemoryScheduleConfiguration();
    }

    @Test
    public void baseTest() {
        // period influences schedule and constraints
        schemaConfig.setPeriod(Period.ofWeeks(11));
        schemaConfig.setTelephoneSchema("DAILY[2-7(nanacht);7-10;8-11;11-14;12-15;14-17;17-20;19-22;20-23;22-01;23-02(voornacht)]");
        schemaConfig.setChatSchema("WEEKLY[18-21(TUx2);19-22(MO,TU);20-23(MOx2,SA)],MONTHLY[15-18(+1SUx3,+3SUx3)]");
        // get empty schedule, ready to be filled with volunteers
        List<IntervalSlot> intervalSlots = schemaConfig.getEmptySchedule();

        LocalDate from = LocalDate.of(2018, Month.JUNE, 25);
        LocalDate to = LocalDate.of(2018, Month.OCTOBER, 7);
        // test each day is filled between from/to date exactly once
        IntStream.iterate(0, i -> i + 1)
                .limit(ChronoUnit.DAYS.between(from, to))
                .mapToObj(i -> from.plusDays(i))
                .collect(Collectors.toList())
                .forEach( day -> {
                    intervalSlots.stream().filter( (slot) -> day.equals(slot.getDay()) );
                });

        // test each day is filled with all hour slots exactly once

//        intervalSlots.stream().filter((interval)->interval.getTimeInterval().)
    }
}
