package com.saga.courier.application.messaging.producer;

import com.saga.courier.application.api.event.ItemServicingProcessResponse;
import com.saga.courier.application.api.event.NotifyWarehouseProcessResponse;
import com.saga.courier.application.mapper.PackageMapper;
import com.saga.courier.domain.model.ItemServicingRequest;
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
    public void updateShipment(Package pack, ItemServicingRequest request) {
        ItemServicingProcessResponse response = new ItemServicingProcessResponse(
                request.processId(),
                request.businessKey(),
                packageMapper.toMessage(pack)
        );
        streamBridge.send(StreamBindingConstants.UPDATE_SHIPMENT_STATUS,
                MessageBuilder.withPayload(response).build()
        );
    }

    @Override
    public void warehouseNotified(boolean success, ItemServicingRequest request) {
        NotifyWarehouseProcessResponse response = new NotifyWarehouseProcessResponse(
                request.processId(),
                request.businessKey(),
                success
        );
        streamBridge.send(StreamBindingConstants.WAREHOUSE_NOTIFIED,
                MessageBuilder.withPayload(response).build()
        );
    }
}
