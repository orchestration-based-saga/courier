package com.saga.courier.application.messaging.api.enums;

public record UpdateShipmentStatus(
        String packageId,
        ShipmentState status
) {
}
