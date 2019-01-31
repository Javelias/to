package com.to.data.model.data.memory;

import com.to.data.model.preference.AbsolutePreference;
import com.to.data.model.preference.IPreference;
import com.to.data.model.preference.PreferenceType;
import com.to.data.model.service.IScheduleConfiguration;
import com.to.data.model.preference.GeneralPreference;
import com.to.data.model.service.ISchedule;
import com.to.data.model.service.IData;
import com.to.data.model.time.TimeInterval;
import com.to.data.model.volunteer.Volunteer;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryData implements IData {

    private Map<Volunteer, List<IPreference>> preferences = new HashMap<>();

    @Override
    public IScheduleConfiguration getConfiguration(String name) {
        if ("TOA".equals(name)) {
            return new InMemoryScheduleConfiguration();
        }
        throw new IllegalArgumentException("Name not recognised");
    }

    @Override
    public List<Volunteer> getVolunteers() {
        List<Volunteer> volunteers = new ArrayList<>();
        volunteers.add(new Volunteer(1, "Mark", "Valdez"));
        volunteers.add(new Volunteer(2, "Sydnee", "Mcmillan"));
        volunteers.add(new Volunteer(3, "Alyson", "Bates"));
        volunteers.add(new Volunteer(4, "Beckham", "Peck"));
        volunteers.add(new Volunteer(5, "Megan", "Morgan"));
        volunteers.add(new Volunteer(6, "Rhett", "Fisher"));
        volunteers.add(new Volunteer(7, "Regina", "Rhodes"));
        volunteers.add(new Volunteer(8, "Clark", "Hobbs"));
        volunteers.add(new Volunteer(9, "Brennen", "Dyer"));
        volunteers.add(new Volunteer(10, "Keenan", "Hancock"));
        volunteers.add(new Volunteer(11, "Zackery", "Barnes"));
        volunteers.add(new Volunteer(12, "Beau", "Mcdonald"));
        volunteers.add(new Volunteer(13, "Lizeth", "Flowers"));
        volunteers.add(new Volunteer(14, "Kaiya", "Simmons"));
        volunteers.add(new Volunteer(15, "Dania", "Jones"));
        return volunteers;
    }

    @Override
    public void addVolunteerPreference(String volunteerName, DayOfWeek dayOfWeek, int startHour, int endHour, PreferenceType preferenceType) {
        getPreferences(volunteerName).add(new GeneralPreference(dayOfWeek, new TimeInterval(startHour,endHour), preferenceType));
    }

    private List<IPreference> getPreferences(String volunteerName) {
        Volunteer volunteer = findVolunteer(volunteerName);
        if (!preferences.containsKey(volunteer)) {
            preferences.put(volunteer, new ArrayList<>());
        }
        return preferences.get(volunteer);
    }

    @Override
    public Map<Volunteer, List<IPreference>> getVolunteerPreferences(ISchedule schedule) {
        Map<Volunteer, List<IPreference>> preferences = new HashMap<>();
        // weekdiensten
        Volunteer mark = findVolunteer("Mark, Valdez");
        List<IPreference> markPrefs = new ArrayList<>();
        markPrefs.add(new GeneralPreference(DayOfWeek.FRIDAY, new TimeInterval(14,17), PreferenceType.POSSIBLE));
        markPrefs.add(new GeneralPreference(DayOfWeek.SATURDAY, new TimeInterval(20,23), PreferenceType.PREFERRED));
        markPrefs.add(new AbsolutePreference(LocalDate.of(2018,8,15),new TimeInterval(8,11),PreferenceType.PREFERRED));
        preferences.put(mark, markPrefs);
        // weekenddiensten

        return preferences;
    }

    private Volunteer findVolunteer(String fullName) {
        return getVolunteers().stream().filter((v)-> fullName.equals(v.getFirstName()+", "+v.getLastName())).findFirst().get();
    }
}
