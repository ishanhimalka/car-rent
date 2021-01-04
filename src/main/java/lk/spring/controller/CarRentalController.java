package lk.spring.controller;

import lk.spring.dto.CarRentalDTO;
import lk.spring.service.CarRentalService;
import lk.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/carrental")
public class CarRentalController {

    @Autowired
    CarRentalService  service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCar(@RequestBody CarRentalDTO dto) {
        System.out.println(dto);
        service.saveCar(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCar(@RequestBody CarRentalDTO dto) {
        service.updateCar(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"carNumber"})
    public ResponseEntity deleteCar(String carNumber) {

        service.deleteCar(carNumber);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{carNumber}")
    public ResponseEntity searchCar(@PathVariable String carNumber) {
        service.searchCar(carNumber);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllCars() {
        List<CarRentalDTO> allCar = service.getAllCars();
        StandardResponse response = new StandardResponse(200, "Success", allCar);
        return new ResponseEntity(response, HttpStatus.CREATED);

    }

}
