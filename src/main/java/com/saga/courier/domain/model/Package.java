package com.saga.courier.domain.model;

import com.saga.courier.domain.model.enums.Courier;
import com.saga.courier.domain.model.enums.ShipmentDomainStatus;
import lombok.Builder;

@Builder
public record Package(
        String orderId,
        Product product,
        Integer itemId,
        String packageId,
        Integer shipmentId,
        ShipmentDomainStatus status,
        Courier courier
) {

    public Package assignCourier(Courier courier) {
        return new Package(orderId, product, itemId, packageId, shipmentId, status, courier);
    }

    public Package updateStatus(ShipmentDomainStatus status) {
        return  new Package(orderId, product, itemId, packageId, shipmentId, status, courier);
    }

}
