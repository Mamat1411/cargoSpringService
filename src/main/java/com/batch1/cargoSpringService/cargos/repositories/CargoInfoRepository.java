package com.batch1.cargoSpringService.cargos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.batch1.cargoSpringService.cargos.entities.CargoInfo;

public interface CargoInfoRepository extends JpaRepository<CargoInfo, Long>{
    @Query(value = "select * from cargo_info where cargo_id=?1", nativeQuery = true)
    CargoInfo getCargoInfoById(Long cargoId);
}
