package lk.spring.controller;

import lk.spring.dto.CarDTO;
import lk.spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lk.spring.util.StandardResponse;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCar(@RequestBody CarDTO dto) {
        System.out.println(dto);
        carService.saveCar(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCar(@RequestBody CarDTO dto) {
        carService.updateCar(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"carNumber"})
    public ResponseEntity deleteCar(String carNumber) {
        carService.deleteCar(carNumber);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{carNumber}")
    public ResponseEntity searchCar(@PathVariable String carNumber) {
        carService.searchCar(carNumber);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllCars() {
        List<CarDTO> allCar = carService.getAllCars();
        StandardResponse response = new StandardResponse(200, "Success", allCar);
        return new ResponseEntity(response, HttpStatus.CREATED);

    }
}
