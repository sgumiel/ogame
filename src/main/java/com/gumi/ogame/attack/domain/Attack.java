package com.gumi.ogame.attack.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attack {

  private Long id;
  private Integer galaxy;
  private Integer solarSystem;
  private Integer position;

}