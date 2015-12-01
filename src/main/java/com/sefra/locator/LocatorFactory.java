package com.sefra.locator;

import com.google.common.base.Preconditions;

import com.sefra.SefraException;
import com.sefra.commands.CommandData;
import com.sefra.testsuite.model.Step;

import org.openqa.selenium.By;

import java.lang.reflect.Method;

public class LocatorFactory {

    private LocatorFactory() {

    }

    public static final By createLocator(CommandData commandData) throws SefraException {

        Preconditions.checkNotNull(commandData);

        Step step = commandData.getStep();

        String elementName = commandData.getElements().getProperty(step.getElement());

        try {

            LocatorTypes locator = LocatorTypes.CACHE_BY_TYPE.get(step.getSelector().toLowerCase());
            Method method = By.class.getMethod(locator.getType(), String.class);

            return (By) method.invoke(locator.getType(), elementName);
        } catch (Exception e) {
            throw new SefraException(
                    "Cannot create locator from selector:" + step.getSelector() + " element:" + step
                            .getElement());
        }

    }
}

