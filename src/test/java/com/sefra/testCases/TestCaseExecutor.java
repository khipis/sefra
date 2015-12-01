package com.sefra.testCases;

import com.sefra.testsuite.SuiteBuilder;
import com.sefra.testsuite.SuiteRunner;
import com.sefra.testsuite.SuiteRunnerBuilder;
import com.sefra.testsuite.model.Suite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;



public class TestCaseExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestCaseExecutor.class);


    @Test(enabled = true)
    public void testLogin() throws Exception {

        WebDriver webDriver = new FirefoxDriver();

        Suite testSuite = SuiteBuilder.get().fromExcel("TestSuite.xlsx", "Suite 1").create();

        SuiteRunner testSuiteRunner =
                SuiteRunnerBuilder.get().testSuite(testSuite).driver(webDriver).create();

        testSuiteRunner.runSuite();


    }

}
