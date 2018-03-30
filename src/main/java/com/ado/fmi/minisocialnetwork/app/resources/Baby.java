package com.ado.fmi.minisocialnetwork.app.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Baby {
  private String id;
  private String firstName;
  private String lastName;
  private int age;
  private String userName;

  @JsonCreator public Baby(@JsonProperty("id") final String id, @JsonProperty("userName") final String userName,
      @JsonProperty("firstName") final String firstName, @JsonProperty("lastName") final String lastName, @JsonProperty("age") final int age) {
    this.userName = userName;
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
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
}
