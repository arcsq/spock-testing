package com.arcsq.testing.spock.spocktesting;

import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    public String performBusinessFunction(String id) {
        if ("GA".equals(id)) {
            return "Georgia";
        }
        else if ("OH".equals(id)) {
            return "Ohio";
        }
        return "Other";
    }

}
