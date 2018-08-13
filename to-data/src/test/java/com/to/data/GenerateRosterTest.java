package com.to.data;

import com.to.data.csv.CsvImporter;
import com.to.data.model.DefaultSchedule;
import com.to.data.model.ISchedule;
import com.to.data.model.Volunteer;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class GenerateRosterTest {

    @Test
    public void generateRoster() {
        ISchedule schedule = CsvImporter.importSchedule("beurtrol_25062018_07102018.csv");
        schedule.getTimeSlots().stream().forEach(timeSlot -> {
            System.out.println(timeSlot);
        });

    }
}
