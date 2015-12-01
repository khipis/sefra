package com.sefra.testsuite.model;


import java.util.ArrayList;
import java.util.List;

public class Case {

    private String name;

    private List<Step> commands;

    public Case(String name) {
        this.name = name;
        this.commands = new ArrayList<>();
    }


    public List<Step> getCommands() {
        return commands;
    }

    public void addCommand(Step command) {
        commands.add(command);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestCase{");
        sb.append("name='").append(name).append('\'');
        sb.append(", commands=").append(commands);
        sb.append('}');
        return sb.toString();
    }
}
