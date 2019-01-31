package com.to.data.model.service;

import com.to.data.model.preference.IPreference;
import com.to.data.model.time.IntervalSlot;
import com.to.data.model.volunteer.Volunteer;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ISchedule {

    public IScheduleConfiguration getConfiguration();

    public LocalDate getStartDate();

    public LocalDate getEndDate();

    List<IntervalSlot> generatePlan();
}
