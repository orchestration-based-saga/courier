package com.saga.courier.application.controller;

import com.saga.courier.application.controller.api.PackageResponse;
import com.saga.courier.application.service.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
