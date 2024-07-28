package com.saga.courier.application.service;

import com.saga.courier.application.controller.api.response.PackageResponse;
import com.saga.courier.application.mapper.PackageMapper;
import com.saga.courier.application.messaging.api.enums.ShipmentState;
import com.saga.courier.domain.in.CourierDomainServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourierService {

    private final CourierDomainServiceApi courierDomainServiceApi;
    private final PackageMapper packageMapper;

    public List<PackageResponse>  getPackagesForCourier(Integer id){
        return packageMapper.toResponse(courierDomainServiceApi.getPackagesForCourier(id));
    }

    public boolean updateStatus(String packageId, ShipmentState status) {
        return courierDomainServiceApi.updateStatus(packageId, packageMapper.toDomain(status));
    }
}
