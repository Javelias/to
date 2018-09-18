package com.to.data;

import com.to.data.model.data.IScheduleConfiguration;
import com.to.data.model.data.memory.InMemoryData;
import com.to.data.model.preference.GeneralCriteria;
import com.to.data.model.preference.VolunteerPreference;
import com.to.data.model.schedule.ISchedule;
import com.to.data.model.schedule.Schedule;
import com.to.data.model.service.IData;
import com.to.data.model.time.IntervalSlot;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class GenerateRosterTest {

    @Test
    public void generateRoster() {
        // core api's
        IData data = new InMemoryData();
        // apply standard config
        IScheduleConfiguration configuration = data.getConfiguration("TOA");
        // create schedule
        ISchedule schedule = new Schedule(
                configuration,
                LocalDate.of(2018, Month.JUNE, 25),
                LocalDate.of(2018, Month.OCTOBER, 7));
        // fetch all preferences for the volunteers
        List<VolunteerPreference> preferences = data.getVolunteerPreferences(schedule);
        // fetch general criteria that apply
        GeneralCriteria criteria = configuration.getGeneralCriteria();
        // generate timeslots based on preferences
        List<IntervalSlot> slots = schedule.generatePlan(preferences, criteria);
    }
}
