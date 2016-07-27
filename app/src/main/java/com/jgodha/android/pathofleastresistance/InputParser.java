package com.jgodha.android.pathofleastresistance;

public class InputParser {

    public Grid generateGrid(String arg) {
        validateInputIsNotBlank(arg);
        Grid grid = new Grid();
        int numberOfColumns = 0;
        int rowIndex = 0;
        String[] tokens = arg.split("\n");
        for(String token : tokens) {
            Row row = new Row(rowIndex);
            String[] cells = token.split(" ");
            if(rowIndex == 0) {
                numberOfColumns = cells.length;
            } else {
                if(cells.length != numberOfColumns) {
                    throw new RuntimeException("Not all rows have the same number of columns");
                } else {
                    numberOfColumns = cells.length;
                }
            }
            int columnIndex = 0;
            parseColumnsFoRow(row, cells, columnIndex);
            grid.addRow(row);
            rowIndex++;
        }
        return grid;
    }

    private void validateInputIsNotBlank(String arg) {
        if(arg == null || arg.equals("")) {
            throw new RuntimeException("Cannot parse blank input");
        }
    }

    private void parseColumnsFoRow(Row row, String[] cells, int columnIndex) {
        for(String cell : cells) {
            row.addColumn(columnIndex, Integer.valueOf(cell));
            columnIndex++;
        }
    }
}
