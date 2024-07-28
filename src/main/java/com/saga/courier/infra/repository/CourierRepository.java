package com.saga.courier.infra.repository;

import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.out.CourierRepositoryApi;
import com.saga.courier.infra.mapper.PackageEntityMapper;
import com.saga.courier.infra.model.PackageEntity;
import com.saga.courier.infra.repository.jpa.PackageEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CourierRepository implements CourierRepositoryApi {

    private final PackageEntityRepository packageEntityRepository;
    private final PackageEntityMapper packageEntityMapper;

    @Override
    public Package createPackage(Package shipment) {
        PackageEntity packageEntity = packageEntityMapper.toEntity(shipment);
        packageEntity = packageEntityRepository.save(packageEntity);
        return packageEntityMapper.toDomain(packageEntity);
    }
}
