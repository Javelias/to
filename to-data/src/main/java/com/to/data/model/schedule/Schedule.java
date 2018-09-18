package com.to.data.model.schedule;

import com.to.data.model.data.IScheduleConfiguration;

import java.time.LocalDate;

public class Schedule implements ISchedule {

    private final IScheduleConfiguration configuration;
    private final LocalDate startDate;
    private final LocalDate endDate;


    public Schedule(IScheduleConfiguration configuration, LocalDate startDate, LocalDate endDate) {
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
}
