package com.arcsq.testing.spock.spocktesting

import spock.lang.Specification
import spock.lang.Unroll

class ApplicationControllerTest extends Specification {

    @Unroll
    def "test state #id and resulting discount #discount "() {
        given:
        ApplicationController controller = new ApplicationController(applicationService: new ApplicationService());

        expect:
        controller.checkDiscount(id).equalsIgnoreCase(discount);

        where:
        id          | discount
        "Georgia"   | "Discount 30%"
        "Ohio"      | "Discount 10%"
        "Illinois"  | "You don't qualify discount"
    }

    @Unroll
    def "testing mocked service with #state resulting #qualification" () {
        given:
        ApplicationService mockService = Spy(ApplicationService);
        ApplicationController controller = new ApplicationController(applicationService: mockService);
        mockService.getCurrenntState() >> state;

        expect:
        controller.checkAddressQualification() == qualification;

        where:
        state   | qualification
        "GA"    | true
        "FL"    | false
    }

}
