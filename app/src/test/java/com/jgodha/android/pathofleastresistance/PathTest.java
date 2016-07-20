package com.jgodha.android.pathofleastresistance;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class PathTest {

    private Path underTest;
    private Cell cell1;
    private Cell cell2;
    private Cell cell3;


    @Before
    public void setup() {
        cell1 = new Cell(2, 0, 5);
        cell2 = new Cell(0, 1, 3);
        cell3 = new Cell(1, 2, 2);

        underTest = new Path();
        underTest.addCell(cell1);
        underTest.addCell(cell2);
        underTest.addCell(cell3);
    }

    @Test
    public void stacksVisitedCells() throws Exception {
        assertThat(underTest.getCellsVisited().size(), is(3));

        assertThat(underTest.removeCell(), is(cell3));
        assertThat(underTest.removeCell(), is(cell2));
        assertThat(underTest.removeCell(), is(cell1));
    }

    @Test
    public void returnsScore() throws Exception {
        assertThat(underTest.score(), is(10));
    }

    @Test
    public void generatesResult() throws Exception {
        underTest.setComplete(true);

        String result = underTest.generateResult();
        assertThat(result.startsWith("RESULT"), is(true));
        assertThat(result.contains("Complete: Yes"), is(true));
        assertThat(result.contains("Score: 10"), is(true));
        assertThat(result.contains("Rows visited: 3 1 2"), is(true));

    }
}