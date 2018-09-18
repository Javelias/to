package com.to.data.model.service;

import com.to.data.model.data.IScheduleConfiguration;
import com.to.data.model.preference.GeneralCriteria;
import com.to.data.model.preference.VolunteerPreference;
import com.to.data.model.schedule.ISchedule;
import com.to.data.model.schedule.Schedule;

import java.util.List;

public interface IData {

    IScheduleConfiguration getConfiguration(String name);

    List<VolunteerPreference> getVolunteerPreferences(ISchedule schedule);
}
