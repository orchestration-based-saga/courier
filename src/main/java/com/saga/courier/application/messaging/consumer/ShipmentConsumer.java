package com.saga.courier.application.messaging.consumer;

import com.saga.courier.application.mapper.PackageMapper;
import com.saga.courier.application.messaging.api.ShipmentRequest;
import com.saga.courier.domain.in.CourierDomainServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class ShipmentConsumer {

    private final CourierDomainServiceApi courierDomainServiceApi;
    private final PackageMapper packageMapper;

    @Bean
    public Consumer<Message<ShipmentRequest>> shipment() {
        return msg -> {
            courierDomainServiceApi.upsert(packageMapper.fromMessage(msg.getPayload()));
        };
    }
}
