package SPID.demo.controllers;

import SPID.demo.entities.Spid;
import SPID.demo.entities.User;
import SPID.demo.services.SpidService;
import SPID.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@RestController
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/api/createUser")
    public ResponseEntity<User> createSpid(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) User newuser){
        return new ResponseEntity(service.createUser(newuser), HttpStatus.CREATED);
    }

    @PutMapping("/api/editUser/{id}")
    public ResponseEntity<User> editUser(@PathVariable("id") long id,@RequestBody User user){

        return new ResponseEntity(service.editUser(id,user),HttpStatus.OK);

    }

}
