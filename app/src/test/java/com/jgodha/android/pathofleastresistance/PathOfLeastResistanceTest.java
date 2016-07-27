package com.jgodha.android.pathofleastresistance;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PathOfLeastResistanceTest {

    private LeastResistantPathFinder underTest = new LeastResistantPathFinder();


    @Test
    public void testKataScenario1() throws Exception {
        String gridData = "3 4 1 2 8 6\n6 1 8 2 7 4\n5 9 3 9 9 5\n8 4 1 3 2 6\n3 7 2 8 6 4";

        Path path = underTest.find(gridData);

        assertThat(path.isComplete(), is(true));
        assertThat(path.cost(), is(16));
        assertThat(path.rowsTraversed(), is("1 2 3 4 4 5"));
    }

    @Test
    public void testKataScenario2() throws Exception {
        String gridData = "3 4 1 2 8 6\n" + "6 1 8 2 7 4\n" + "5 9 3 9 9 5\n" + "8 4 1 3 2 6\n" + "3 7 2 1 2 3";

        Path path = underTest.find(gridData);

        assertThat(path.isComplete(), is(true));
        assertThat(path.cost(), is(11));
        assertThat(path.rowsTraversed(), is("1 2 1 5 5 5"));
    }

    @Test
    public void testKataScenario3() throws Exception {
        String gridData = "19 10 19 10 19\n" + "21 23 20 19 12\n" + "20 12 20 11 10";

        Path path = underTest.find(gridData);

        assertThat(path.isComplete(), is(false));
        assertThat(path.cost(), is(49));
        assertThat(path.rowsTraversed(), is("3 1 1"));
    }

    @Test
    public void testAdditionalScenario() throws Exception {
        String gridData = "1 3 5 1 5\n" + "3 8 1 4 9\n" + "4 7 1 9 3\n" + "9 1 2 8 1\n" + "1 3 4 8 2";

        Path path = underTest.find(gridData);

        assertThat(path.isComplete(), is(true));
        assertThat(path.cost(), is(8));
        assertThat(path.rowsTraversed(), is("1 1 2 1 5"));
    }

}
