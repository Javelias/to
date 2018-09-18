package com.to.data.model.data.memory;

import com.google.api.client.util.StringUtils;
import com.to.data.model.data.IScheduleConfiguration;
import com.to.data.model.preference.GeneralCriteria;
import com.to.data.model.preference.VolunteerPreference;
import com.to.data.model.schedule.Schedule;
import com.to.data.model.service.IData;

import java.util.List;

public class InMemoryData implements IData {

    @Override
    public IScheduleConfiguration getConfiguration(String name) {
        if ("TOA".equals(name)) {
            return new TOAScheduleConfiguration();
        }
        throw new IllegalArgumentException("Name not recognised");
    }


}
