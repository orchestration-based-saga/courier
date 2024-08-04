package com.saga.courier.application.api.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saga.courier.application.api.enums.ShipmentState;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShipmentMessage(
        Integer id,
        String orderId,
        Integer merchantInventoryId,
        Integer itemId,
        String packageId,
        ShipmentState status
) {
}
