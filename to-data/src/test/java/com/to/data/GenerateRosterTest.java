package com.to.data;

import com.to.data.model.data.IConfiguration;
import com.to.data.model.data.memory.InMemoryData;
import com.to.data.model.preference.VolunteerGeneralPreference;
import com.to.data.model.schedule.Schedule;
import com.to.data.model.service.IData;
import com.to.data.model.service.ILogic;
import com.to.data.server.LogicBean;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class GenerateRosterTest {

    @Test
    public void generateRoster() {
        IData data = new InMemoryData();
        // apply standard config
        IConfiguration configuration = data.getConfiguration("Default");
        // create schedule
        Schedule schedule = new Schedule(
                configuration,
                LocalDate.of(2018, Month.JUNE, 25),
                LocalDate.of(2018, Month.OCTOBER, 7));
        // fetch all preferences for the volunteers
        List<VolunteerGeneralPreference> preferences = data.getVolunteerPreferences(schedule);
        // generate timeslots based on preferences
        ILogic logic = new LogicBean();
        logic.generate(preferences);
    }
}
