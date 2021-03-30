package com.gumi.ogame.error.application.factory.impl;

import com.gumi.ogame.error.application.factory.ApiErrorFactory;
import com.gumi.ogame.error.domain.ApiError;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApiErrorFactoryImpl implements ApiErrorFactory {

  private final MessageSource messageSource;

  @Override
  public ApiError createApiError(String code) {

    final var preCode = code.toLowerCase().replace("_", ".");
    final var message = this.messageSource.getMessage(preCode+".message", null, LocaleContextHolder.getLocale());
    final var description = this.messageSource.getMessage(preCode+".description", null, LocaleContextHolder.getLocale());

    return ApiError.builder()
            .code(code).message(message).description(description)
            .build();
  }
}
