package com.saga.courier.domain.out;

import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.model.enums.Courier;

import java.util.List;

public interface CourierRepositoryApi {

    Package createPackage(Package shipment);

    void assignCourier(Package shipment, Courier courier);

    List<Package> findPackagesOfCourier(Integer courierId);
}
