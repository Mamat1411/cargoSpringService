package com.batch1.cargoSpringService.bookings.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.batch1.cargoSpringService.bookings.entities.Booking;
import com.batch1.cargoSpringService.bookings.repositories.BookingRepository;
import com.batch1.cargoSpringService.bookings.services.BookingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

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

    @Override
    @KafkaListener(topics = "booking", groupId = "booking_groupid")
    public void receiveBooking(String data) throws JsonProcessingException{
        Booking booking = objectMapper.readValue(data, Booking.class);
        bookingRepository.save(booking);
    }
    
}
