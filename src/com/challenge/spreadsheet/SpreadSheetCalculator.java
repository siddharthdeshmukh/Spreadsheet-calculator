/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.challenge.spreadsheet;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author siddharth
 */
public class SpreadSheetCalculator {

    int rows;
    int columns;
    Cell[][] spreadSheetCells;
    
    public void processWorkbook() throws CyclicDependencyException,IllegalArgumentException, Exception  {
        populateSpreadSheetCells();
        evaluateSpreadsheet();
        printResult();
    }
    
    private void populateSpreadSheetCells() throws Exception {

        try {

            Scanner sc = new Scanner(System.in);
            String[] spreadSheetSize = null;

            if (sc.hasNextLine()) {
                spreadSheetSize = sc.nextLine().split(" ");

                if (spreadSheetSize.length != 2) {
                    throw new IllegalArgumentException("Invalid Parameters for Spreadsheet Size. " + spreadSheetSize.length);
                } else {
                    columns = Integer.parseInt(spreadSheetSize[0]);
                    rows = Integer.parseInt(spreadSheetSize[1]);
                    spreadSheetCells = new Cell[rows][columns];
                }

            }
            int row = 0, column = 0;
            while (sc.hasNextLine()) {
                String contents = sc.nextLine();
                if (contents.isEmpty()) {
                    break;
                }
                spreadSheetCells[row][column] = new Cell(contents);
                column++;
                if (column == columns) {
                    column = 0;
                    row++;
                }
            }
        } catch (Exception e) {
            throw new Exception("Error in populateSpreadsheetCells " + e.getMessage());
        }

    }

    private void evaluateSpreadsheet() throws CyclicDependencyException, IllegalArgumentException {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                calculateCell(spreadSheetCells[i][j], null);
            }
        }

    }

    private double calculateCell(Cell spreadCell, Set<Cell> evaluationSet) throws CyclicDependencyException, IllegalArgumentException {

        if (evaluationSet == null) {
            evaluationSet = new HashSet<>();

        }
        if (spreadCell.isEvaluated()) {
            return spreadCell.getCellValue();
        } else if (!spreadCell.isEvaluated() && !evaluationSet.contains(spreadCell)) {
            evaluationSet.add(spreadCell);

            String[] expressions = spreadCell.getCellContents().split(" ");
            Stack<Double> results = new Stack<Double>();

            for (String expStr : expressions) {
                if (SpreadSheetHelper.isExpressionNumber(expStr)) {
                    results.push(Double.parseDouble(expStr));
                } else {
                    switch (expStr) {
                        case Operations.ADD:
                            results.push(results.pop() + results.pop());
                            break;
                        case Operations.SUBTRACT:
                            double subValue = results.pop();
                            double subFrom = results.pop();

                            results.push(subFrom - subValue);
                            break;
                        case Operations.MULTIPLY:
                            results.push(results.pop() * results.pop());
                            break;
                        case Operations.DIVIDE:
                            double divisor = results.pop();
                            double dividend = results.pop();
                            if (divisor == 0) {
                                throw new IllegalArgumentException("Cannot Divide by 0");
                            }
                            results.push(dividend / divisor);
                            break;
                        case Operations.INCREMENT:
                            double number = results.pop();
                            results.push(++number);
                            break;
                        case Operations.DECREMENT:
                            double numb = results.pop();
                            results.push(--numb);
                            break;
                        default:
                            Cell anotherCell = SpreadSheetHelper.getCell(expStr, spreadSheetCells);
                            results.push(calculateCell(anotherCell, evaluationSet));
                            break;

                    }
                }

            }

            spreadCell.setCellValue(results.pop());
            spreadCell.setEvaluated(true);
        } else {
            throw new CyclicDependencyException("Cycle Occurred while evaluating Cell " + spreadCell.getCellContents());
        }

        return spreadCell.getCellValue();

    }

    private void printResult() {

        System.out.println(columns + " " + rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == rows - 1 && j == columns - 1) {
                    System.out.printf("%.5f", spreadSheetCells[i][j].getCellValue());
                } else {
                    System.out.printf("%.5f%n", spreadSheetCells[i][j].getCellValue());
                }
            }
        }
    }

}
