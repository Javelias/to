package com.to.data.preference;

import com.to.data.model.data.memory.TOAScheduleConfiguration;
import com.to.data.model.preference.VolunteerPreference;
import com.to.data.model.time.TimeInterval;
import com.to.data.model.volunteer.Volunteer;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class TelephonePreferenceTest {

    @Test
    public void name() {

        TOAScheduleConfiguration schedule = new TOAScheduleConfiguration(
                LocalDate.of(2018, Month.JUNE, 25),
                LocalDate.of(2018, Month.OCTOBER, 7));

        Volunteer andy = new Volunteer(1, "Andy", "Warhol");

        VolunteerPreference preference = new VolunteerPreference();
        preference.setDayOfWeek(DayOfWeek.MONDAY);
        preference.setTimeInterval(new TimeInterval(2,7));
        preference.setPreferenceType(VolunteerPreference.Type.POSSIBLE);

    }
}
