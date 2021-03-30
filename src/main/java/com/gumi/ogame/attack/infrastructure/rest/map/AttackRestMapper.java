package com.gumi.ogame.attack.infrastructure.rest.map;

import com.gumi.ogame.attack.domain.Attack;
import com.gumi.ogame.attack.infrastructure.rest.model.AttackCreateRestRequest;
import com.gumi.ogame.attack.infrastructure.rest.model.AttackRestResponse;
import com.gumi.ogame.common.infrastructure.rest.map.CommonResponseRestMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AttackRestMapper extends CommonResponseRestMapper<Attack, AttackRestResponse> {

  Attack toDomain(AttackCreateRestRequest source);

}
