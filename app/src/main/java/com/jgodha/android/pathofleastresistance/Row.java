package com.jgodha.android.pathofleastresistance;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private int index;

    private List<Cell> columns = new ArrayList<>();

    public Row(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void addColumn(int position, int value) {
        columns.add(position, new Cell(index, position, value));
    }

    public List<Cell> getColumns() {
        return columns;
    }

    public void setColumns(List<Cell> columns) {
        this.columns = columns;
    }
}
