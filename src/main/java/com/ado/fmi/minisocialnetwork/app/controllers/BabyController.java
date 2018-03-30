package com.ado.fmi.minisocialnetwork.app.controllers;

import com.ado.fmi.minisocialnetwork.app.resources.Baby;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/baby", produces = "application/json")
public class BabyController {

  @RequestMapping(method = RequestMethod.GET)
  @ResponseBody
  public ResponseEntity<List<Baby>> getBabies(){
    //TODO: add implementation
    return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
  }
}
