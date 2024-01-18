package com.batch1.cargoSpringService.cargos.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch1.cargoSpringService.cargos.entities.CargoInfo;
import com.batch1.cargoSpringService.cargos.repositories.CargoInfoRepository;
import com.batch1.cargoSpringService.cargos.services.CargoInfoService;

@Service
public class CargoInfoServiceImpl implements CargoInfoService{

    @Autowired
    private CargoInfoRepository cargoInfoRepository;

    @Override
    public List<CargoInfo> getAllCargoInfo() {
        return cargoInfoRepository.findAll();
    }

    @Override
    public CargoInfo getCargoInfoById(Long cargoId) {
        return cargoInfoRepository.getCargoInfoById(cargoId);
    }

    @Override
    public CargoInfo saveCargoInfo(CargoInfo cargoInfo) {
        return cargoInfoRepository.save(cargoInfo);
    }

    @Override
    public void deleteCargoInfo(Long cargoId) {
        cargoInfoRepository.deleteById(cargoId);
    }
    
}
