package com.gumi.ogame.attack.infrastructure.db.repository.impl;

import com.gumi.ogame.attack.domain.Attack;
import com.gumi.ogame.attack.domain.repository.AttackRepository;
import com.gumi.ogame.attack.infrastructure.db.map.AttackDbMapper;
import com.gumi.ogame.attack.infrastructure.db.model.AttackEntity;
import com.gumi.ogame.attack.infrastructure.db.repository.AttackJpaRepository;
import com.gumi.ogame.common.infrastructure.db.map.IdLongDbMapper;
import com.gumi.ogame.common.infrastructure.db.repository.impl.CommonRepositoryImpl;
import org.springframework.stereotype.Component;

@Component
public class AttackRepositoryImpl extends CommonRepositoryImpl<Attack, Long, AttackEntity, Long> implements AttackRepository {

  public AttackRepositoryImpl(
          AttackJpaRepository attackJpaRepository,
          AttackDbMapper attackDbMapper,
          IdLongDbMapper idLongDbMapper) {
    super(attackJpaRepository,attackDbMapper, idLongDbMapper);

  }

}
