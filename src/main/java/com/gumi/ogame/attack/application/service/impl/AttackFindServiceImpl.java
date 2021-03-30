package com.gumi.ogame.attack.application.service.impl;

import java.util.List;
import java.util.Optional;

import com.gumi.ogame.attack.application.service.AttackFindService;
import com.gumi.ogame.attack.domain.Attack;
import com.gumi.ogame.attack.domain.repository.AttackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttackFindServiceImpl implements AttackFindService {

  private final AttackRepository attackRepository;

  @Override
  public Optional<Attack> findById(Long id) {
    return attackRepository.findById(id);
  }

  @Override
  public List<Attack> findAll() {
    return this.attackRepository.findAll();

  }
}
