package lk.spring.controller;

import lk.spring.dto.UserDTO;
import lk.spring.service.UserService;
import lk.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveUser(@RequestBody UserDTO dto) {
        System.out.println(dto);
        service.saveUser(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserDTO dto) {
        service.updateUser(dto);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @DeleteMapping(params = {"username"})
    public ResponseEntity deleteUser(String username) {
        service.deleteUser(username);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity searchUser(@PathVariable String username) {
        service.searchUser(username);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<StandardResponse> getAllUsers() {
        List<UserDTO> allDriver = service.getAllUsers();
        StandardResponse response = new StandardResponse(200, "Success", allDriver);
        return new ResponseEntity(response, HttpStatus.CREATED);

    }
    @GetMapping("/login")
    public ResponseEntity userLogin(@RequestParam String username, @RequestParam String pass) {
        boolean b = service.userLogin(username, pass);
        StandardResponse response = new StandardResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
