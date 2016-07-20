package com.jgodha.android.pathofleastresistance;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RowTest {

    private Row underTest;
    private int rowIndex = 2;
    private int columnIndex = 0;
    private int value = 5;

    @Before
    public void setup() {
        underTest = new Row(rowIndex);
        underTest.addColumn(columnIndex, value);
    }

    @Test
    public void addsColumn() throws Exception {
        List<Cell> columns = underTest.getColumns();

        assertThat(columns.size(), is(1));
    }

    @Test
    public void addsColumnAtTheGivenPosition() throws Exception {
        List<Cell> columns = underTest.getColumns();

        Cell column = columns.get(columnIndex);

        assertThat(column, not(nullValue()));
        assertThat(column.getColumnIndex(), is(columnIndex));
        assertThat(column.getRowIndex(), is(rowIndex));
    }

    @Test
    public void addsColumnWithTheGivenValue() throws Exception {
        List<Cell> columns = underTest.getColumns();

        Cell column = columns.get(columnIndex);

        assertThat(column.getValue(), is(value));
    }
}