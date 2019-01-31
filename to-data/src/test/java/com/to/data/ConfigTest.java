package com.to.data;

import com.to.data.model.data.memory.InMemoryScheduleConfiguration;
import com.to.data.model.service.IScheduleConfiguration;
import org.junit.Before;
import org.junit.Test;

public class ConfigTest {

    private IScheduleConfiguration config;

    @Before
    public void setUp() throws Exception {
        this.config = new InMemoryScheduleConfiguration();
    }

    @Test
    public void telephoneSchema1() {
        config.setTelephoneSchema("DAILY[2-7(nanacht);7-10;8-11;11-14;12-15;14-17;17-20;19-22;20-23;22-01;23-02(voornacht)]");
        
    }
}
