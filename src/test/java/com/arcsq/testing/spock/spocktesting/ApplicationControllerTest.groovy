package com.arcsq.testing.spock.spocktesting

import spock.lang.Specification
import spock.lang.Unroll

class ApplicationControllerTest extends Specification {

    @Unroll
    def "For state #id the resulting discount is #discount "() {
        given:
        ApplicationController controller = new ApplicationController(stateService: new StateService());

        expect:
        controller.checkDiscount(id).equalsIgnoreCase(discount);

        where:
        id          | discount
        "Georgia"   | "Discount 30%"
        "Ohio"      | "Discount 10%"
        "Illinois"  | "You don't qualify discount"
    }

    @Unroll
    def "For mocked getCurrentState to return #state, resulting address qualification is #qualification" () {
        given:
        StateService mockService = Spy(StateService);
        mockService.getCurrenntState() >> state;
        ApplicationController controller = new ApplicationController(stateService: mockService);

        expect:
        controller.checkAddressQualification() == qualification;

        where:
        state   | qualification
        "GA"    | true
        "FL"    | false
    }

}
