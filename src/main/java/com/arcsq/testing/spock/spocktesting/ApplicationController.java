package com.arcsq.testing.spock.spocktesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/check-discount/{id}")
    public String checkDiscount(@PathVariable String id) {
        String stateName = applicationService.getStateCode(id);
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
        if (applicationService.getCurrenntState().equals("GA")) {
            if (applicationService.getProtectedCity().equals("Cumming")) {
                if (getPrivateAddress().equals("Shiloh Farms")) {
                    return true;
                }
            }
        }
        return false;
    }

    private String getPrivateAddress() {
        return "Shiloh Farms";
    }

}
