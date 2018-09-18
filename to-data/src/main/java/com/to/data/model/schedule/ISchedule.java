package com.to.data.model.schedule;

import com.to.data.model.preference.GeneralCriteria;
import com.to.data.model.preference.VolunteerPreference;
import com.to.data.model.time.IntervalSlot;

import java.util.List;

public interface ISchedule {
    List<IntervalSlot> generatePlan(List<VolunteerPreference> preferences, GeneralCriteria criteria);
}
