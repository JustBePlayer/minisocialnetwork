package com.ado.fmi.minisocialnetwork.app.controllers;

import com.ado.fmi.minisocialnetwork.app.resources.BabyFriendship;
import com.ado.fmi.minisocialnetwork.app.service.BabySocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "babies/friends", produces = "application/json")
public class FriendsController extends BabyController {

  @Autowired
  private BabySocialNetworkService socialNetworkService;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<BabyFriendship> postBaby(@Valid @RequestBody BabyFriendship friendship){
    String friendshipId = UUID.randomUUID().toString();
    BabyFriendship identifiedFriendship = new BabyFriendship.Builder(friendship).setId(friendshipId).build();

    //socialNetworkService.createBaby(identifiedFriendship);

    return new ResponseEntity<>(identifiedFriendship, HttpStatus.OK);
  }
}
