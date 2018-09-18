package com.to.data.model.service;

import com.to.data.model.preference.GeneralCriteria;
import com.to.data.model.preference.VolunteerPreference;

import java.util.List;

public interface ILogic {
    void generatePlan(List<VolunteerPreference> preferences, GeneralCriteria criteria);
}
