package com.sefra.testsuite;

import com.google.common.base.Preconditions;

import com.sefra.SefraException;
import com.sefra.commands.CommandData;
import com.sefra.commands.Handler;
import com.sefra.commands.handlers.ClickHandler;
import com.sefra.commands.handlers.DefaultHandler;
import com.sefra.commands.handlers.OpenHandler;
import com.sefra.commands.handlers.TypeHandler;
import com.sefra.elements.ElementsRepository;
import com.sefra.testsuite.model.Case;
import com.sefra.testsuite.model.Step;
import com.sefra.testsuite.model.Suite;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class SuiteRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuiteRunner.class);

    private WebDriver driver;
    private Suite testSuite;

    private Handler chain;

    public SuiteRunner(WebDriver driver, Suite testSuite) {
        this.driver = driver;
        this.testSuite = testSuite;
    }

    public void runSuite() throws SefraException {
        Preconditions.checkNotNull(driver);
        Preconditions.checkNotNull(testSuite);

        Properties elements = prepareElements();

        chain = prepareChain();

        for (Case testCase : testSuite.getTestCases()) {
            for (Step command : testCase.getCommands()) {
                CommandData commandData = new CommandData(driver, elements, command);
                chain.tryHandle(commandData);
            }
        }
    }

    private Properties prepareElements() throws SefraException {
        ElementsRepository repository = new ElementsRepository("elements.properties");
        return repository.getElements();
    }

    private Handler prepareChain() {
        return new ClickHandler(
                new OpenHandler(
                        new TypeHandler(
                                new DefaultHandler(null))));
    }

}