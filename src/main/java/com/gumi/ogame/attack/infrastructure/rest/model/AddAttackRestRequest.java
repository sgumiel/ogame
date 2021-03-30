package com.gumi.ogame.attack.infrastructure.rest.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

import com.gumi.ogame.error.domain.AttackCreateErrorConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddAttackRestRequest implements Serializable {

  private static final long serialVersionUID = 5912471420492702493L;

  @NotNull(message = AttackCreateErrorConstants.GALAXY_MANDATORY_CODE)
  private Integer galaxy;

  @NotNull(message = AttackCreateErrorConstants.SOLAR_SYSTEM_MANDATORY_CODE)
  private Integer solarSystem;

  @NotNull(message = AttackCreateErrorConstants.POSITION_MANDATORY_CODE)
  private Integer position;

}
