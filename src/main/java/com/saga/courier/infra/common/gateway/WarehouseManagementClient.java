package com.saga.courier.infra.common.gateway;

import com.saga.courier.infra.common.gateway.dto.PackageIdsRequest;
import com.saga.courier.infra.common.gateway.dto.PackageRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "wms-client",
        url = "${http.client.warehouse.url}"
)
public interface WarehouseManagementClient {

    @PostMapping
    ResponseEntity<Void> incomingDelivery(@RequestBody PackageRequest pack);

    @PostMapping("/trigger-engine")
    ResponseEntity<Void> deliverPackage(@RequestBody PackageIdsRequest packageIds);
}
