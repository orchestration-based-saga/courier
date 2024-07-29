package com.saga.courier.infra.repository.jpa;

import com.saga.courier.infra.model.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PackageEntityRepository extends JpaRepository<PackageEntity, String> {

    List<PackageEntity> findByCourierId(Integer id);

    Optional<PackageEntity> findByShipmentId(Integer id);
}
