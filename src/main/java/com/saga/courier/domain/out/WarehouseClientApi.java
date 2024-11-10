package com.saga.courier.domain.out;

import com.saga.courier.domain.model.Package;

public interface WarehouseClientApi {

    boolean notifyOfIncomingDelivery(Package shipment);

    void deliverPackage(Package shipment);

}
