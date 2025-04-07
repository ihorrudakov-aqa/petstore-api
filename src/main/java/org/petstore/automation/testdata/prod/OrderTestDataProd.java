package org.petstore.automation.testdata.prod;

import org.petstore.automation.dto.OrderRequestResponse;
import org.petstore.automation.exceptions.NotImplementedException;
import org.petstore.automation.testdata.OrderTestData;

public class OrderTestDataProd implements OrderTestData {

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
