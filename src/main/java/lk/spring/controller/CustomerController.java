package lk.spring.controller;


import lk.spring.dto.CustomerDTO;
import lk.spring.service.CustomerService;
import lk.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) {
        System.out.println(dto);
        service.saveCustomer(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        service.updateCustomer(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"customerregitor"})
    public ResponseEntity updateCustomer(String customerregitor) {
        service.deleteCustomer(customerregitor);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{customerregitor}")
    public ResponseEntity searchCustomer(@PathVariable String customerregitor) {
        service.searchCustomer(customerregitor);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllCustomer() {
        List<CustomerDTO> allcustomer = service.getAllCustomer();
        StandardResponse response = new StandardResponse(200, "Success", allcustomer);
        return new ResponseEntity(response, HttpStatus.CREATED);

    }

}
