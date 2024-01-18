package com.batch1.cargoSpringService.cargos.controllers;

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

import com.batch1.cargoSpringService.bookings.entities.Booking;
import com.batch1.cargoSpringService.cargos.dtos.requests.CargoInfoRequestDto;
import com.batch1.cargoSpringService.cargos.dtos.responses.CargoInfoResponseDto;
import com.batch1.cargoSpringService.cargos.entities.CargoInfo;
import com.batch1.cargoSpringService.cargos.services.CargoInfoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/api/cargoinfo")
public class CargoInfoController {

    @Autowired
    private CargoInfoService cargoInfoService;

    @GetMapping("/")
    public ResponseEntity<?> getAllCargoInfo() {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            List<CargoInfo> cargoInfos = cargoInfoService.getAllCargoInfo();
            List<CargoInfoResponseDto> cargoInfoResponseDto = cargoInfos.stream().map(cargo -> modelMapper.map(cargo, CargoInfoResponseDto.class)).collect(Collectors.toList());

            resultMap.put("Status", "200");
            resultMap.put("Message", "success");
            resultMap.put("Data", cargoInfoResponseDto);

            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("Status", "500");
            resultMap.put("Message", "Internal Server Error");
            resultMap.put("Data", null);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{cargoId}")
    public ResponseEntity<?> getCargoInfoById(@PathVariable("cargoId") Long cargoId) {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            CargoInfo cargoInfo = cargoInfoService.getCargoInfoById(cargoId);
            CargoInfoResponseDto cargoInfoResponseDto = modelMapper.map(cargoInfo, CargoInfoResponseDto.class);

            resultMap.put("Status", "200");
            resultMap.put("Message", "success");
            resultMap.put("Data", cargoInfoResponseDto);

            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("Status", "500");
            resultMap.put("Message", "Internal Server Error");
            resultMap.put("Data", null);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> saveCargoInfo(@RequestBody CargoInfoRequestDto cargoInfoRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Map<String, Object> resultMap = new HashMap<>();
        try {
            CargoInfo cargoInfo = modelMapper.map(cargoInfoRequestDto, CargoInfo.class);
            cargoInfoService.saveCargoInfo(cargoInfo);

            resultMap.put("Status", "200");
            resultMap.put("Message", "succss");
            resultMap.put("Data", cargoInfo);

            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("Status", "500");
            resultMap.put("Message", "Internal Server Error");
            resultMap.put("Data", null);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{cargoId}")
    public ResponseEntity<?> updateCargoInfo(@PathVariable("cargoId") Long cargoId, @RequestBody CargoInfoRequestDto cargoInfoRequestDto) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            CargoInfo cargoInfo = cargoInfoService.getCargoInfoById(cargoId);
            cargoInfo.setCargoType(cargoInfoRequestDto.getCargoType());
            cargoInfo.setCargoDescription(cargoInfoRequestDto.getCargoDescription());
            cargoInfo.setCargoWeight(cargoInfoRequestDto.getCargoWeight());
            cargoInfo.setCargoVolume(cargoInfoRequestDto.getCargoVolume());
            cargoInfo.setHazardousOrFragile(cargoInfoRequestDto.getHazardousOrFragile());
            cargoInfo.setQuantity(cargoInfoRequestDto.getQuantity());
            cargoInfo.setUnitPrice(cargoInfoRequestDto.getUnitPrice());
            cargoInfo.setCargoPrice(cargoInfoRequestDto.getCargoPrice());
            cargoInfoService.saveCargoInfo(cargoInfo);

            resultMap.put("Status", "200");
            resultMap.put("Message", "succss");
            resultMap.put("Data", cargoInfo);

            return new ResponseEntity<>(resultMap, HttpStatus.OK);
        } catch (Exception e) {
            resultMap.put("Status", "500");
            resultMap.put("Message", "Internal Server Error");
            resultMap.put("Data", null);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cargoId}")
    public ResponseEntity<?> deleteBooking(@PathVariable("cargoId") Long cargoId){
        Map<String, Object> resultMap = new HashMap<>();
        try {
            CargoInfo cargoInfo = cargoInfoService.getCargoInfoById(cargoId);
            cargoInfoService.deleteCargoInfo(cargoInfo.getCargoId());

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
