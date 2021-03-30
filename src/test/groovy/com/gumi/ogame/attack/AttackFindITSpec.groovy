package com.gumi.ogame.attack

import com.fasterxml.jackson.core.type.TypeReference
import com.gumi.ogame.attack.common.AttackCommonITSpec
import com.gumi.ogame.attack.infrastructure.rest.model.AttackCreateRestRequest
import com.gumi.ogame.attack.infrastructure.rest.model.AttackRestResponse
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class AttackFindITSpec extends AttackCommonITSpec {

    def "Test find by id when not found"() {

        given: "An id that not exist"
        def attackCreateRequest = this.podam.manufacturePojo(AttackCreateRestRequest.class)
        def attackRestResponse = this.createAttack(attackCreateRequest)
        def id = attackRestResponse.getId() + 1

        when:
        def mvcRequest = get(ATTACK_URL + "/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
        def response = mvc.perform(mvcRequest).andReturn().response


        then:
        response != null
        response.status == HttpStatus.NOT_FOUND.value()
    }

    def "Test find by id when exists"() {

        given: "An id that exist"
        def attackCreateRequest = this.podam.manufacturePojo(AttackCreateRestRequest.class)
        def attackRestResponse = this.createAttack(attackCreateRequest)
        def id = attackRestResponse.getId()

        when:
        def mvcRequest = get(ATTACK_URL + "/" + id)
                .accept(MediaType.APPLICATION_JSON)
        def response = mvc.perform(mvcRequest).andReturn().response


        then:
        response != null
        response.status == HttpStatus.OK.value()

        and:
        def arr = objectMapper.readValue(response.contentAsString, new TypeReference<AttackRestResponse>() {})
        arr.getId() == attackRestResponse.getId()
    }

    def "Test find all"() {

        given: "create an attack"
        def attackCreateRequest = this.podam.manufacturePojo(AttackCreateRestRequest.class)
        def attackRestResponse = this.createAttack(attackCreateRequest)

        when: "get all"
        def mvcRequest = get(ATTACK_URL)
                .accept(MediaType.APPLICATION_JSON)
        def response = mvc.perform(mvcRequest).andReturn().response


        then: "Response status must be OK"
        response != null
        response.status == HttpStatus.OK.value()

        and: "At least must be 1 attack"
        def attacks = objectMapper.readValue(response.contentAsString, new TypeReference<List<AttackRestResponse>>() {})
        attacks.size() >= 1
    }
}
