package org.petstore.automation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestResponse {
    Integer id;
    Integer petId;
    Integer quantity;
    String shipDate;
    String status;
    Boolean complete;
}
