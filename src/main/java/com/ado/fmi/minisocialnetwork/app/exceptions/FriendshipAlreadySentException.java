package com.ado.fmi.minisocialnetwork.app.exceptions;

public class FriendshipAlreadySentException extends RuntimeException {
  public FriendshipAlreadySentException(String message){
    super(message);
  }
}
