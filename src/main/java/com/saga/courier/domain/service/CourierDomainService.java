package com.saga.courier.domain.service;

import com.saga.courier.domain.in.CourierDomainServiceApi;
import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.out.CourierRepositoryApi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CourierDomainService implements CourierDomainServiceApi {

    private final CourierRepositoryApi courierRepositoryApi;

    @Override
    public void assignCourierToShipment(Package shipment) {
        //create shipment
        Package aPackage = courierRepositoryApi.createPackage(shipment);
        // assign courier (bulky)

    }
}
