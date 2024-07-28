package com.saga.courier.domain.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Courier {
    ONE_MAN_DELIVERY(1, "One man delivery"),
    TWO_MEN_DELIVERY(2, "Two men delivery");

    private Integer id;
    private String name;

}
