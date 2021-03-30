package com.gumi.ogame.common.infrastructure.db.map;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IdLongDbMapper extends CommonIdDbMapper<Long, Long>{

  @Override
  default Long toJpaId(Long source) { return source; }

  @Override
  default List<Long> toJpaId(List<Long> source) { return source; }

  @Override
  default
  Long toDomainId(Long source) { return source; }

  @Override
  default
  List<Long> toDomainId(List<Long> source) { return source; }
}
