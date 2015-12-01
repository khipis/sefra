package com.sefra.commands.handlers;

import com.sefra.SefraException;
import com.sefra.commands.CommandData;
import com.sefra.commands.Handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class ClickCommand
 *
 * @author Krzysztof Korolczuk {@literal <krzysztofkorolczuk2@gmail.com>}
 */
public class DefaultHandler extends Handler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHandler.class);

    public DefaultHandler(Handler succesor) {
        super(succesor);
    }

    @Override
    public void handle(CommandData data) throws SefraException {
       throw new SefraException("Cannot handle step: " + data);
    }

    @Override
    protected String commandName() {
        return "";
    }

}
