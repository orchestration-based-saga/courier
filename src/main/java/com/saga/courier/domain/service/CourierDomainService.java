package com.saga.courier.domain.service;

import com.saga.courier.domain.in.CourierDomainServiceApi;
import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.model.enums.Courier;
import com.saga.courier.domain.model.enums.ShipmentDomainStatus;
import com.saga.courier.domain.out.CourierRepositoryApi;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CourierDomainService implements CourierDomainServiceApi {

    private final CourierRepositoryApi courierRepositoryApi;

    @Override
    public void assignCourierToShipment(Package shipment) {
        if (!shipment.status().equals(ShipmentDomainStatus.CREATED)){
            return;
        }
        Package aPackage = courierRepositoryApi.createPackage(shipment);
        // assign courier (bulky)
        Courier courier;
        if (aPackage.product().bulky()) {
            courier = assignOneManDeliveryCourier();
        } else {
            courier = assignTwoManDeliveryCourier();
        }
        courierRepositoryApi.assignCourier(aPackage, courier);

    }

    @Override
    public List<Package> getPackagesForCourier(Integer courierId) {
        return courierRepositoryApi.findPackagesOfCourier(courierId);
    }

    private Courier assignOneManDeliveryCourier() {
        return Courier.ONE_MAN_DELIVERY;
    }

    private Courier assignTwoManDeliveryCourier() {
        return Courier.TWO_MEN_DELIVERY;
    }
}
