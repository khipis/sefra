package com.sefra.commands.handlers;

import com.sefra.SefraException;
import com.sefra.commands.CommandData;
import com.sefra.commands.Commands;
import com.sefra.commands.Handler;

public class OpenHandler extends Handler {

    public OpenHandler(Handler succcesor) {
        super(succcesor);
    }

    @Override
    public void handle(CommandData data) throws SefraException {
        data.getDriver().get(data.getElements().getProperty(data.getStep().getValue()));
    }

    @Override
    protected String commandName() {
        return Commands.OPEN;
    }

}
