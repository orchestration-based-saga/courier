package com.saga.courier.application.controller;

import com.saga.courier.application.controller.api.request.UpdateStatusRequest;
import com.saga.courier.application.controller.api.response.PackageResponse;
import com.saga.courier.application.messaging.api.enums.ShipmentState;
import com.saga.courier.application.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courier")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @GetMapping("/{courier-id}")
    public ResponseEntity<List<PackageResponse>> getAll(@PathVariable("courier-id") Integer id) {
        List<PackageResponse> packages = courierService.getPackagesForCourier(id);
        return ResponseEntity.ok().body(packages);
    }

    @PostMapping("/update-status")
    public ResponseEntity<Void> updateStatus(@RequestBody UpdateStatusRequest request) {
        if (courierService.updateStatus(request.packageId(), request.updatedStatus())) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }
}
