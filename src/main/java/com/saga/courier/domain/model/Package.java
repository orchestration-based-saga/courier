package com.saga.courier.domain.model;

import com.saga.courier.domain.model.enums.ShipmentDomainStatus;
import lombok.Builder;

@Builder
public record Package(
        String orderId,
        Integer merchantInventoryId,
        Integer itemId,
        String packageId,
        Integer shipmentId,
        ShipmentDomainStatus status
) {

}
