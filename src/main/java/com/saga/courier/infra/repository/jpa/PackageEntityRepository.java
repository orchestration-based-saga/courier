package com.saga.courier.infra.repository.jpa;

import com.saga.courier.infra.model.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageEntityRepository extends JpaRepository<PackageEntity, Integer> {

    List<PackageEntity> findByCourierId(Integer id);
}
