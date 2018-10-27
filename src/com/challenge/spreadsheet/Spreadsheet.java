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
        } catch (IllegalArgumentException iae) {
            Logger.getLogger(SpreadSheetCalculator.class.getName()).log(Level.SEVERE, iae.getMessage() + " Exiting");
            System.exit(1);
        } catch (CyclicDependencyException | RuntimeException ex) {
            Logger.getLogger(SpreadSheetCalculator.class.getName()).log(Level.SEVERE, ex.getMessage() + " Exiting");
            System.exit(1);
        }

    }
}
