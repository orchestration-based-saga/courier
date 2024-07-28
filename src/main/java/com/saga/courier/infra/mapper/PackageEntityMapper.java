package com.saga.courier.infra.mapper;

import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.model.enums.ShipmentDomainStatus;
import com.saga.courier.infra.model.PackageEntity;
import com.saga.courier.infra.model.enums.ShipmentStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PackageEntityMapper {

    ShipmentStatus toEntity(ShipmentDomainStatus status);

    @Mapping(target = "courier", ignore = true)
    @Mapping(target = "shipmentStatus", source = "status")
    PackageEntity toEntity(Package shipment);

    @Mapping(target = "merchantInventoryId", ignore = true)
    @Mapping(target = "status", source = "shipmentStatus")
    Package toDomain(PackageEntity packageEntity);
}
