package com.batch1.cargoSpringService.bookings.dtos.requests;

import java.util.Date;

import lombok.Data;

@Data
public class BookingRequestDto {
    private Date bookingDate;
    private Date pickupDate;
    private Date deliveryDate;
    private String bookingStatus;
    private String containerType;
}
