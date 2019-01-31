package com.to.data.model.schedule;

import com.to.data.model.preference.GeneralPreference;
import com.to.data.model.preference.ICriteria;
import com.to.data.model.preference.IPreference;
import com.to.data.model.service.IData;
import com.to.data.model.service.ISchedule;
import com.to.data.model.service.IScheduleConfiguration;
import com.to.data.model.time.IntervalSlot;
import com.to.data.model.volunteer.Volunteer;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Schedule implements ISchedule {

    private final IScheduleConfiguration configuration;
    private final LocalDate startDate;
    private final LocalDate endDate;


    public Schedule(IData data) {
        this.configuration = configuration;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public IScheduleConfiguration getConfiguration() {
        return configuration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public List<IntervalSlot> generatePlan(Map<Volunteer, List<IPreference>> preferences) {
        // fetch general criteria that apply
        ICriteria criteria = configuration.getGeneralCriteria();

        return null;
    }
}
