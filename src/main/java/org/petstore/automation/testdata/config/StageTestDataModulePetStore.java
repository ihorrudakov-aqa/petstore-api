package org.petstore.automation.testdata.config;

import com.google.inject.AbstractModule;
import org.petstore.automation.testdata.OrderTestData;
import org.petstore.automation.testdata.stage.OrderTestDataStage;

public class StageTestDataModulePetStore extends AbstractModule {

    @Override
    protected void configure() {
        bind(OrderTestData.class).to(OrderTestDataStage.class);
    }
}
