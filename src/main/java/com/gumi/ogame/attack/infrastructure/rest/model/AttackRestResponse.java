package com.gumi.ogame.attack.infrastructure.rest.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttackRestResponse implements Serializable {

  private static final long serialVersionUID = -4398480926112380224L;

  private Long id;
  private Integer galaxy;
  private Integer solarSystem;
  private Integer position;
}
