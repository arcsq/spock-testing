package com.arcsq.testing.spock.spocktesting;

import org.springframework.stereotype.Service;

@Service
public class ApplicationService {

    public String getStateCode(String id) {
        if ("Georgia".equals(id)) {
            return "GA";
        }
        else if ("Ohio".equals(id)) {
            return "OH";
        }
        return "Other";
    }

    public String getCurrenntState() {
        return "GA";
    }

    protected String getProtectedCity() {
        return "Cumming";
    }

    private String getPrivateZipcode() {
        return "30040";
    }

}
