package com.saga.courier.application.api.enums;

public record UpdateShipmentStatus(
        String packageId,
        ShipmentState status
) {
}
