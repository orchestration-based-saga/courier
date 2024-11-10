package com.saga.courier.infra.common.gateway.dto;

import java.util.List;

public record PackageIdsRequest(
        List<String> packageIds
) {
}

