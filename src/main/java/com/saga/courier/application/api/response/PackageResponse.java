package com.saga.courier.application.api.response;

import com.saga.courier.application.api.enums.ShipmentState;

public record PackageResponse(
        Integer shipmentId,
        ShipmentState status,
        String packageId
) {
}
