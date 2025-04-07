package org.petstore.automation.testdata.stage;

import org.petstore.automation.dto.OrderRequestResponse;
import org.petstore.automation.exceptions.NotImplementedException;
import org.petstore.automation.testdata.OrderTestData;

public class OrderTestDataStage implements OrderTestData {

    @Override
    public OrderRequestResponse getCompletedValidOrder() {
        throw new NotImplementedException("Test data is not implemented");
    }

    @Override
    public OrderRequestResponse getIncompleteValidOrder() {
        throw new NotImplementedException("Test data is not implemented");
    }

    @Override
    public OrderRequestResponse getInvalidOrderWithNoPetId() {
        throw new NotImplementedException("Test data is not implemented");
    }

    @Override
    public OrderRequestResponse getInvalidOrderWithNoId() {
        throw new NotImplementedException("Test data is not implemented");
    }
}
