package org.petstore.automation.testdata.dev;

import org.petstore.automation.dto.OrderRequestResponse;
import org.petstore.automation.testdata.OrderTestData;

import java.util.Random;

import static org.petstore.automation.helpers.DateTimeHelper.getCurrentTimeFormatted;

public class OrderTestDataDev implements OrderTestData {

    @Override
    public OrderRequestResponse getCompletedValidOrder() {
        return OrderRequestResponse.builder()
                .id(new Random().nextInt(1, 100))
                .petId(new Random().nextInt(1, 10))
                .quantity(new Random().nextInt(1, 10))
                .shipDate(getCurrentTimeFormatted())
                .status("approved")
                .complete(true)
                .build();
    }

    @Override
    public OrderRequestResponse getIncompleteValidOrder() {
        return OrderRequestResponse.builder()
                .id(new Random().nextInt(1, 100))
                .petId(new Random().nextInt(1, 10))
                .quantity(new Random().nextInt(1, 10))
                .shipDate(getCurrentTimeFormatted())
                .status("approved")
                .complete(false)
                .build();
    }

    @Override
    public OrderRequestResponse getInvalidOrderWithNoPetId() {
        return OrderRequestResponse.builder()
                .id(new Random().nextInt(1, 100))
                .quantity(new Random().nextInt(1, 10))
                .shipDate(getCurrentTimeFormatted())
                .status("approved")
                .complete(false)
                .build();
    }

    @Override
    public OrderRequestResponse getInvalidOrderWithNoId() {
        return OrderRequestResponse.builder()
                .petId(new Random().nextInt(10))
                .quantity(new Random().nextInt(10))
                .shipDate(getCurrentTimeFormatted())
                .status("approved")
                .complete(false)
                .build();
    }
}
