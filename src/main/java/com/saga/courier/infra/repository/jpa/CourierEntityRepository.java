package com.saga.courier.infra.repository.jpa;

import com.saga.courier.infra.model.CourierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierEntityRepository extends JpaRepository<CourierEntity, Integer> {
}
