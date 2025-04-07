package org.petstore.automation.testdata.config;

import com.google.inject.AbstractModule;
import org.petstore.automation.testdata.OrderTestData;
import org.petstore.automation.testdata.dev.OrderTestDataDev;

public class DevTestDataModulePetStore extends AbstractModule {

    @Override
    protected void configure() {
        bind(OrderTestData.class).to(OrderTestDataDev.class);
    }
}
