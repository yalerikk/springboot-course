package com.example.springboot_course.reservations.availability;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CheckAvailabilityRequest(
        @NotNull
        Long roomId,
        @NotNull
        LocalDate startDate,
        @NotNull
        LocalDate endDate
) {
}
