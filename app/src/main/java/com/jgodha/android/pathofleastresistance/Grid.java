package com.jgodha.android.pathofleastresistance;

import java.util.ArrayList;
import java.util.HashMap;
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

}
