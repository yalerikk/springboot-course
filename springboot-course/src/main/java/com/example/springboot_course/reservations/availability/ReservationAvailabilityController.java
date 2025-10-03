package com.example.springboot_course.reservations.availability;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations/availability")
public class ReservationAvailabilityController {

    private static final Logger log = LoggerFactory.getLogger(ReservationAvailabilityController.class);
    public final ReservationAvailabilityService service;

    public ReservationAvailabilityController(ReservationAvailabilityService service) {
        this.service = service;
    }

    @PostMapping("/check")
    public ResponseEntity<CheckAvailabilityResponse> checkAvailability(
            CheckAvailabilityRequest request
    ) {
        log.info("Called method checkAvailability: request={}", request);
        boolean isAvailable = service.isReservationAvailable(
                request.roomId(),
                request.startDate(),
                request.endDate()
        );

        var message = isAvailable
                ? "Room available to reseravtion"
                : "Room not available to reseravtion";
        var status = isAvailable
                ? AvailabilityStatus.AVAILABLE
                : AvailabilityStatus.RESERVED;

        return ResponseEntity.status(200)
                .body(new CheckAvailabilityResponse(message, status));
    }
}
