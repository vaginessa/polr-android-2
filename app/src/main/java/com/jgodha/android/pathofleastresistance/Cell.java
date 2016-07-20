package com.jgodha.android.pathofleastresistance;

public class Cell {
    private int rowIndex;
    private int columnIndex;
    private int value;

    public Cell(int rowIndex, int columnIndex, int value) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.value = value;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
