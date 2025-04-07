package org.petstore.automation.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.petstore.automation.holders.PetStoreClientHolder;
import org.petstore.automation.testdata.TestDataPetStore;

@Slf4j
public class ConfigHolderPetStore {
    private static ConfigHolderPetStore instance;

    @Getter
    private TestDataPetStore testData;

    @Getter
    private PetStoreClientHolder service;

    public static ConfigHolderPetStore getInstance() {
        if (instance == null) {
            log.info("Initializing ConfigHolder instance");
            ConfigHolderPetStore configHolderPetStore = new ConfigHolderPetStore();
            configHolderPetStore.testData = ConfigLoaderPetStore.loadTestData(TestConfig.environment);
            configHolderPetStore.service = new PetStoreClientHolder();

            instance = configHolderPetStore;
            log.info("Initialization of the instance is completed");
        }
        return instance;
    }
}
