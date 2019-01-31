package com.to.data;

import com.to.data.model.data.memory.InMemoryScheduleConfiguration;
import com.to.data.model.data.memory.TOAInMemoryVolunteerDao;
import com.to.data.model.volunteer.Volunteer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class CSVTOParser {

    public void parse(String scheduleFilename) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CSVTOParser.class.getClassLoader().getResourceAsStream(scheduleFilename)))) {

            CSVParser csvParser = new CSVParser(reader, CSVFormat.EXCEL.withDelimiter(';')
                    .withFirstRecordAsHeader()
                    .withIgnoreHeaderCase()
                    .withTrim());

            InMemoryScheduleConfiguration schedule = new InMemoryScheduleConfiguration();
            TOAInMemoryVolunteerDao volunteerDao = new TOAInMemoryVolunteerDao();

            for (final CSVRecord record : csvParser) {
                final String number = record.get("Nummer");
                final String name = record.get("Naam");
                if (!"".equals(number) && !"".equals(name)) {
                    String[] split = name.split(" ");
                    String firstName = split[0];
                    String lastName = split[1];
                    volunteerDao.addVolunteer(new Volunteer(Integer.parseInt(number),firstName,lastName));
                }
            }

            volunteerDao.getVolunteers().stream().sorted(Comparator.comparing(Volunteer::getNumber))
                    .forEach(v -> System.out.println(v.getNumber()+":"+v.getFirstName()+","+v.getLastName()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
