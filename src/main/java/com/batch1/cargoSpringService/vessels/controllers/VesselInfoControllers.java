package com.batch1.cargoSpringService.vessels.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.batch1.cargoSpringService.vessels.dtos.requests.VesselInfoRequestDto;
import com.batch1.cargoSpringService.vessels.dtos.responses.VesselInfoResponseDto;
import com.batch1.cargoSpringService.vessels.entities.VesselInfo;
import com.batch1.cargoSpringService.vessels.services.VesselInfoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/vesselinfo")
public class VesselInfoControllers {
    
    @Autowired
    private VesselInfoService vesselInfoService;

    @GetMapping("/")
    public ResponseEntity<?> getAllVesselInfo() {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            List<VesselInfo> vesselInfos = vesselInfoService.getAllVesselInfo();
            List<VesselInfoResponseDto> infoResponseDtos = vesselInfos.stream().map(vessel -> modelMapper.map(vessel, VesselInfoResponseDto.class)).collect(Collectors.toList());

            resultMap.put("Status", "200");
            resultMap.put("Message", "success");
            resultMap.put("Data", infoResponseDtos);

            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("Status", "500");
            resultMap.put("Message", "Internal Server Error");
            resultMap.put("Data", null);

            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{vesselId}")
    public ResponseEntity<?> getVesselInfoById(@PathVariable("vesselId") Long vesselId) {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            VesselInfo vesselInfo = vesselInfoService.getVesselInfoById(vesselId);
            VesselInfoResponseDto vesselInfoResponseDto = modelMapper.map(vesselInfo, VesselInfoResponseDto.class);

            resultMap.put("Status", "200");
            resultMap.put("Message", "success");
            resultMap.put("Data", vesselInfoResponseDto);

            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("Status", "500");
            resultMap.put("Message", "Internal Server Error");
            resultMap.put("Data", null);

            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/")
    public ResponseEntity<?> saveVesselInfo(@RequestBody VesselInfoRequestDto vesselInfoRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            VesselInfo vesselInfo = modelMapper.map(vesselInfoRequestDto, VesselInfo.class);
            vesselInfoService.saveVesselInfo(vesselInfo);

            resultMap.put("Status", "200");
            resultMap.put("Message", "success");
            resultMap.put("Data", vesselInfo);

            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("Status", "500");
            resultMap.put("Message", "Internal Server Error");
            resultMap.put("Data", null);

            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{vesselId}")
    public ResponseEntity<?> updateVesselInfo(@PathVariable Long vesselId, @RequestBody VesselInfoRequestDto vesselInfoRequestDto) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            VesselInfo vesselInfo = vesselInfoService.getVesselInfoById(vesselId);
            vesselInfo.setVesselName(vesselInfoRequestDto.getVesselName());
            vesselInfo.setVesselCapacity(vesselInfoRequestDto.getVesselCapacity());
            vesselInfo.setVesselSpeed(vesselInfoRequestDto.getVesselSpeed());
            vesselInfo.setVesselLength(vesselInfoRequestDto.getVesselLength());
            vesselInfo.setVesselBreadth(vesselInfoRequestDto.getVesselBreadth());
            vesselInfo.setVesselType(vesselInfoRequestDto.getVesselType());
            vesselInfo.setVesselStatus(vesselInfoRequestDto.getVesselStatus());
            vesselInfo.setGrossTonnage(vesselInfoRequestDto.getGrossTonnage());
            vesselInfo.setDeadweightTonnage(vesselInfoRequestDto.getDeadweightTonnage());
            vesselInfo.setCargoId(vesselInfoRequestDto.getCargoId());
            vesselInfoService.saveVesselInfo(vesselInfo);

            resultMap.put("Status", "200");
            resultMap.put("Message", "success");
            resultMap.put("Data", vesselInfo);

            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("Status", "500");
            resultMap.put("Message", "Internal Server Error");
            resultMap.put("Data", null);

            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{vesselId}")
    public ResponseEntity<?> deleteVesselInfo(@PathVariable("vesselId") Long vesselId){
        Map<String, Object> resultMap = new HashMap<>();
        try {
            VesselInfo vesselInfo = vesselInfoService.getVesselInfoById(vesselId);
            vesselInfoService.deleteVesselInfo(vesselInfo.getVesselId());

            resultMap.put("Status", "200");
            resultMap.put("Message", "success");

            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("Status", "500");
            resultMap.put("Message", "Internal Server Error");

            return new ResponseEntity<>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
