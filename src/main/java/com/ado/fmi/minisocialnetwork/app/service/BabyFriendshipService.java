package com.ado.fmi.minisocialnetwork.app.service;

import com.ado.fmi.minisocialnetwork.app.resources.BabyFriendship;

import java.util.List;

public interface BabyFriendshipService {
  public BabyFriendship requestFriendship(BabyFriendship babyFriendship);

  public List<BabyFriendship> getActiveFriendships(String babyId);

  public List<BabyFriendship> getNonActiveFriendships(String babyId);

  public void activateFriendship(String friendshipId);

  public void deactivateFriendship(String friendshipId);
}
