package org.petstore.automation.testdata.config;

import com.google.inject.AbstractModule;
import org.petstore.automation.testdata.OrderTestData;
import org.petstore.automation.testdata.prod.OrderTestDataProd;

public class ProdTestDataModulePetStore extends AbstractModule {

    @Override
    protected void configure() {
        bind(OrderTestData.class).to(OrderTestDataProd.class);
    }

}
