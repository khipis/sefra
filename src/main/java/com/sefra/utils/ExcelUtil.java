package com.sefra.utils;

import com.sefra.Constants;
import com.sefra.SefraException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Util for manipulate Excel test case file
 *
 * @author Krzysztof Korolczuk <krzysztofkorolczuk2@gmail.com>
 */
public class ExcelUtil {

    private ExcelUtil() {
    }

    public static final int getRowCount(Sheet sheet) {
        return sheet.getLastRowNum() - sheet.getFirstRowNum();
    }

    public static final String getTestCaseName(Row row) {
        return row.getCell(0).toString();
    }

    public static final void logExcelData(Logger LOGGER, Row row) {
        final StringBuilder sb = new StringBuilder();

        sb.append(row.getCell(1).toString());
        sb.append(" ");
        sb.append(row.getCell(2).toString());
        sb.append(" ");
        sb.append(row.getCell(3).toString());
        sb.append(" ");
        sb.append(row.getCell(4).toString());

        LOGGER.info(sb.toString());
    }

    public static final boolean isTestCaseName(Row row) {
        return getTestCaseName(row).length() != 0;
    }

    public static Sheet readExcel(String filePath, String sheetName) throws SefraException {
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath))) {
            Workbook workbook = getProperWorkbook(fileInputStream, filePath);
            return workbook.getSheet(sheetName);
        } catch (IOException e) {
            throw new SefraException("Cannot read the excel file: " + filePath + " " + sheetName);
        }
    }

    public static String getValueCell(Row row) {
        return row.getCell(4).toString();
    }

    public static String getSelectorCell(Row row) {
        return row.getCell(3).toString();
    }

    public static String getElementCell(Row row) {
        return row.getCell(2).toString();
    }

    public static String getCommandCell(Row row) {
        return row.getCell(1).toString();
    }

    private static Workbook getProperWorkbook(FileInputStream inputStream, String fileName)
            throws IOException {

        String fileExtension = fileName.substring(fileName.indexOf(Constants.DOT));

        if (fileExtension.equals(Constants.XLSX)) {
            return new XSSFWorkbook(inputStream);
        } else {
            return new HSSFWorkbook(inputStream);
        }

    }
}

