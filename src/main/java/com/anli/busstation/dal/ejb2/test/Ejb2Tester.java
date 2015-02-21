package com.anli.busstation.dal.ejb2.test;

import com.anli.busstation.dal.test.servlet.AbstractTester;

public class Ejb2Tester extends AbstractTester {

    @Override
    protected String getBasePackage() {
        return "com.anli.busstation.dal.ejb2.test";
    }

    @Override
    protected String getExecutorUrl() {
        return "/executor";
    }

    @Override
    protected String getTitle() {
        return "Bus Station Data Access Integration Tests (SqlEjb2 implementation)";
    }

}
