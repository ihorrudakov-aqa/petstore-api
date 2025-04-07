package org.petstore.automation;

import lombok.extern.slf4j.Slf4j;
import org.petstore.automation.config.ConfigHolderPetStore;
import org.petstore.automation.holders.PetStoreClientHolder;
import org.petstore.automation.testdata.TestDataPetStore;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
@Slf4j
public class BaseTest {

    protected TestDataPetStore td;
    protected PetStoreClientHolder service;

    @BeforeSuite
    public void beforeSuite() {
    }

    @BeforeClass(alwaysRun = true)
    public void init() {
        log.debug("Initializing test steps and test data...");

        td = ConfigHolderPetStore.getInstance().getTestData();
        service = ConfigHolderPetStore.getInstance().getService();

        log.debug("Test steps and test data have been successfully initialized");
    }

    @BeforeMethod
    public void beforeMethod() {
    }
}
