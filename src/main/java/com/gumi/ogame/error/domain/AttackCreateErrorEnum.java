package com.gumi.ogame.error.domain;

import java.util.stream.Stream;

import lombok.Getter;

public enum AttackCreateErrorEnum {

  GALAXY_MANDATORY(AttackCreateErrorConstants.GALAXY_MANDATORY_CODE),
  SOLAR_SYSTEM_MANDATORY(AttackCreateErrorConstants.SOLAR_SYSTEM_MANDATORY_CODE),
  POSITION_MANDATORY(AttackCreateErrorConstants.POSITION_MANDATORY_CODE);

  @Getter
  private final String code;

  AttackCreateErrorEnum(String code){
    this.code = code;
  }

  public static AttackCreateErrorEnum valueOfCode(String code){
    return Stream.of(values()).filter( v -> v.getCode().equals(code)).findFirst().orElse(null);
  }
}
