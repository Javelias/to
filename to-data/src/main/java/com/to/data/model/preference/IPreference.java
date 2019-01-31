package com.to.data.model.preference;

import com.to.data.model.time.TimeInterval;

public interface IPreference {
    TimeInterval getTimeInterval();
    PreferenceType getPreferenceType();
}
