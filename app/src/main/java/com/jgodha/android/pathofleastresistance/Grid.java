package com.jgodha.android.pathofleastresistance;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Grid {

    private Map<Integer, Row> grid = new LinkedHashMap<>();

    public void addRow(Row row) {
        grid.put(row.getIndex(), row);
    }

    public Row getRow(int rowIndex) {
        return grid.get(rowIndex);
    }

    public Cell cellAt(int rowIndex, int columnIndex) {
        return getRow(rowIndex).getColumns().get(columnIndex);
    }

    public int rowCount() {
        return grid.keySet().size();
    }

    public int columnCount() {
        return grid.get(0) != null ? grid.get(0).getColumns().size() : 0;
    }

    public List<Cell> candidateCells(Cell cell) {
        List<Cell> cells = new ArrayList<>();

        int nextColumnIndex = cell.getColumnIndex() + 1;
        if(nextColumnIndex >= columnCount()) {
            return cells;
        }

        int rowIndex = cell.getRowIndex();

        cells.add(cellAt(rowIndex, nextColumnIndex));

        // TODO need to handle the case when only two rows (up cell will be the same as the down cell) ?
        cells.add(cellUp(rowIndex, nextColumnIndex));

        cells.add(cellDown(rowIndex, nextColumnIndex));

        return cells;
    }

    private Cell cellDown(int rowIndex, int columnIndex) {
        int nextRowIndex = rowIndex + 1;
        if(nextRowIndex >= rowCount()) {
            nextRowIndex = 0;
        }
        return cellAt(nextRowIndex, columnIndex);
    }

    private Cell cellUp(int rowIndex, int columnIndex) {
        int previousRowIndex = rowIndex - 1;
        if(previousRowIndex < 0) {
            previousRowIndex = rowCount() - 1;
        }
        return cellAt(previousRowIndex, columnIndex);
    }
}
