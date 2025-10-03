package com.example.springboot_course.reservations;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    @Modifying
    @Query("""
            update ReservationEntity r
            set r.status = :status
            where r.id = :id
            """)
    void setStatus(
            @Param("id") Long id,
            @Param("status") ReservationStatus reservationStatus
    );

    // :endDate – из запроса, r.endDate – объект
    @Query("""
            select r.id from ReservationEntity r
                where r.roomId = :roomId
                and :startDate < r.endDate
                and r.startDate < :endDate
                and r.status = :status
            """)
    List<Long> findConflictsReservationsIds (
            @Param("roomId") Long roomId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("status") ReservationStatus reservationStatus
    );

    // for filtering process in get all
    @Query("""
       SELECT r from ReservationEntity r
            WHERE (:roomId IS NULL OR r.roomId = :roomId)
            AND (:userId IS NULL OR r.userId = :userId)
       """)
    List<ReservationEntity> searchAllByFilter(
            @Param("roomId") Long roomId,
            @Param("userId") Long userId,
            Pageable pageable
    );
}
