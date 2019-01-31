package com.to.data.model.data.memory;

import com.google.common.collect.Lists;
import com.to.data.model.volunteer.Volunteer;

import java.util.ArrayList;
import java.util.List;

public class TOAInMemoryVolunteerDao {

    private final List<Volunteer> volunteers = new ArrayList<>();

    public void addVolunteer(Volunteer volunteer) {
        if (volunteers.stream().noneMatch( v -> v.getNumber() == volunteer.getNumber())) {
            volunteers.add(volunteer);
        }
    }

    public List<Volunteer> getVolunteers() {
        return Lists.newArrayList(volunteers);
    }
}
