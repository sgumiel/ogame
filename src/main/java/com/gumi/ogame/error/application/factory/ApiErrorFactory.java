package com.gumi.ogame.error.application.factory;

import com.gumi.ogame.error.domain.ApiError;

public interface ApiErrorFactory {

  ApiError createApiError(String code);
}
