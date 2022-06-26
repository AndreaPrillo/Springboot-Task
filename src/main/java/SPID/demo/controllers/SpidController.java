package SPID.demo.controllers;

import SPID.demo.entities.Spid;
import SPID.demo.services.SpidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class SpidController {

    @Autowired
    SpidService service;

    @PostMapping("/api/createSpid")
    public ResponseEntity<Spid> createSpid(@RequestBody Spid newSpid){
        return new ResponseEntity(service.createSpid(newSpid), HttpStatus.CREATED) ;
    }


    @GetMapping("/api/getAllSpid")
    public ResponseEntity<Spid> getAllSpids(){
        return new ResponseEntity(service.getAllSpids(), HttpStatus.OK) ;
    }


    @DeleteMapping("/api/spid/{id}")

    public ResponseEntity<String> deleteSpid(@PathVariable("id") long id ){
        return new ResponseEntity("Spid with id " +id+" has been deleted.", HttpStatus.OK);
    }

    @PutMapping("/api/spid/{id}/{id2}")

    public ResponseEntity<Spid> changeSpidStatus(@PathParam("id") long id, @PathParam("id2") long id2){
        return new ResponseEntity(service.changeSpidStatus(id,id2),HttpStatus.OK);
    }

}
