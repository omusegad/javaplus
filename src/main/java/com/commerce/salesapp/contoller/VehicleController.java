package com.commerce.salesapp.contoller;

import com.commerce.salesapp.dto.VehicleRequest;
import com.commerce.salesapp.dto.VehicleResponse;
import com.commerce.salesapp.mapper.VehicleMapper;
import com.commerce.salesapp.model.Vehicle;
import com.commerce.salesapp.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final VehicleMapper vehicleMapper;

    public VehicleController(VehicleService vehicleService, VehicleMapper vehicleMapper) {
        this.vehicleService = vehicleService;
        this.vehicleMapper = vehicleMapper;
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> getVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();

        return vehicles.isEmpty()
                ? ResponseEntity.<List<VehicleResponse>>noContent().build()
                : ResponseEntity.ok(vehicleMapper.toDoList(vehicles));
    }

    @PostMapping
    public ResponseEntity<VehicleResponse> addVehicle(@Valid @RequestBody VehicleRequest request){
        Vehicle vehicle = vehicleService.addVehicle(vehicleMapper.toEntity(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleMapper.toDto(vehicle));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.noContent().build();
    }

}