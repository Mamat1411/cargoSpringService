package com.batch1.cargoSpringService.cargos.services;

import java.util.List;

import com.batch1.cargoSpringService.cargos.entities.CargoInfo;

public interface CargoInfoService {
    List<CargoInfo> getAllCargoInfo();
    CargoInfo getCargoInfoById(Long cargoId);
    CargoInfo saveCargoInfo(CargoInfo cargoInfo);
    void deleteCargoInfo(Long cargoId);
}
