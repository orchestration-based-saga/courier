package com.saga.courier.infra.model;

import com.saga.courier.infra.model.enums.ShipmentStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity(name = "Package")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
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
    @OneToOne
    @JoinColumn(name = "merchant_inventory_id", referencedColumnName = "merchant_inventory_id")
    MerchantProductEntity product;
    @LastModifiedDate
    LocalDateTime courierAssignedAt;
}
