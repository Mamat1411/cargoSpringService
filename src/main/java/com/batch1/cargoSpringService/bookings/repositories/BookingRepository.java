package com.batch1.cargoSpringService.bookings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batch1.cargoSpringService.bookings.entities.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
    @Query(value = "select * from bookings where booking_id =?1", nativeQuery = true)
    Booking getBookingById(Long bookingId);
}
