package com.arcsq.testing.spock.spocktesting;

import org.springframework.stereotype.Service;

@Service
public class StateService {

    public String getStateCode(String id) {
        if ("Georgia".equals(id)) {
            return "GA";
        }
        else if ("Ohio".equals(id)) {
            return "OH";
        }
        else if ("Kentucky".equals(id)) {
            return "KY";
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
