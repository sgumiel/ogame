package com.gumi.ogame.common.infrastructure.db.map;

import java.util.List;

public interface CommonIdDbMapper<DOMAIN_ID, ENTITY_ID> {

  ENTITY_ID toJpaId(DOMAIN_ID source);

  List<ENTITY_ID> toJpaId(List<DOMAIN_ID> source);

  DOMAIN_ID toDomainId(ENTITY_ID source);

  List<DOMAIN_ID> toDomainId(List<ENTITY_ID> source);
}
