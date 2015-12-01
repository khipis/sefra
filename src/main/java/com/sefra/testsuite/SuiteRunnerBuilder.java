package com.sefra.testsuite;

import com.sefra.testsuite.model.Suite;

import org.openqa.selenium.WebDriver;

public class SuiteRunnerBuilder {

    private WebDriver driver;
    private Suite testSuite;

    private SuiteRunnerBuilder() {
    }

    public SuiteRunnerBuilder driver(WebDriver driver) {
        this.driver = driver;
        return this;
    }

    public static SuiteRunnerBuilder get() {
        return new SuiteRunnerBuilder();
    }

    public SuiteRunnerBuilder testSuite(Suite testSuite) {
        this.testSuite = testSuite;
        return this;
    }

    public SuiteRunner create() {
        return new SuiteRunner(driver, testSuite);
    }
}