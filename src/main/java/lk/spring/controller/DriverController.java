package lk.spring.controller;

import lk.spring.dto.DriverDTO;
import lk.spring.service.DriverService;
import lk.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/driver")
public class DriverController {
    @Autowired
    DriverService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveDriver(@RequestBody DriverDTO dto) {
        System.out.println(dto);
        service.saveDriver(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateDriver(@RequestBody DriverDTO dto) {
        service.updateDriver(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"driverId"})
    public ResponseEntity deleteDriver(String driverId) {
        service.deleteDriver(driverId);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{driverId}")
    public ResponseEntity searchDriver(@PathVariable String driverId) {
        service.searchDriver(driverId);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllDrivers() {
        List<DriverDTO> allDriver = service.getAllDrivers();
        StandardResponse response = new StandardResponse(200, "Success", allDriver);
        return new ResponseEntity(response, HttpStatus.CREATED);

    }
}
