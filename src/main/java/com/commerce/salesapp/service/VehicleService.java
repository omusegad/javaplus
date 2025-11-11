package com.commerce.salesapp.service;

import com.commerce.salesapp.model.Vehicle;
import com.commerce.salesapp.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle>getVehicleById(Long id){
      return vehicleRepository.findById(id);
    }

    public void deleteVehicle( Long id){
        vehicleRepository.deleteById(id);
    }
}