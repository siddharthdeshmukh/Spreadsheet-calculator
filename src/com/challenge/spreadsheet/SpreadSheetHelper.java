package com.challenge.spreadsheet;

import java.util.Scanner;

/**
 *
 * @author siddharth
 */
public class SpreadSheetHelper {
    

    public static Cell getCell(String exp, Cell[][] spreadsheetCells) {

        try {

            int cellRow = (int) exp.charAt(0) % 65;
            int cellCol = Integer.parseInt(exp.substring(1, exp.length())) - 1;
            return spreadsheetCells[cellRow][cellCol];
        } catch (NumberFormatException e) {
            System.out.println("Data format error occurred while evaluating Cell " + exp);
            System.exit(1);
        }
        return null;

    }

    public static boolean isExpressionNumber(String exp) {
        try {
            Double.parseDouble(exp);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
