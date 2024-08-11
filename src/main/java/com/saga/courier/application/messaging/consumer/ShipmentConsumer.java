package com.saga.courier.application.messaging.consumer;

import com.saga.courier.application.api.event.ItemServicingProcessRequest;
import com.saga.courier.application.mapper.PackageMapper;
import com.saga.courier.domain.in.CourierDomainServiceApi;
import com.saga.courier.domain.model.ItemServicingRequest;
import com.saga.courier.domain.model.Package;
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
    public Consumer<Message<ItemServicingProcessRequest>> shipmentCreated() {
        return msg -> {
            ItemServicingProcessRequest request = msg.getPayload();
            ItemServicingRequest itemServicingRequest = packageMapper.toItemServicingRequest(request);
            Package shipment = packageMapper.fromMessage(request.claim());
            courierDomainServiceApi.upsert(shipment, itemServicingRequest);
        };
    }
}
