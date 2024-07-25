package com.saga.courier.infra.model;

import com.saga.courier.infra.model.enums.ShipmentStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Package")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer shipmentId;
    String orderId;
    @OneToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    CourierEntity courier;
    @Enumerated(EnumType.STRING)
    ShipmentStatus shipmentStatus;
}
