package com.ado.fmi.minisocialnetwork.app.exceptions;

public class FriendshipAlreadyApprovedException extends RuntimeException {
  public FriendshipAlreadyApprovedException(String message){
    super(message);
  }
}
