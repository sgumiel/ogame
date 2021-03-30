package com.gumi.ogame.attack.application.service.impl;

import com.gumi.ogame.attack.application.service.AttackCreateService;
import com.gumi.ogame.attack.domain.Attack;
import com.gumi.ogame.attack.domain.repository.AttackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AttackCreateServiceImpl implements AttackCreateService {

  private final AttackRepository attackRepository;

  @Override
  public Attack createAttack(Attack attack) {
    return this.attackRepository.save(attack);
  }
}
