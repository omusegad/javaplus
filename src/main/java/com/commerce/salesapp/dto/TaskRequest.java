package com.commerce.salesapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TaskRequest(
        @NotBlank(message = "Title is required")
        String title,

        @NotNull(message = "Status cannot be null")
        Boolean status
) {

}