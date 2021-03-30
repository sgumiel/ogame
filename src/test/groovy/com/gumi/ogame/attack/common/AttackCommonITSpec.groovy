package com.gumi.ogame.attack.common

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.gumi.ogame.OgameApplication
import com.gumi.ogame.attack.infrastructure.rest.model.AttackCreateRestRequest
import com.gumi.ogame.attack.infrastructure.rest.model.AttackRestResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Shared
import spock.lang.Specification
import uk.co.jemos.podam.api.PodamFactoryImpl

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post

@ActiveProfiles("test")
@SpringBootTest(classes = OgameApplication.class)
@AutoConfigureMockMvc
class AttackCommonITSpec extends Specification {

    protected static final ATTACK_URL = "/attacks"

    @Autowired
    protected MockMvc mvc

    @Shared
    def podam = new PodamFactoryImpl()

    @Autowired
    protected ObjectMapper objectMapper

    AttackRestResponse createAttack(AttackCreateRestRequest attackCreateRestRequest) {

        def bodyString = objectMapper.writeValueAsString(attackCreateRestRequest)
        def mvcRequest = post(ATTACK_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(bodyString)
        def response = mvc.perform(mvcRequest).andReturn().response


        def attackRestResponse = objectMapper.readValue(response.contentAsString, new TypeReference<AttackRestResponse>() {})
        return attackRestResponse

    }
}
