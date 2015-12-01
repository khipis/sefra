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
public class ClickHandler extends Handler {

    public ClickHandler(Handler succesor) {
        super(succesor);
    }

    @Override
    public void handle(CommandData data) throws SefraException {
        By locator = LocatorFactory.createLocator(data);
        data.getDriver().findElement(locator).click();
    }

    @Override
    protected String commandName() {
        return Commands.CLICK;
    }

}
