package com.arcsq.testing.spock.spocktesting

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class ApplicationServiceTest extends Specification {

    @Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    def setupSpec() {
        sql.execute("create table test (id int primary key)");
    }

    @Unroll
    def "test if parameter #id and #result"() {
        given:
        ApplicationService service = new ApplicationService();

        expect:
        service.getStateCode(id).equalsIgnoreCase(result);

        where:
        id          | result
        "Georgia"   | "GA"
        "Ohio"      | "OH"
        "Illinois"  | "Other"
    }

}
