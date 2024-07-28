package com.saga.courier.application.messaging.api;

import com.saga.courier.application.messaging.api.enums.ShipmentState;

public record ShipmentRequest(
        Integer id,
        String orderId,
        Integer merchantInventoryId,
        Integer itemId,
        String packageId,
        ShipmentState status
) {
}
