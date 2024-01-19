package com.batch1.cargoSpringService.bookings.services;

import java.util.List;

import com.batch1.cargoSpringService.bookings.entities.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    Booking saveBooking(Booking booking);
    void deleteBooking(Long id);

    void receiveBooking(String data) throws JsonProcessingException;
}
