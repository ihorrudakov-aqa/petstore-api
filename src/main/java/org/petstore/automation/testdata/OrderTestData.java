package org.petstore.automation.testdata;

import org.petstore.automation.dto.OrderRequestResponse;

public interface OrderTestData {

    OrderRequestResponse getCompletedValidOrder();

    OrderRequestResponse getIncompleteValidOrder();

    OrderRequestResponse getInvalidOrderWithNoPetId();

    OrderRequestResponse getInvalidOrderWithNoId();
}
