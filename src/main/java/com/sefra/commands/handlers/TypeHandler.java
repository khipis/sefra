package com.sefra.commands.handlers;

import com.sefra.SefraException;
import com.sefra.commands.CommandData;
import com.sefra.commands.Commands;
import com.sefra.commands.Handler;
import com.sefra.locator.LocatorFactory;

import org.openqa.selenium.By;

/**
 * Class ClickCommand
 *
 * @author Krzysztof Korolczuk {@literal <krzysztofkorolczuk2@gmail.com>}
 */
public class TypeHandler extends Handler {


    public TypeHandler(Handler succcesor) {
        super(succcesor);
    }

    @Override
    public void handle(CommandData data) throws SefraException {
        By locator = LocatorFactory.createLocator(data);
        data.getDriver().findElement(locator).sendKeys(data.getStep().getValue());
    }

    @Override
    protected String commandName() {
        return Commands.TYPE;
    }

}
