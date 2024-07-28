package com.saga.courier.application.controller.api.request;

import com.saga.courier.application.messaging.api.enums.ShipmentState;

public record UpdateStatusRequest(
        String packageId,
        ShipmentState updatedStatus
) {
}
