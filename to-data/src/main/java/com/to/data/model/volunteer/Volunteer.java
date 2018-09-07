package com.to.data.model.volunteer;

import com.to.data.model.preference.TelephonePreferences;

public class Volunteer {

    private int number;
    private String firstName;
    private String lastName;

    public Volunteer(int number, String firstName, String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public void setTelephonePreference(TelephonePreferences telephonePreferences) {

    }
}
