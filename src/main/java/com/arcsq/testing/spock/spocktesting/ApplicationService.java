package com.arcsq.testing.spock.spocktesting;

import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    public String performBusinessFunction(String id) {
        if ("day".equals(id)) {
            return "Monday";
        }
        else if ("year".equals(id)) {
            return "2019";
        }
        return "None";
    }

}
