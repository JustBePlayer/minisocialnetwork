package com.ado.fmi.minisocialnetwork.app.service;

import com.ado.fmi.minisocialnetwork.app.resources.Baby;

import java.util.List;

public interface BabyManagementService {
  public List<Baby> getAllBabies();

  public void createBaby(Baby baby);

  public Baby getBaby(String id);

  public void deleteBaby(String id);
}
