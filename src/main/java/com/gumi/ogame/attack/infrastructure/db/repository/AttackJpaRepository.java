package com.gumi.ogame.attack.infrastructure.db.repository;

import com.gumi.ogame.attack.infrastructure.db.model.AttackEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttackJpaRepository extends CrudRepository<AttackEntity, Long> {
}
