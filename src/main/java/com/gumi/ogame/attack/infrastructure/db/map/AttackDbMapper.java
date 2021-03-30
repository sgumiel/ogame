package com.gumi.ogame.attack.infrastructure.db.map;

import com.gumi.ogame.attack.domain.Attack;
import com.gumi.ogame.attack.infrastructure.db.model.AttackEntity;
import com.gumi.ogame.common.infrastructure.db.map.CommonDbMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttackDbMapper extends CommonDbMapper<Attack, AttackEntity> {

}