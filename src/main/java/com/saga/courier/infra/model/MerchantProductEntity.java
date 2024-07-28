package com.saga.courier.infra.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "MerchantProduct")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MerchantProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "merchant_inventory_id")
    Integer merchantInventoryId;
    String name;
    String description;
    Boolean serviceable;
    @OneToOne
    @JoinColumn(name = "pickup_address", referencedColumnName = "id")
    AddressEntity pickupAddress;
    @OneToOne
    @JoinColumn(name = "return_address", referencedColumnName = "id")
    AddressEntity returnAddress;
    Integer stockLevel;
    Integer reservedLevel;
    Boolean bulky;
}
