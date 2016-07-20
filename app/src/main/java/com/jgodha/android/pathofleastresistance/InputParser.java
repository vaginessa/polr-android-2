package com.jgodha.android.pathofleastresistance;

import java.util.StringTokenizer;

public class InputParser {

    public Grid generateGrid(String arg) {
        Grid grid = new Grid();
        StringTokenizer rowTokenizer = new StringTokenizer(arg, "\n");
        int rowIndex = 0;
        while(rowTokenizer.hasMoreTokens()) {
            Row row = new Row(rowIndex);
            String rowToken = rowTokenizer.nextToken();
            StringTokenizer columns = new StringTokenizer(rowToken,  " ");
            int columnIndex = 0;
            while(columns.hasMoreTokens()) {
                String column = columns.nextToken();
                row.addColumn(columnIndex, Integer.valueOf(column));
                columnIndex++;
            }
            grid.addRow(row);
            rowIndex++;
        }
        return grid;
    }
}
