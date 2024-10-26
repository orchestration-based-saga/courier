package com.saga.courier.application.api.event;

public record NotifyWarehouseProcessResponse(
        String processId,
        String businessKey,
        boolean success
) {
}
