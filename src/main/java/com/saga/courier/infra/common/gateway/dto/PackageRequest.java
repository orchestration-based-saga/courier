package com.saga.courier.infra.common.gateway.dto;

public record PackageRequest(
        String packageId,
        String courier,
        Integer merchantInventoryId
) {
}
