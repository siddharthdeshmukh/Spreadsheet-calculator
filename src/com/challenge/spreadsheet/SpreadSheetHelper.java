package com.challenge.spreadsheet;

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
            throw new NumberFormatException("Incorrect Format in cell " + exp);
        }

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
