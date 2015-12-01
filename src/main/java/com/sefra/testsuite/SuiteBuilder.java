package com.sefra.testsuite;

import com.sefra.SefraException;
import com.sefra.testsuite.model.Case;
import com.sefra.testsuite.model.Step;
import com.sefra.testsuite.model.Suite;
import com.sefra.utils.ExcelUtil;
import com.sefra.utils.ResourceUtil;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.util.Deque;
import java.util.LinkedList;


public class SuiteBuilder {

    private Deque<Case> testCases;

    private SuiteBuilder() {

    }

    public static SuiteBuilder get() {
        return new SuiteBuilder();
    }

    public SuiteBuilder fromExcel(String filePath, String sheetName) throws SefraException {

        File file = ResourceUtil.loadFileFromResources(filePath);

        if(!file.exists()){
            throw new SefraException("File " + file.getPath() + " | " + file.getAbsolutePath() + " | ");
        }

        String realPath = file.getPath();

        Sheet sheet = ExcelUtil.readExcel(realPath, sheetName);

        testCases = new LinkedList<>();

        for (int i = 1; i <= ExcelUtil.getRowCount(sheet); i++) {

            Row row = sheet.getRow(i);

            if (ExcelUtil.isTestCaseName(row)) {
                testCases.add(new Case(ExcelUtil.getTestCaseName(row)));
            } else {
                testCases.getLast().addCommand(createCommand(row));
            }

        }

        return this;
    }

    private Step createCommand(Row row) {
        return new Step(ExcelUtil.getCommandCell(row), ExcelUtil.getElementCell(row),
                        ExcelUtil.getSelectorCell(row), ExcelUtil.getValueCell(row));
    }


    public Suite create() {
        return new Suite(testCases);
    }


}