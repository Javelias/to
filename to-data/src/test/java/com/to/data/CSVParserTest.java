package com.to.data;

import org.junit.Test;

public class CSVParserTest {

    @Test
    public void importVolunteers() {
        CSVTOParser csvtoParser = new CSVTOParser();
        csvtoParser.parse("beurtrol_25062018_07102018.csv");
    }
}
