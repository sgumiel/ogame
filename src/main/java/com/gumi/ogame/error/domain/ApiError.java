package com.gumi.ogame.error.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiError {

  private String code;
  private String message;
  private String description;
}
