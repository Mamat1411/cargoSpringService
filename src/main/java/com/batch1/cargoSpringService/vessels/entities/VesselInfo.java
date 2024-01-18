package com.batch1.cargoSpringService.vessels.entities;

import com.batch1.cargoSpringService.cargos.entities.CargoInfo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "vessel_info")
public class VesselInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vessel_id")
    private Long vesselId;

    @Column(name = "vessel_name", length = 50)
    private String vesselName;

    @Column(name = "vessel_capacity", length = 5)
    private Long vesselCapacity;

    @Column(name = "vessel_speed", length = 5)
    private Long vesselSpeed;

    @Column(name = "vessel_length", length = 5)
    private Long vesselLength;

    @Column(name = "vessel_breadth", length = 5)
    private Long vesselBreadth;

    @Column(name = "vessel_type", length = 50)
    private String vesselType;

    @Column(name = "vessel_status", length = 50)
    private String vesselStatus;

    @Column(name = "gross_tonnage", length = 5)
    private Long grossTonnage;

    @Column(name = "deadweight_tonnage", length = 5)
    private Long deadweightTonnage;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_cargo_id", referencedColumnName = "cargo_id")
    private CargoInfo cargoId;
}
