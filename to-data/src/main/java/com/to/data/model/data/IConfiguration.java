package com.to.data.model.data;

import com.to.data.model.TimeInterval;
import com.to.data.model.TimeSlot;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

public interface IConfiguration {
    Map<DayOfWeek,List<TimeInterval>> getDayOfWeekIntervals();
}
