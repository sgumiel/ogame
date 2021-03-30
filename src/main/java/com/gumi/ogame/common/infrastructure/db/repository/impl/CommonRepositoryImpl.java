package com.gumi.ogame.common.infrastructure.db.repository.impl;

import java.util.List;
import java.util.Optional;

import com.gumi.ogame.common.infrastructure.db.map.CommonDbMapper;
import com.gumi.ogame.common.infrastructure.db.map.CommonIdDbMapper;
import com.gumi.ogame.common.repository.CommonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

@Slf4j
@RequiredArgsConstructor
public abstract class CommonRepositoryImpl<DOMAIN, ID, ENTITY, ENTITY_ID> implements CommonRepository<DOMAIN, ID> {

  private final CrudRepository<ENTITY, ENTITY_ID> repository;
  private final CommonDbMapper<DOMAIN, ENTITY> mapper;
  private final CommonIdDbMapper<ID, ENTITY_ID> idMapper;

  @Override
  public Optional<DOMAIN> findById(ID id) {

    log.debug("Find by id: {}", id);

    final var entityId = this.idMapper.toJpaId(id);
    final var entityOp = this.repository.findById(entityId);
    final var domainOp = entityOp.map(entity->this.mapper.toDomain(entity));
    log.debug("Found: {}", domainOp.isPresent());
    return domainOp;
  }

  @Override
  public List<DOMAIN> findAll() {

    log.debug("Find all");
    final var entities = (List)this.repository.findAll();
    final var domains = this.mapper.toDomain(entities);
    return domains;
  }

  @Override
  public DOMAIN save(DOMAIN domain) {

    log.debug("Save: {}", domain);
    final var entity = this.mapper.toEntity(domain);
    final var entitySaved = this.repository.save(entity);
    final var domainSaved = this.mapper.toDomain(entitySaved);
    log.debug("Saved: {}", domainSaved);
    return domainSaved;
  }
}
