package com.saga.courier.application.messaging;

import com.saga.courier.application.messaging.api.enums.ShipmentState;

public record UpdateShipmentStatus(
        String packageId,
        ShipmentState status
) {
}
