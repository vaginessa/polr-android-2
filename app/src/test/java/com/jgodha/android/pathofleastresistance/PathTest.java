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
    public void returnsCost() throws Exception {
        assertThat(underTest.cost(), is(10));
    }

    @Test
    public void doesADeepCopy() throws Exception {
        underTest.setComplete(true);

        Path copy = underTest.deepCopy();

        assertThat(copy.isComplete(), is(underTest.isComplete()));
        assertThat(copy.getCellsVisited(), is(underTest.getCellsVisited()));
    }

    @Test
    public void comparesHigherWithAPathWithLowerCost() throws Exception {
        Path toBeCompared = new Path();

        assertThat(underTest.compareTo(toBeCompared), is(1));
    }

    @Test
    public void comparesLowerWithAPathWithHigherCost() throws Exception {
        Path toBeCompared = new Path();
        toBeCompared.addCell(new Cell(0, 0, 9));
        toBeCompared.addCell(new Cell(0, 1, 2));

        assertThat(underTest.compareTo(toBeCompared), is(-1));
    }

    @Test
    public void comparesTheSameWithAPathWithTheSameCost() throws Exception {
        Path toBeCompared = new Path();
        toBeCompared.addCell(cell1);
        toBeCompared.addCell(cell2);
        toBeCompared.addCell(cell3);

        assertThat(underTest.compareTo(toBeCompared), is(0));
    }

    @Test
    public void generatesResult() throws Exception {
        underTest.setComplete(true);

        String result = underTest.generateResult();
        assertThat(result.startsWith("RESULT"), is(true));
        assertThat(result.contains("Complete: Yes"), is(true));
        assertThat(result.contains("Cost: 10"), is(true));
        assertThat(result.contains("Rows traversed: 3 1 2"), is(true));
    }

    @Test
    public void returnsRowsTraversed() throws Exception {
        underTest.setComplete(true);

        String result = underTest.rowsTraversed();
        assertThat(result, is("3 1 2"));
    }
}