package com.ado.fmi.minisocialnetwork.app.controllers;

import com.ado.fmi.minisocialnetwork.app.exceptions.FriendshipAlreadyApprovedException;
import com.ado.fmi.minisocialnetwork.app.exceptions.FriendshipAlreadySentException;
import com.ado.fmi.minisocialnetwork.app.resources.BabyFriendship;
import com.ado.fmi.minisocialnetwork.app.service.BabySocialNetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping(path = "/friendship", produces = "application/json")
public class FriendsController {

  @Autowired
  private BabySocialNetworkService socialNetworkService;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseBody
  public ResponseEntity<BabyFriendship> postBaby(@Valid @RequestBody BabyFriendship friendship){
    String friendshipId = UUID.randomUUID().toString();
    BabyFriendship identifiedFriendship = new BabyFriendship.Builder(friendship).setId(friendshipId).build();

    BabyFriendship responseFriendship = socialNetworkService.requestFriendship(identifiedFriendship);

    return new ResponseEntity<>(responseFriendship, HttpStatus.OK);
  }

  @ExceptionHandler({FriendshipAlreadyApprovedException.class, FriendshipAlreadySentException.class})
  public ResponseEntity<Void> handleFriendshipExceptions() {
    return new ResponseEntity<>(HttpStatus.CONFLICT);
  }
}
