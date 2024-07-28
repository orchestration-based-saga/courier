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
    String packageId;
    Integer shipmentId;
    Integer itemId;
    String orderId;
    @OneToOne
    @JoinColumn(name = "courier_id", referencedColumnName = "id")
    CourierEntity courier;
    @Enumerated(EnumType.STRING)
    ShipmentStatus shipmentStatus;
}
