package com.sefra.testsuite.model;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Suite {

    private Deque<Case> testCases = new LinkedList<>();

    public Suite(Deque<Case> testCases) {
        this.testCases = testCases;
    }

    public Queue<Case> getTestCases() {
        return testCases;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TestSuite{");
        sb.append("testCases=").append(testCases);
        sb.append('}');
        return sb.toString();
    }
}
