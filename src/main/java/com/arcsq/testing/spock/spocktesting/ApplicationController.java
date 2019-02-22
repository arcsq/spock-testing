package com.arcsq.testing.spock.spocktesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @GetMapping("/callService/{id}")
    public String callForService(@PathVariable String id) {
        return applicationService.performBusinessFunction(id);
    }

}
