package com.saga.courier.domain.in;

import com.saga.courier.domain.model.ItemServicingRequest;
import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.model.enums.ShipmentDomainStatus;

import java.util.List;

public interface CourierDomainServiceApi {

    void upsert(Package shipment, ItemServicingRequest request);

    List<Package> getPackagesForCourier(Integer courierId);

    boolean updateStatus(String packageId, ShipmentDomainStatus status);
}
