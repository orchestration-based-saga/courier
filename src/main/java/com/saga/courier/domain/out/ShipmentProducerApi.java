package com.saga.courier.domain.out;

import com.saga.courier.domain.model.ItemServicingRequest;
import com.saga.courier.domain.model.Package;

public interface ShipmentProducerApi {

    void updateShipment(Package pack, ItemServicingRequest request);
}
