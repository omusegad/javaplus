package com.commerce.salesapp.mapper;

import com.commerce.salesapp.dto.VehicleRequest;
import com.commerce.salesapp.dto.VehicleResponse;
import com.commerce.salesapp.model.Vehicle;
import org.mapstruct.Mapper;


import java.util.List;


@Mapper(componentModel = "spring")
public interface VehicleMapper {
     Vehicle toEntity(VehicleRequest request);
     VehicleResponse toDto(Vehicle vehicle);
     List<VehicleResponse> toDoList(List<Vehicle> vehicles);
}