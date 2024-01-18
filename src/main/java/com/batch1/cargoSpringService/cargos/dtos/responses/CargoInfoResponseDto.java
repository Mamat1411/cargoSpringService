package com.batch1.cargoSpringService.cargos.dtos.responses;

import com.batch1.cargoSpringService.bookings.entities.Booking;

import lombok.Data;

@Data
public class CargoInfoResponseDto {
    private String cargoType;
    private String cargoDescription;
    private Long cargoWeight;
    private Long cargoVolume;
    private String hazardousOrFragile;
    private Long quantity;
    private Long unitPrice;
    private Long cargoPrice;
    private Booking bookingId;
}
