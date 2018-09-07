package com.to.data.model.schedule;

import com.to.data.model.data.IConfiguration;

import java.time.LocalDate;

public class Schedule {

    private final IConfiguration configuration;
    private final LocalDate startDate;
    private final LocalDate endDate;


    public Schedule(IConfiguration configuration, LocalDate startDate, LocalDate endDate) {
        this.configuration = configuration;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public IConfiguration getConfiguration() {
        return configuration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
