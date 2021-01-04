package lk.spring.controller;


import lk.spring.dto.BookingDTO;
import lk.spring.service.BookingService;
import lk.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/booking")
public class BookingController {
    @Autowired
    BookingService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveBook(@RequestBody BookingDTO dto) {
        System.out.println(dto);
        service.saveBook(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateBook(@RequestBody BookingDTO dto) {
        service.updateBook(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"bookingId"})
    public ResponseEntity deleteBook(String bookingId) {
        service.deleteBook(bookingId);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{bookingId}")
    public ResponseEntity searchBook(@PathVariable String bookingId) {
        service.searchBook(bookingId);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllBook() {
        List<BookingDTO> allbooking = service.getAllBook();
        StandardResponse response = new StandardResponse(200, "Success", allbooking);
        return new ResponseEntity(response, HttpStatus.CREATED);

    }

    @PutMapping(params = {"bookingId"})
    public ResponseEntity confirmBook(String bookingId) {
        service.confirmBook(bookingId);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

}
