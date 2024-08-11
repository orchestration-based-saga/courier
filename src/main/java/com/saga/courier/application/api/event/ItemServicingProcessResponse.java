package com.saga.courier.application.api.event;

public record ItemServicingProcessResponse(
        String processId,
        String businessKey,
        ShipmentMessage shipment
) {
}
