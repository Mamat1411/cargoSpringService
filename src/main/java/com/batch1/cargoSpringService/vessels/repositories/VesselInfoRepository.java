package com.batch1.cargoSpringService.vessels.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.batch1.cargoSpringService.vessels.entities.VesselInfo;

@Repository
public interface VesselInfoRepository extends JpaRepository<VesselInfo, Long>{
    @Query(value = "select * from vessel_info where vessel_id =?1", nativeQuery = true)
    VesselInfo getVesselInfoById(Long vesselId);
}
