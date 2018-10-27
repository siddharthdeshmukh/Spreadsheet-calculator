package com.challenge.spreadsheet;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siddharth
 */
public class Spreadsheet {


    public static void main(String[] args) {

        try {
            Spreadsheet sp = new Spreadsheet();
            SpreadSheetCalculator spCalculator = new SpreadSheetCalculator();
            spCalculator.processWorkbook();
        } catch (Exception ex) {
            Logger.getLogger(Spreadsheet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
