package com.to.data.preference;

import com.to.data.model.data.memory.DefaultConfiguration;
import com.to.data.model.volunteer.Volunteer;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class TelephonePreferenceTest {

    @Test
    public void name() {

        DefaultConfiguration schedule = new DefaultConfiguration(
                LocalDate.of(2018, Month.JUNE, 25),
                LocalDate.of(2018, Month.OCTOBER, 7));

        Volunteer andy = new Volunteer(1, "Andy", "Warhol");

        andy.getTelephonePreferences(schedule);
    }
}
