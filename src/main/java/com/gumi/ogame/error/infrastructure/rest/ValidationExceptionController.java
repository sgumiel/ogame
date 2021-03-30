package com.gumi.ogame.error.infrastructure.rest;

import java.util.List;
import java.util.stream.Collectors;

import com.gumi.ogame.error.application.factory.ApiErrorFactory;
import com.gumi.ogame.error.infrastructure.rest.map.ApiErrorRestMapper;
import com.gumi.ogame.error.infrastructure.rest.model.ApiErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class ValidationExceptionController {

  private final ApiErrorFactory apiErrorFactory;
  private final ApiErrorRestMapper apiErrorRestMapper;

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ApiErrorResponse>> validationError(MethodArgumentNotValidException exception) {

    final var codes = exception.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());

    final var apiErrorList = codes.stream().map(code -> apiErrorFactory.createApiError(code)).collect(Collectors.toList());

    final var apiErrorResponseList = this.apiErrorRestMapper.toResponse(apiErrorList);

    return ResponseEntity.badRequest().body(apiErrorResponseList);


  }
}
