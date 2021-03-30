package com.gumi.ogame

import com.gumi.ogame.attack.infrastructure.rest.AttackRestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

@ActiveProfiles("test")
@SpringBootTest
class LoadContextTest extends Specification {

    @Autowired (required = false)
    private AttackRestController attackRestController

    def "when context is loaded then all expected beans are created"() {
        expect: "the AttackRestController is created"
        attackRestController
    }
}