package com.gumi.ogame.attack

import com.fasterxml.jackson.core.type.TypeReference
import com.gumi.ogame.attack.common.AttackCommonITSpec
import com.gumi.ogame.attack.infrastructure.rest.model.AttackCreateRestRequest
import com.gumi.ogame.error.domain.AttackCreateErrorConstants
import com.gumi.ogame.error.infrastructure.rest.model.ApiErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

class AttackCreateITSpec extends AttackCommonITSpec {

    def "Test create an attack " () {

        given: "A valid attack create request"
        def attackCreateRequest = this.podam.manufacturePojo(AttackCreateRestRequest.class)

        when:
        def attackRestResponse = this.createAttack(attackCreateRequest)

        then:
        attackRestResponse != null
        attackRestResponse.galaxy == attackCreateRequest.galaxy
        attackRestResponse.solarSystem == attackCreateRequest.solarSystem
        attackRestResponse.position == attackCreateRequest.position
    }

    def "Test create an attack when mandatory data is null " () {

        given: "An invalid attack create request with a mandatory field null"
        def attackCreateRequest = AttackCreateRestRequest.builder().build()
        def bodyString = objectMapper.writeValueAsString(attackCreateRequest)

        when: "create an attack"
        def mvcRequest = post(ATTACK_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(bodyString)
        def response = mvc.perform(mvcRequest).andReturn().response

        then: "The status code must be bad request"
        response.status == HttpStatus.BAD_REQUEST.value()

        and: "There must be 3 errors"
        def apiErrors = objectMapper.readValue(response.contentAsString, new TypeReference<List<ApiErrorResponse>>() {})
        apiErrors.size() == 3

        and: "There must be and error GALAXY_MANDATORY_CODE"
        def apiErrorGalaxyMandatoryOp = apiErrors.stream().filter({ e -> e.getCode().equals(AttackCreateErrorConstants.GALAXY_MANDATORY_CODE)}).findFirst()
        apiErrorGalaxyMandatoryOp.isPresent() == true

        and: "There must be and error SOLAR_SYSTEM_MANDATORY_CODE"
        def apiErrorSolarSystemOp = apiErrors.stream().filter({ e -> e.getCode().equals(AttackCreateErrorConstants.SOLAR_SYSTEM_MANDATORY_CODE)}).findFirst()
        apiErrorSolarSystemOp.isPresent() == true

        and: "There must be and error POSITION_MANDATORY_CODE"
        def apiErrorPositionOp = apiErrors.stream().filter({ e -> e.getCode().equals(AttackCreateErrorConstants.POSITION_MANDATORY_CODE)}).findFirst()
        apiErrorPositionOp.isPresent() == true

    }
}
