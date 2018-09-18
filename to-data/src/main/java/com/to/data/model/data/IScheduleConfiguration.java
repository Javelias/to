package com.to.data.model.data;

import com.to.data.model.preference.GeneralCriteria;
import com.to.data.model.time.IntervalSlot;

import java.util.List;

public interface IScheduleConfiguration {

    String getName();

    List<IntervalSlot> getIntervalSlots();

    GeneralCriteria getGeneralCriteria();
}
