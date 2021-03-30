package com.gumi.ogame.common.infrastructure.db.map;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IdIntegerDbMapper extends CommonIdDbMapper<Integer, Integer> {

  @Override
  default Integer toJpaId(Integer source) { return source; }

  @Override
  default
  List<Integer> toJpaId(List<Integer> source) { return source; }

  @Override
  default
  Integer toDomainId(Integer source) { return source; }

  @Override
  default
  List<Integer> toDomainId(List<Integer> source) { return source; }
}
