package com.saga.courier.infra.mapper;

import com.saga.courier.domain.model.enums.Courier;
import com.saga.courier.infra.model.CourierEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CourierEntityMapper {

    @Mapping(target = "id", expression = "java(courier.getId())")
    @Mapping(target = "name", expression = "java(courier.getName())")
    CourierEntity toEntity(Courier courier);

    default Courier toDomain(CourierEntity courier) {
        if (courier == null) {
            return null;
        }
        if (courier.getId() == 1) {
            return Courier.ONE_MAN_DELIVERY;
        } else {
            return Courier.TWO_MEN_DELIVERY;
        }
    }
}
