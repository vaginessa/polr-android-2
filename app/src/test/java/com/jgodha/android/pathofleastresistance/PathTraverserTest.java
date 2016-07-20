package com.jgodha.android.pathofleastresistance;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PathTraverserTest {

    private PathTraverser underTest;

    @Before
    public void setup() {
        underTest = new PathTraverser();
    }

    @Test
    public void traversesTheGridCompletely() throws Exception {
        Grid grid = new InputParser().generateGrid("1 5 3\n9 2 8\n6 3 7");

        List<Path> paths = underTest.traversePaths(grid);

        assertThat(paths.size(), is(27));
    }

    @Test
    public void leaveTheGridWithoutTraversingItCompletely() throws Exception {
        Grid grid = new InputParser().generateGrid("23 32 18\n17 40 8\n38 34 7");

        List<Path> paths = underTest.traversePaths(grid);

        assertThat(paths.size(), is(11));
    }
}