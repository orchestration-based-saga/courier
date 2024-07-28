package com.saga.courier.domain.model;

public record Product(
        Integer merchantInventoryId,
        String name,
        Boolean serviceable,
        Boolean bulky
) {
}
