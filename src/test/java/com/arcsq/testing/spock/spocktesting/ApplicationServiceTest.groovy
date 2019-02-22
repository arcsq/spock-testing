package com.arcsq.testing.spock.spocktesting

import spock.lang.Specification
import spock.lang.Unroll

class ApplicationServiceTest extends Specification {

    @Unroll
    def "test if parameter #id and #result"() {
        given:
        ApplicationService service = new ApplicationService();

        expect:
        service.performBusinessFunction(id).equalsIgnoreCase(result);

        where:
        id      | result
        "day"   | "Monday"
        "year"  | "2019"
        "Else"  | "None"
    }

}
