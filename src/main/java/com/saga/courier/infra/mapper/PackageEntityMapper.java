package com.saga.courier.infra.mapper;

import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.model.Product;
import com.saga.courier.domain.model.enums.ShipmentDomainStatus;
import com.saga.courier.infra.common.gateway.dto.PackageRequest;
import com.saga.courier.infra.model.MerchantProductEntity;
import com.saga.courier.infra.model.PackageEntity;
import com.saga.courier.infra.model.enums.ShipmentStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = CourierEntityMapper.class)
public interface PackageEntityMapper {

    ShipmentStatus toEntity(ShipmentDomainStatus status);

    @Mapping(target = "shipmentStatus", source = "status")
    PackageEntity toEntity(Package shipment);

    @Mapping(target = "status", source = "shipmentStatus")
    @Mapping(target = "merchantInventoryId", source = "product.merchantInventoryId")
    Package toDomain(PackageEntity packageEntity);

    List<Package> toDomain(List<PackageEntity> packageEntity);

    Product toDomain(MerchantProductEntity productEntity);

    @Mapping(target = "description", ignore = true)
    @Mapping(target = "pickupAddress", ignore = true)
    @Mapping(target = "returnAddress", ignore = true)
    @Mapping(target = "stockLevel", ignore = true)
    @Mapping(target = "reservedLevel", ignore = true)
    MerchantProductEntity toEntity(Product product);

    @Mapping(target = "courier", expression = "java(pack.courier().getName())")
    PackageRequest toRequest(Package pack);

}
