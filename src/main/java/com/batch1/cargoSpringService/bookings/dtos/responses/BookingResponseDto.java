package com.batch1.cargoSpringService.bookings.dtos.responses;

import java.util.Date;

import lombok.Data;

@Data
public class BookingResponseDto {
    private Date bookingDate;
    private Date pickupDate;
    private Date deliveryDate;
    private String bookingStatus;
    private String containerType;
}
