package com.saga.courier.application.controller.api;

import com.saga.courier.application.messaging.api.enums.ShipmentState;

public record PackageResponse(
        Integer shipmentId,
        ShipmentState status
) {
}
