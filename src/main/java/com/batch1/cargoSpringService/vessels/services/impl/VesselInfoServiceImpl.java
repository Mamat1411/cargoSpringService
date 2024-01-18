package com.batch1.cargoSpringService.vessels.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.batch1.cargoSpringService.vessels.entities.VesselInfo;
import com.batch1.cargoSpringService.vessels.repositories.VesselInfoRepository;
import com.batch1.cargoSpringService.vessels.services.VesselInfoService;

@Service
public class VesselInfoServiceImpl implements VesselInfoService{

    @Autowired
    private VesselInfoRepository vesselInfoRepository;

    @Override
    public List<VesselInfo> getAllVesselInfo() {
        return vesselInfoRepository.findAll();
    }

    @Override
    public VesselInfo getVesselInfoById(Long vesselId) {
        return vesselInfoRepository.getVesselInfoById(vesselId);
    }

    @Override
    public VesselInfo saveVesselInfo(VesselInfo vesselInfo) {
        return vesselInfoRepository.save(vesselInfo);
    }

    @Override
    public void deleteVesselInfo(Long vesselId) {
        vesselInfoRepository.deleteById(vesselId);
    }
}
