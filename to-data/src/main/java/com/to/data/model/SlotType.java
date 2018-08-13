package com.to.data.model;

public enum SlotType {

    CALL("Tel", "Telephone"), ONLINE("Onl", "Online");

    private String code;
    private String name;

    SlotType(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
