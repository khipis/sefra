package com.sefra.commands;

import com.sefra.testsuite.model.Step;

import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * Class CommandConfiguration
 *
 * @author Krzysztof Korolczuk {@literal <krzysztofkorolczuk2@gmail.com>}
 */
public class CommandData {

    private WebDriver driver;
    private Properties elements;
    private Step step;

    public CommandData(WebDriver driver, Properties elements, Step step) {
        this.driver = driver;
        this.elements = elements;
        this.step = step;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Properties getElements() {
        return elements;
    }


    public Step getStep() {
        return step;
    }

}
