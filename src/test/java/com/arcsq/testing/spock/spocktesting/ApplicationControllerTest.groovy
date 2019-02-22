package com.arcsq.testing.spock.spocktesting

import spock.lang.Specification

class ApplicationControllerTest extends Specification {

    def "maximum of two"() {
        expect:
            Math.max(1, 3) == 1
    }

}
