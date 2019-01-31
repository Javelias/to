package com.to.data.model.service;

import com.to.data.model.preference.IPreference;
import com.to.data.model.preference.PreferenceType;
import com.to.data.model.volunteer.Volunteer;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

public interface IData {

    IScheduleConfiguration getConfiguration(String name);

    List<Volunteer> getVolunteers();

    Map<Volunteer, List<IPreference>> getVolunteerPreferences(ISchedule schedule);

    void addVolunteerPreference(String volunteerName, DayOfWeek friday, int startHour, int endHour, PreferenceType preferred);

    void generateVolunteers(int i);

    void store(String toa, IScheduleConfiguration config);
}
