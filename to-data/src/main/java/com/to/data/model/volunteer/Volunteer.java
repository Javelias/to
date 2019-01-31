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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTelephonePreference(TelephonePreferences telephonePreferences) {

    }
}
