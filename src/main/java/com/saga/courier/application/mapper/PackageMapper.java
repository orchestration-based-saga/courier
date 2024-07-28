package com.saga.courier.application.mapper;

import com.saga.courier.application.messaging.api.ShipmentRequest;
import com.saga.courier.domain.model.Package;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PackageMapper {

    @Mapping(target = "shipmentId", source = "id")
    Package fromMessage(ShipmentRequest shipmentRequest);
}
