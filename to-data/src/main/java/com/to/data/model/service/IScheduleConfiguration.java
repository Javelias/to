package com.to.data.model.service;

import com.to.data.model.Constraint;
import com.to.data.model.preference.ICriteria;
import com.to.data.model.time.IntervalSlot;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public interface IScheduleConfiguration {

    String getName();

    List<IntervalSlot> getEmptySchedule();

    ICriteria getGeneralCriteria();

    void setTelephoneSchema(String s);

    void setChatSchema(String s);

    void setPeriod(Period period);

    void addVolunteerConstraint(Constraint<Integer> integerConstraint);

    void addSchemaConstraint(Constraint<Integer> integerConstraint);
}
