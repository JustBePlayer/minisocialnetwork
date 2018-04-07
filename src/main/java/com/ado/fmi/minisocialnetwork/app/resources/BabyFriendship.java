package com.ado.fmi.minisocialnetwork.app.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BabyFriendship {
  private String id;

  private String senderId;
  private String receiverId;
  private boolean isApproved;

  @JsonCreator
  private BabyFriendship(@JsonProperty(value = "senderId", required = true) final String senderId,
      @JsonProperty(value = "receiverId", required = true) final String receiverId) {
    this.senderId = senderId;
    this.receiverId = receiverId;
    this.isApproved = false;
  }

  private BabyFriendship(Builder builder){
    this.id = builder.id;
    this.senderId = builder.senderId;
    this.receiverId = builder.receiverId;
    this.isApproved = builder.isApproved;
  }

  public String getId() {
    return id;
  }

  public String getSenderId() {
    return senderId;
  }

  public String getReceiverId() {
    return receiverId;
  }

  public boolean isApproved() {
    return isApproved;
  }

  public static class Builder{
    private String id;

    private String senderId;
    private String receiverId;
    private boolean isApproved;

    public Builder(String id){
      this.id = id;
    }

    public Builder(BabyFriendship friendship){
      this.id = friendship.id;
      this.senderId = friendship.senderId;
      this.receiverId = friendship.receiverId;
      this.isApproved = friendship.isApproved;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public Builder setSenderId(String senderId) {
      this.senderId = senderId;
      return this;
    }

    public Builder setReceiverId(String receiverId) {
      this.receiverId = receiverId;
      return this;
    }

    public Builder setApproved(boolean approved) {
      isApproved = approved;
      return this;
    }

    public BabyFriendship build(){
      return new BabyFriendship(this);
    }
  }
}
