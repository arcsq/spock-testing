package com.arcsq.testing.spock.spocktesting

import spock.lang.Specification
import spock.lang.Unroll

class ApplicationServiceTest extends Specification {

    @Unroll
    def "test if parameter #id and #result"() {
        given:
        ApplicationService service = new ApplicationService();

        expect:
        service.getStateCode(id).equalsIgnoreCase(result);

        where:
        id          | result
        "Georgia"   | "GA"
        "Ohio"      | "OH"
        "Illinois"  | "Other"
    }

}
