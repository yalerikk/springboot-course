package com.example.springboot_course.reservations.availability;

public record CheckAvailabilityResponse(
        String message,
        AvailabilityStatus status
) {
}
