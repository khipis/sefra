package com.sefra.testsuite.model;

public class Step {

    private String commandName;
    private String element;
    private String selector;
    private String value;

    public Step(String commandName, String element, String selector, String value) {
        this.commandName = commandName;
        this.element = element;
        this.selector = selector;
        this.value = value;
    }

    public String getCommandName() {
        return commandName;
    }

    public String getElement() {
        return element;
    }


    public String getSelector() {
        return selector;
    }

    public String getValue() {
        return value;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Command{");
        sb.append("commandName='").append(commandName).append('\'');
        sb.append(", element='").append(element).append('\'');
        sb.append(", selector='").append(selector).append('\'');
        sb.append(", value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
