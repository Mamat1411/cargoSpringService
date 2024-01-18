package com.batch1.cargoSpringService.vessels.dtos.responses;

import com.batch1.cargoSpringService.cargos.entities.CargoInfo;

import lombok.Data;

@Data
public class VesselInfoResponseDto {
    private String vesselName;
    private Long vesselCapacity;
    private Long vesselSpeed;
    private Long vesselLength;
    private Long vesselBreadth;
    private String vesselType;
    private String vesselStatus;
    private Long grossTonnage;
    private Long deadweightTonnage;
    private CargoInfo cargoId;
}
