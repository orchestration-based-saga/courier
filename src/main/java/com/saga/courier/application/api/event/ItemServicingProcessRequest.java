package com.saga.courier.application.api.event;

import java.util.UUID;

public record ItemServicingProcessRequest(
        Long id,
        String processId,
        String businessKey,
        Long parentProcessId,
        UUID workflow,
        ShipmentMessage claim
)
{

}

