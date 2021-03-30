package com.gumi.ogame.attack.infrastructure.rest;

import javax.validation.Valid;
import java.util.List;

import com.gumi.ogame.attack.application.service.AttackCreateService;
import com.gumi.ogame.attack.application.service.AttackFindService;
import com.gumi.ogame.attack.infrastructure.rest.map.AttackRestMapper;
import com.gumi.ogame.attack.infrastructure.rest.model.AddAttackRestRequest;
import com.gumi.ogame.attack.infrastructure.rest.model.AttackRestResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/attacks")
public class AttackRestController {

  private final AttackRestMapper attackRestMapper;
  private final AttackCreateService attackCreateService;
  private final AttackFindService attackFindService;


  @GetMapping
  public ResponseEntity<List<AttackRestResponse>> findAll() {

    log.debug("Find all");
    final var attacks = this.attackFindService.findAll();
    log.debug("Attacks found: {}", attacks.size());
    final var response = this.attackRestMapper.toResponse(attacks);
    return ResponseEntity.ok(response);


  }

  @PostMapping
  public ResponseEntity<AttackRestResponse> addAttack(@Valid @RequestBody AddAttackRestRequest addPlanetRequest) {

    final var attack = this.attackRestMapper.toDomain(addPlanetRequest);
    final var attackSaved = this.attackCreateService.createAttack(attack);
    final var attackResponse = this.attackRestMapper.toResponse(attackSaved);
    final Integer  a = 1 +1;
    return ResponseEntity.ok(attackResponse);
  }
}
