package com.arcsq.testing.spock.spocktesting

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class StateServiceTest extends Specification {

    @Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    def setupSpec() {
        println "Setting up db";
        sql.execute("create table test (id int primary key)");
    }

    @Unroll
    def "if state name is #id the return code is #result"() {
        given:
        StateService service = new StateService();

        expect:
        service.getStateCode(id).equalsIgnoreCase(result);

        where:
        id          | result
        "Georgia"   | "GA"
        "Ohio"      | "OH"
        "Illinois"  | "Other"
        "Kentucky"  | "KY"
        "else"  | "Other"
    }

    @Unroll
    def "CSV-data-provided if state name is #id the return code is #result"() {
        given:
        StateService service = new StateService();

        expect:
        service.getStateCode(id).equalsIgnoreCase(result);

        where:
        [id, result] << new CsvProvider("state-data.csv").provide();
    }

    def "Throwing NullPointerException"() {
        setup:
        ApplicationController controller;

        when:
        controller.checkAddressQualification();

        then:
        thrown NullPointerException;
    }

}
