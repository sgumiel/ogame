package com.gumi.ogame.common.infrastructure.db.map;

import java.util.List;

public interface CommonDbMapper<DOMAIN, ENTITY> {

  ENTITY toEntity(DOMAIN source);
  List<ENTITY> toEntity(List<DOMAIN> source);
  DOMAIN toDomain(ENTITY source);
  List<DOMAIN> toDomain(List<ENTITY> source);
}
