package com.jgodha.android.pathofleastresistance;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class InputParserTest {

    private InputParser underTest = new InputParser();

    @Test
    public void parsesInputToGenerateGrid() throws Exception {

        String gridData = "1 2 3 4 5\n6 7 8 9 0\n2 4 6 8 0\n1 3 5 7 9\n9 9 9 9 9";
        Grid grid = underTest.generateGrid(gridData);

        assertThat(grid.rowCount(), is(5));
        assertThat(grid.columnCount(), is(5));
        assertThat(grid.cellAt(0, 0).getValue(), is(1));
        assertThat(grid.cellAt(2, 3).getValue(), is(8));
        assertThat(grid.cellAt(4, 4).getValue(), is(9));
    }
}