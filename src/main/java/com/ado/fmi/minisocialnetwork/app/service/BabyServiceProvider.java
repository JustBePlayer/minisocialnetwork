package com.ado.fmi.minisocialnetwork.app.service;

import com.ado.fmi.minisocialnetwork.app.exceptions.BabyExistingException;
import com.ado.fmi.minisocialnetwork.app.resources.Baby;
import com.ado.fmi.minisocialnetwork.app.resources.BabyFriendship;
import com.ado.fmi.minisocialnetwork.jooqgen.tables.records.BabyRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.ado.fmi.minisocialnetwork.jooqgen.tables.Baby.BABY;

@Service
@Transactional
public class BabyServiceProvider implements BabySocialNetworkService{

  @Autowired
  private DSLContext dsl;

  @Override
  public List<Baby> getAllBabies() {
    Result<BabyRecord> babyRecords = dsl.selectFrom(BABY).fetch();

    // @formatter:off
    return babyRecords.stream()
        .map(br -> new Baby.BabyBuilder()
          .setId(br.getBabyId())
          .setAge(br.getAge())
          .setFirstName(br.getFirstname())
          .setLastName(br.getLastname())
          .setUserName(br.getUsername())
          .build())
        .collect(Collectors.toList());

    // @formatter:on
  }

  @Override
  public void createBaby(Baby baby) {
    if(isBabyExist(baby)){
      throw new BabyExistingException("baby already exist");
    }

    dsl.insertInto(BABY)
        .set(BABY.BABY_ID, baby.getId())
        .set(BABY.FIRSTNAME, baby.getFirstName())
        .set(BABY.LASTNAME, baby.getLastName())
        .set(BABY.AGE, baby.getAge())
        .set(BABY.USERNAME, baby.getUserName())
        .execute();
  }

  @Override
  public Baby getBaby(String id) {
    BabyRecord babyRecord =  dsl.selectFrom(BABY).where(BABY.BABY_ID.eq(id)).fetchOne();

    // @formatter:off
    return new Baby.BabyBuilder()
        .setId(babyRecord.getBabyId())
        .setAge(babyRecord.getAge())
        .setFirstName(babyRecord.getFirstname())
        .setLastName(babyRecord.getLastname())
        .setUserName(babyRecord.getUsername())
        .build();

    // @formatter:on
  }

  @Override
  public void deleteBaby(String id) {
    dsl.deleteFrom(BABY).where(BABY.BABY_ID.eq(id)).execute();
  }

  private boolean isBabyExist(Baby baby){
    return !dsl.selectFrom(BABY).where(BABY.USERNAME.eq(baby.getUserName())).fetch().isEmpty();
  }

  @Override
  public BabyFriendship requestFriendship(BabyFriendship babyFriendship) {
    return null;
  }

  @Override
  public List<BabyFriendship> getActiveFriendships(String babyId) {
    return null;
  }

  @Override
  public List<BabyFriendship> getNonActiveFriendships(String babyId) {
    return null;
  }

  @Override
  public void activateFriendship(String friendshipId) {

  }

  @Override
  public void deactivateFriendship(String friendshipId) {

  }
}
