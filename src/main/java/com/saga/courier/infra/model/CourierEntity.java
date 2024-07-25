package com.saga.courier.infra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "Courier")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
}
