package com.gumi.ogame.attack.application.service;

import java.util.List;
import java.util.Optional;

import com.gumi.ogame.attack.domain.Attack;

public interface AttackFindService {

  Optional<Attack> findById(Long id);
  List<Attack> findAll();
}
