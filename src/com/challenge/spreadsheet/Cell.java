/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.spreadsheet;

/**
 *
 * @author siddharth
 */
public class Cell {
    
    private double cellValue;
    private boolean evaluated;
    private String cellContents;

    public Cell(String cellContents) {
        this.cellContents = cellContents;
    }

    public double getCellValue() {
        return cellValue;
    }

    public void setCellValue(double cellValue) {
        this.cellValue = cellValue;
    }

    public boolean isEvaluated() {
        return evaluated;
    }

    public void setEvaluated(boolean evaluated) {
        this.evaluated = evaluated;
    }

    public String getCellContents() {
        return cellContents;
    }

    public void setCellContents(String cellContents) {
        this.cellContents = cellContents;
    } 
    
}
