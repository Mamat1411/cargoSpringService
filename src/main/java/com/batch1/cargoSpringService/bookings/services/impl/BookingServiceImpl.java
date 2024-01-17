package com.batch1.cargoSpringService.bookings.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.batch1.cargoSpringService.bookings.entities.Booking;
import com.batch1.cargoSpringService.bookings.repositories.BookingRepository;
import com.batch1.cargoSpringService.bookings.services.BookingService;

public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.getBookingById(id);
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
    
}
