package com.commerce.salesapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleRequest(
        @NotNull boolean in_use,
        @NotBlank String vehicle_type
) {


}