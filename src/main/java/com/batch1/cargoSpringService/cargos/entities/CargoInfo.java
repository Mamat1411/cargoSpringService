package com.batch1.cargoSpringService.cargos.entities;

import com.batch1.cargoSpringService.bookings.entities.Booking;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cargo_info")
public class CargoInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_id")
    private Long cargoId;

    @Column(name = "cargo_type", length = 50)
    private String cargoType;

    @Column(name = "cargo_description")
    private String cargoDescription;

    @Column(name = "cargo_weight", length = 5)
    private Long cargoWeight;

    @Column(name = "cargo_volume", length = 5)
    private Long cargoVolume;

    @Column(name = "hazardous_or_fragile", length = 15)
    private String hazardousOrFragile;

    @Column(name = "quantity", length = 5)
    private Long quantity;

    @Column(name = "unit_price")
    private Long unitPrice;

    @Column(name = "cargo_price")
    private Long cargoPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_booking_id", referencedColumnName = "booking_id")
    private Booking bookingId;
}
