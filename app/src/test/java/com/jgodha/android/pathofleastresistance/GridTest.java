package com.jgodha.android.pathofleastresistance;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

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

    @Test
    public void returnsCandidateCellsForTheNextStep() throws Exception {
        loadTheGrid();

        List<Cell> cells = underTest.candidateCells(new Cell(1, 0, 0));

        assertThat(cells.size(), is(3));
        for(Cell cell : cells) {
            assertThat(cell.getColumnIndex(), is(1));
        }
        assertThat(cells.get(0).getRowIndex(), is(1));
        assertThat(cells.get(1).getRowIndex(), is(0));
        assertThat(cells.get(2).getRowIndex(), is(2));
    }

    @Test
    public void wrapsAroundWhenOnTheLastRow() throws Exception {
        loadTheGrid();

        List<Cell> cells = underTest.candidateCells(new Cell(2, 0, 0));

        assertThat(cells.size(), is(3));

        assertThat(cells.get(0).getRowIndex(), is(2));
        assertThat(cells.get(1).getRowIndex(), is(1));
        assertThat(cells.get(2).getRowIndex(), is(0));
    }

    @Test
    public void wrapsAroundWhenOnTheFirstRow() throws Exception {
        loadTheGrid();

        List<Cell> cells = underTest.candidateCells(new Cell(0, 0, 0));

        assertThat(cells.size(), is(3));

        assertThat(cells.get(0).getRowIndex(), is(0));
        assertThat(cells.get(1).getRowIndex(), is(2));
        assertThat(cells.get(2).getRowIndex(), is(1));
    }

    @Test
    public void handlesTheCaseWhenOnTheLastColumn() throws Exception {
        loadTheGrid();

        List<Cell> cells = underTest.candidateCells(new Cell(1, 2, 0));

        assertThat(cells.size(), is(0));
    }

    private void loadTheGrid() {
        for(int i = 0; i < 3; i++) {
            Row row = new Row(i);
            for(int j = 0; j < 3; j++) {
                row.addColumn(j, i*j);
            }
            underTest.addRow(row);
        }
    }
}