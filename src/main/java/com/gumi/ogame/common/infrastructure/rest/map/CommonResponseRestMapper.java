package com.gumi.ogame.common.infrastructure.rest.map;

import java.util.List;

public interface CommonResponseRestMapper<DOMAIN, RESPONSE> {

  RESPONSE toResponse(DOMAIN source);
  List<RESPONSE> toResponse(List<DOMAIN> source);
}
