package com.jgodha.android.pathofleastresistance;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LeastResistantPathFinderTest {

    @InjectMocks
    private LeastResistantPathFinder underTest;
    @Mock
    private InputParser inputParser;
    @Mock
    private PathTraverser pathTraverser;
    @Mock
    private LeastResistantPathDeterminer leastResistantPathDeterminer;

    @Mock
    private Grid grid;
    @Mock
    private List<Path> paths;
    @Mock
    private Path path;

    private String gridData = "gridData";
    private String result = "result";

    @Before
    public void init() {
        when(inputParser.generateGrid(gridData)).thenReturn(grid);
        when(pathTraverser.traversePaths(grid)).thenReturn(paths);
        when(leastResistantPathDeterminer.determine(paths)).thenReturn(path);
    }

    @Test
    public void findsThePathWithTheLeastResistance() throws Exception {
        assertThat(underTest.find(gridData), is(path));
    }
}