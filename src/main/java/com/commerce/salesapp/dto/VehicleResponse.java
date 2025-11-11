package com.commerce.salesapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleResponse(
        @NotNull Long id,
        @NotNull boolean in_use,
        @NotBlank String vehicle_type
) {
}