package org.petstore.automation.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.petstore.automation.exceptions.TestConfigurationException;
import org.petstore.automation.testdata.config.DevTestDataModulePetStore;
import org.petstore.automation.testdata.config.ProdTestDataModulePetStore;
import org.petstore.automation.testdata.TestDataPetStore;
import org.petstore.automation.testdata.config.StageTestDataModulePetStore;

import static org.petstore.automation.utils.Environment.*;

@Slf4j
@SuppressWarnings("WeakerAccess")
public class ConfigLoaderPetStore {

    public static TestDataPetStore loadTestData(String environment) {
        log.info("Load test data from '{}' test data source", environment);

        Injector injector = getTestDataInjector(environment);
        TestDataPetStore testData = injector.getInstance(TestDataPetStore.class);

        return testData;
    }

    public static Injector getTestDataInjector(String environment) {
        Injector injector = switch (environment) {
            case PROD, STAGE -> throw new NotImplementedException();
            case DEV -> Guice.createInjector(new DevTestDataModulePetStore());
            default ->
                    throw new TestConfigurationException(String.format("There is no test data source for: '%s'", environment));
        };
        return injector;
    }
}
