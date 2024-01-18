package com.batch1.cargoSpringService.vessels.services;

import java.util.List;

import com.batch1.cargoSpringService.vessels.entities.VesselInfo;

public interface VesselInfoService {
    List<VesselInfo> getAllVesselInfo();
    VesselInfo getVesselInfoById(Long vesselId);
    VesselInfo saveVesselInfo(VesselInfo vesselInfo);
    void deleteVesselInfo(Long vesselId);
}
