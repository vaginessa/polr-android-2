package com.jgodha.android.pathofleastresistance;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LeastResistantPathDeterminerTest {

    private LeastResistantPathDeterminer underTest;
    private List<Path> paths;
    private Path path1;
    private Path path2;

    @Before
    public void setup() {
        paths = new ArrayList<>();
        path1 = new Path();
        path2 = new Path();
        paths.add(path1);
        paths.add(path2);
        underTest = new LeastResistantPathDeterminer();
    }

    @Test
    public void returnsTheCompletePathWithTheLeastCost() throws Exception {
        path1.addCell(new Cell(0, 0, 3));
        path2.addCell(new Cell(0, 0, 4));
        path2.setComplete(true);

        Path pathWithTheLeastResistance = underTest.determine(paths);
        assertThat(pathWithTheLeastResistance, is(path2));
    }

    @Test
    public void returnsTheIncompletePathWithTheMostCost() throws Exception {
        path1.addCell(new Cell(0, 0, 4));
        path2.addCell(new Cell(0, 0, 3));

        Path pathWithTheLeastResistance = underTest.determine(paths);
        assertThat(pathWithTheLeastResistance, is(path1));
    }
}