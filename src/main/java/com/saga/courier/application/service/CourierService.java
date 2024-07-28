package com.saga.courier.application.service;

import com.saga.courier.application.controller.api.PackageResponse;
import com.saga.courier.application.mapper.PackageMapper;
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
}
