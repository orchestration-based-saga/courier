package com.saga.courier.domain.out;

import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.model.enums.Courier;

import java.util.List;
import java.util.Optional;

public interface CourierRepositoryApi {

    Package upsertPackage(Package shipment);

    void assignCourier(Package shipment, Courier courier);

    List<Package> findPackagesOfCourier(Integer courierId);

    Optional<Package> findPackageById(String packageId);

    Optional<Package> findByShipmentId(Integer shipmentId);
}
