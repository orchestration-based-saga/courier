package com.saga.courier.domain.service;

import com.saga.courier.domain.in.CourierDomainServiceApi;
import com.saga.courier.domain.model.ItemServicingRequest;
import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.model.enums.Courier;
import com.saga.courier.domain.model.enums.ShipmentDomainStatus;
import com.saga.courier.domain.out.CourierRepositoryApi;
import com.saga.courier.domain.out.ShipmentProducerApi;
import com.saga.courier.domain.out.WarehouseClientApi;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CourierDomainService implements CourierDomainServiceApi {

    private final CourierRepositoryApi courierRepositoryApi;
    private final ShipmentProducerApi shipmentProducerApi;
    private final WarehouseClientApi warehouseClient;

    @Override
    public void upsert(Package shipment, ItemServicingRequest request) {
        Optional<Package> maybePackage = courierRepositoryApi.findByShipmentId(shipment.shipmentId());
        if (maybePackage.isEmpty()) {
            shipment = assignCourierToShipment(shipment);
            shipmentProducerApi.updateShipment(shipment, request);
        } else {
            Package aPackage = maybePackage.get();
            // reassign courier
            shipment = assignCourierToShipment(aPackage);
            aPackage = aPackage.updateStatus(shipment.status());
            aPackage = courierRepositoryApi.upsertPackage(aPackage);
            warehouseClient.deliverPackage(aPackage);
            shipmentProducerApi.updateShipment(aPackage, request);
        }
    }

    @Override
    public List<Package> getPackagesForCourier(Integer courierId) {
        return courierRepositoryApi.findPackagesOfCourier(courierId);
    }

    @Override
    public boolean updateStatus(String packageId, ShipmentDomainStatus status) {
        Optional<Package> maybePackage = courierRepositoryApi.findPackageById(packageId);
        if (maybePackage.isEmpty()) {
            return false;
        }
        Package aPackage = maybePackage.get();
        aPackage = aPackage.updateStatus(status);
        courierRepositoryApi.upsertPackage(aPackage);
        return true;
    }

    private Package assignCourierToShipment(Package shipment) {
        Package aPackage = courierRepositoryApi.upsertPackage(shipment);
        Courier courier;
        if (Boolean.TRUE.equals(aPackage.product().bulky())) {
            courier = assignOneManDeliveryCourier();
        } else {
            courier = assignTwoManDeliveryCourier();
        }
        courierRepositoryApi.assignCourier(aPackage, courier);
        return aPackage;
    }

    @Override
    public void notifyWarehouse(Integer shipmentId, ItemServicingRequest request) {
        Optional<Package> maybePackage = courierRepositoryApi.findByShipmentId(shipmentId);
        if (maybePackage.isPresent() && warehouseClient.notifyOfIncomingDelivery(maybePackage.get())){
            // send success response
            shipmentProducerApi.warehouseNotified(true, request);
        }
        else {
            // send unsuccessful response
            shipmentProducerApi.warehouseNotified(false, request);
        }
    }

    private Courier assignOneManDeliveryCourier() {
        return Courier.ONE_MAN_DELIVERY;
    }

    private Courier assignTwoManDeliveryCourier() {
        return Courier.TWO_MEN_DELIVERY;
    }
}
