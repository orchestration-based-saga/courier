package com.saga.courier.application.messaging;

import com.saga.courier.application.mapper.PackageMapper;
import com.saga.courier.application.messaging.api.ShipmentRequest;
import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.out.ShipmentProducerApi;
import com.saga.courier.infra.common.event.StreamBindingConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShipmentProducer implements ShipmentProducerApi {

    private final StreamBridge streamBridge;
    private final PackageMapper packageMapper;

    @Override
    public void updateShipment(Package pack) {
        streamBridge.send(StreamBindingConstants.UPDATE_SHIPMENT_STATUS, MessageBuilder.withPayload(
                packageMapper.toMessage(pack.packageId(), pack.status())
        ).build()
        );
    }
}
