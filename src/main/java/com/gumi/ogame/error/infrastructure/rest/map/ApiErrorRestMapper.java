package com.gumi.ogame.error.infrastructure.rest.map;

import java.util.List;

import com.gumi.ogame.error.domain.ApiError;
import com.gumi.ogame.error.infrastructure.rest.model.ApiErrorResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApiErrorRestMapper {

  ApiErrorResponse toResponse(ApiError source);

  List<ApiErrorResponse> toResponse(List<ApiError> source);
}
