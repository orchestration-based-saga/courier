package com.saga.courier.application.mapper;

import com.saga.courier.application.controller.api.response.PackageResponse;
import com.saga.courier.application.messaging.UpdateShipmentStatus;
import com.saga.courier.application.messaging.api.ShipmentRequest;
import com.saga.courier.application.messaging.api.enums.ShipmentState;
import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.model.Product;
import com.saga.courier.domain.model.enums.ShipmentDomainStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper
public interface PackageMapper {

    @Mapping(target = "shipmentId", source = "id")
    @Mapping(target = "product", source = "merchantInventoryId", qualifiedByName = "linkProduct")
    @Mapping(target = "courier", ignore = true)
    Package fromMessage(ShipmentRequest shipmentRequest);

    @Named("linkProduct")
    default Product linkProduct(Integer merchantInventoryId) {
        return new Product(merchantInventoryId, null, null, null);
    }

    PackageResponse toPackageResponse(Package pack);

    List<PackageResponse> toResponse(List<Package> aPackage);

    ShipmentDomainStatus toDomain(ShipmentState state);

    ShipmentState toMessage(ShipmentDomainStatus status);

    @Mapping(target = "status", source = "domainStatus")
    UpdateShipmentStatus toMessage(String packageId, ShipmentDomainStatus domainStatus);
}
