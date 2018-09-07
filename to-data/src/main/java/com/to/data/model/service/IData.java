package com.to.data.model.service;

import com.to.data.model.data.IConfiguration;
import com.to.data.model.preference.VolunteerGeneralPreference;
import com.to.data.model.schedule.Schedule;
import com.to.data.model.volunteer.Volunteer;

import java.util.List;

public interface IData {

    IConfiguration getConfiguration(String name);

    List<VolunteerGeneralPreference> getVolunteerPreferences(Schedule schedule);
}
