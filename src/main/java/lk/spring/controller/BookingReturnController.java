package lk.spring.controller;

import lk.spring.dto.BookingReturnDTO;
import lk.spring.service.BookingReturnService;
import lk.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/bookingreturn")
public class BookingReturnController {
    @Autowired
    BookingReturnService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveBookReturn(@RequestBody BookingReturnDTO dto) {
        System.out.println(dto);
        service.saveBookReturn(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateBookReturn(@RequestBody BookingReturnDTO dto) {
        service.updateBookReturn(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"Invoice"})
    public ResponseEntity deleteBookReturn(String Invoice) {
        service.deleteBookReturn(Invoice);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{Invoice}")
    public ResponseEntity searchBookReturn(@PathVariable String Invoice) {
        service.searchBookReturn(Invoice);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllBookReturns() {
        List<BookingReturnDTO> allBookReturn = service.getAllBookReturns();
        StandardResponse response = new StandardResponse(200, "Success", allBookReturn);
        return new ResponseEntity(response, HttpStatus.CREATED);

    }
}
