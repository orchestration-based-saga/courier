package com.saga.courier.application.api.event;

import java.util.UUID;

public record ShipmentProcessMessage (
        Long id,
        String processId,
        String businessKey,
        Long parentProcessId,
        UUID workflow,
        Integer shipmentId
){
}
