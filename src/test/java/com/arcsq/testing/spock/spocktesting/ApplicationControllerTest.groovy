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
        id      | discount
        "GA"    | "Discount 30%"
        "OH"    | "Discount 10%"
        "IL"    | "You don't qualify discount"
    }

    def "testing mocked service" () {
        given:
        ApplicationService mockService = Mock(ApplicationService);
        ApplicationController controller = new ApplicationController(applicationService: mockService);
        mockService.performBusinessFunction("GA") >> "Florida";

        expect:
        controller.checkDiscount("GA").equalsIgnoreCase("You don't qualify discount");
    }

}
