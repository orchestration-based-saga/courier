package com.saga.courier.domain.out;

import com.saga.courier.domain.model.Package;

public interface CourierRepositoryApi {

    Package createPackage(Package shipment);
}
