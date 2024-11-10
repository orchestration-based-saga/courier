package com.saga.courier.infra.client;

import com.saga.courier.domain.model.Package;
import com.saga.courier.domain.out.WarehouseClientApi;
import com.saga.courier.infra.common.gateway.WarehouseManagementClient;
import com.saga.courier.infra.common.gateway.dto.PackageIdsRequest;
import com.saga.courier.infra.common.gateway.dto.PackageRequest;
import com.saga.courier.infra.mapper.PackageEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WarehouseClient implements WarehouseClientApi {

    private final WarehouseManagementClient client;
    private final PackageEntityMapper mapper;

    @Override
    public boolean notifyOfIncomingDelivery(Package shipment) {
        PackageRequest request = mapper.toRequest(shipment);
        return client.incomingDelivery(request).getStatusCode().is2xxSuccessful();
    }

    @Override
    public void deliverPackage(Package shipment) {
        var request = new PackageIdsRequest(List.of(shipment.packageId()));
        client.deliverPackage(request);
    }
}
