package com.saga.courier.infra.client;

import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.out.WarehouseClientApi;
import com.saga.courier.infra.common.gateway.WarehouseManagementClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WarehouseClient implements WarehouseClientApi {

    private final WarehouseManagementClient client;

    @Override
    public boolean notifyOfIncomingDelivery(Package shipment) {
        return false;
    }
}
