package com.saga.courier.domain.in;

import com.saga.courier.domain.model.Package;

public interface CourierDomainServiceApi {

    void assignCourierToShipment(Package shipment);
}
