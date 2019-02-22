package com.arcsq.testing.spock.spocktesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/check-discount/{id}")
    public String checkDiscount(@PathVariable String id) {
        String stateName = applicationService.performBusinessFunction(id);
        if ("Georgia".equals(stateName)) {
            return "Discount 30%";
        }
        else if ("Ohio".equals(stateName)) {
            return "Discount 10%";
        }
        else {
            return "You don't qualify discount";
        }
    }

}
