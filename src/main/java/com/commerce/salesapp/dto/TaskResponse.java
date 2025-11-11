package com.commerce.salesapp.dto;

public record TaskResponse(
        Long id,
        String title,
        Boolean status
) {
}