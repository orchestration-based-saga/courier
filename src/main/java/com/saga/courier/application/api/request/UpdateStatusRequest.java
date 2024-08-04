package com.saga.courier.application.api.request;

import com.saga.courier.application.api.enums.ShipmentState;

public record UpdateStatusRequest(
        String packageId,
        ShipmentState updatedStatus
) {
}
