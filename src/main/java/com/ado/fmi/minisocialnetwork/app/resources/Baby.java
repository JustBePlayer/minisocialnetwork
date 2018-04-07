package com.ado.fmi.minisocialnetwork.app.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Baby {
  private String id;

  private String firstName;
  private String lastName;
  private int age;
  private String userName;

  @JsonCreator
  private Baby(@JsonProperty("id") final String id, @JsonProperty("userName") final String userName,
      @JsonProperty("firstName") final String firstName, @JsonProperty("lastName") final String lastName, @JsonProperty("age") final int age) {
    this.userName = userName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  private Baby(BabyBuilder builder){
    this.id = builder.id;
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.age = builder.age;
    this.userName = builder.userName;
  }

  public String getId(){
    return id;
  }
  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public int getAge() {
    return age;
  }

  public String getUserName() {
    return userName;
  }

  public static class BabyBuilder{
    private String id;

    private String firstName;
    private String lastName;
    private int age;
    private String userName;

    public BabyBuilder(){

    }

    public BabyBuilder(Baby baby){
      this.id = baby.id;
      this.firstName = baby.firstName;
      this.lastName = baby.lastName;
      this.age = baby.age;
      this.userName = baby.userName;
    }

    public BabyBuilder setId(String id) {
      this.id = id;
      return this;
    }

    public BabyBuilder setFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public BabyBuilder setLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public BabyBuilder setAge(int age) {
      this.age = age;
      return this;
    }

    public BabyBuilder setUserName(String userName) {
      this.userName = userName;
      return this;
    }

    public Baby build(){
      return new Baby(this);
    }
  }

}
