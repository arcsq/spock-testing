package com.arcsq.testing.spock.spocktesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {

    @Autowired
    StateService stateService;

    @GetMapping("/check-discount/{id}")
    public String checkDiscount(@PathVariable String id) {
        String stateName = stateService.getStateCode(id);
        if ("GA".equals(stateName)) {
            return "Discount 30%";
        }
        else if ("OH".equals(stateName)) {
            return "Discount 10%";
        }
        else {
            return "You don't qualify discount";
        }
    }

    public boolean checkAddressQualification() {
        if (stateService.getCurrenntState().equals("GA")) {
            if (stateService.getProtectedCity().equals("Cumming")) {
                return true;
            }
        }
        return false;
    }

}
