package com.gumi.ogame.common.repository;

import java.util.List;
import java.util.Optional;

public interface CommonRepository<DOMAIN, ID> {

  List<DOMAIN> findAll();
  DOMAIN save(DOMAIN domain);
  Optional<DOMAIN> findById(ID id);
}
