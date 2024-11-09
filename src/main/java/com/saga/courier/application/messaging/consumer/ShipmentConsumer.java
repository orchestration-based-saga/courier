package com.saga.courier.application.messaging.consumer;

import com.saga.courier.application.api.event.ItemServicingProcessRequest;
import com.saga.courier.application.api.event.ShipmentMessage;
import com.saga.courier.application.api.event.ShipmentProcessMessage;
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

    @Bean
    public Consumer<Message<ShipmentProcessMessage>> notifyWarehouse() {
        return msg -> {
            ShipmentProcessMessage request = msg.getPayload();
            ItemServicingRequest itemServicingRequest = packageMapper.toItemServicingRequest(request);
            courierDomainServiceApi.notifyWarehouse(request.shipmentId(), itemServicingRequest);
        };
    }

    @Bean
    public Consumer<Message<ShipmentMessage>> shipment() {
        return msg -> {
            var message = msg.getPayload();
            courierDomainServiceApi.updateStatus(message.packageId(), packageMapper.fromMessage(message.status()));
        };
    }
}
