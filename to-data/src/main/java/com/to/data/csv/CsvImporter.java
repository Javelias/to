package com.to.data.csv;

import com.to.data.model.data.memory.DefaultConfiguration;
import com.to.data.model.data.IConfiguration;
import com.to.data.model.volunteer.Volunteer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;

public class CsvImporter {

    public static void main(String[] args) {
        CsvImporter.importSchedule("beurtrol_25062018_07102018.csv");
    }

    public static IConfiguration importSchedule(String fileName) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CsvImporter.class.getClassLoader().getResourceAsStream(fileName)))) {

            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                    .withHeader("Datum", "Uur", "Tel/Onl", "Nummer", "Naam")
                    .withIgnoreHeaderCase()
                    .withTrim());

            DefaultConfiguration schedule = new DefaultConfiguration(
                    LocalDate.of(2018, Month.JUNE, 25),
                    LocalDate.of(2018, Month.OCTOBER, 7));

            csvParser.getRecords().stream().forEach(csvRecord -> {
                String recordLine = csvRecord.get(0);
                if (recordLine.startsWith("Datum")) {
                    // header line
                } else if (recordLine.startsWith(";")) {
                    schedule.getTimeSlot("02-07").setVolunteer(new Volunteer(46, "Mark", "Valdez"));
                } else {
                    // date

                }
            });

            return schedule;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
