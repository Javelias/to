package com.to.data;

import com.to.data.model.Constraint;
import com.to.data.model.data.memory.InMemoryScheduleConfiguration;
import com.to.data.model.preference.PreferenceType;
import com.to.data.model.service.IScheduleConfiguration;
import com.to.data.model.data.memory.InMemoryData;
import com.to.data.model.service.ISchedule;
import com.to.data.model.schedule.Schedule;
import com.to.data.model.service.IData;
import com.to.data.model.time.IntervalSlot;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.Period;
import java.util.List;

public class GenerateRosterTest {

    private IData data;
    private IScheduleConfiguration config;
    private ISchedule schedule;

    // schema = config w/o dates
    // schedule = config w/ dates and volunteers

    @Before
    public void setUp() {
        this.data = new InMemoryData();
        this.config = new InMemoryScheduleConfiguration();
        this.data.store("Test", config);
        config.setPeriod(Period.ofWeeks(11));
        config.setTelephoneSchema("DAILY[2-7(nanacht);7-10;8-11;11-14;12-15;14-17;17-20;19-22;20-23;22-01;23-02(voornacht)]");
        config.setChatSchema("WEEKLY[18-21(TUx2);19-22(MO,TU);20-23(MOx2,SA)],MONTHLY[15-18(+1SUx3,+3SUx3)]");
        // TODO add constraints
        //config.addVolunteerConstraint(new Constraint<>("#voornachten/dienst", 1, 1.0D));
        //config.addSchemaConstraint(new Constraint<>("#open diensten", 0, (nrOfOpenShifts) -> 1.0D - nrOfOpenShifts));

        this.data.generateVolunteers(100);
        // TODO generate random schedules for each volunteer
        this.schedule = new Schedule(this.data);
        this.schedule.generatePlan();
    }

    @Test
    public void generateRoster() {

    }
}
