package com.saga.courier.application.messaging.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.saga.courier.application.messaging.api.enums.ShipmentState;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ShipmentRequest(
        Integer id,
        String orderId,
        Integer merchantInventoryId,
        Integer itemId,
        String packageId,
        ShipmentState status
) {
}
