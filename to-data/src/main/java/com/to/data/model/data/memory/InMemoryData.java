package com.to.data.model.data.memory;

import com.to.data.model.data.IConfiguration;
import com.to.data.model.service.IData;

public class InMemoryData implements IData {

    @Override
    public IConfiguration getConfiguration(String name) {
        return new DefaultConfiguration();
    }
}
