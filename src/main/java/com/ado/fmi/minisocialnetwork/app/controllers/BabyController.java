package com.ado.fmi.minisocialnetwork.app.controllers;

import com.ado.fmi.minisocialnetwork.app.exceptions.BabyExistingException;
import com.ado.fmi.minisocialnetwork.app.resources.Baby;
import com.ado.fmi.minisocialnetwork.app.service.BabySocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/babies", produces = "application/json")
public class BabyController {

  @Autowired
  private BabySocialNetworkService socialNetworkService;

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<List<Baby>> getBabies(){
    return new ResponseEntity<>(socialNetworkService.getAllBabies(),HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<Baby> postBaby(@Valid @RequestBody Baby baby){
    String babyId = UUID.randomUUID().toString();
    Baby identifiedBaby = new Baby.BabyBuilder(baby).setId(babyId).build();

    socialNetworkService.createBaby(identifiedBaby);

    return new ResponseEntity<>(identifiedBaby, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  @ResponseBody
  public ResponseEntity<Baby> getBabies(@PathVariable(value = "id") String id){
    return new ResponseEntity<>(socialNetworkService.getBaby(id), HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.DELETE)
  @ResponseBody
  public ResponseEntity<Void> deleteBaby(String id){
    socialNetworkService.deleteBaby(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @ExceptionHandler({BabyExistingException.class})
  public ResponseEntity<Void> handleBabyExistanceException() {
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }
}
