package com.saga.courier.domain.in;

import com.saga.courier.domain.model.Package;

import java.util.List;

public interface CourierDomainServiceApi {

    void assignCourierToShipment(Package shipment);

    List<Package> getPackagesForCourier(Integer courierId);
}
