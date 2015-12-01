package com.sefra.commands;

import com.sefra.SefraException;

public abstract class Handler implements Chainable {

    private Handler succesor;

    public Handler(Handler succesor) {
        this.succesor = succesor;
    }

    public void tryHandle(CommandData data) throws SefraException {
        if (canHandle(data)) {
            handle(data);
        } else {
            forward(data);
        }
    }


    public Handler getSuccesor() {
        return succesor;
    }

    protected void forward(CommandData data) throws SefraException {
        if (this.succesor != null) {
            this.getSuccesor().tryHandle(data);
        }
    }


    public abstract void handle(CommandData data) throws SefraException;

    protected abstract String commandName();

    boolean canHandle(CommandData data) {
        return commandName().equals(data.getStep().getCommandName());
    }
}