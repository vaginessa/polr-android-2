package com.jgodha.android.pathofleastresistance;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

public class GridTest {

    private Grid underTest;
    private Row row;
    private int rowIndex = 0;
    private int columnIndex = 0;
    private int value = 5;


    @Before
    public void setup() {
        row = new Row(rowIndex);
        row.addColumn(columnIndex, value);
        underTest = new Grid();
        underTest.addRow(row);
    }

    @Test
    public void returnsRowAtIndex() throws Exception {
        assertThat(underTest.getRow(rowIndex), is(row));
    }

    @Test
    public void returnsTheCellAtTheGivenCoordinates() throws Exception {
        Cell cell = underTest.cellAt(rowIndex, columnIndex);
        assertThat(cell, not(nullValue()));
        assertThat(cell.getValue(), is(value));
    }

    @Test
    public void returnsRowCount() throws Exception {
        assertThat(underTest.rowCount(), is(1));
    }

    @Test
    public void returnsColumnCount() throws Exception {
        assertThat(underTest.columnCount(), is(1));
    }
}