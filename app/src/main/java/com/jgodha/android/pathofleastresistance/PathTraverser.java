package com.jgodha.android.pathofleastresistance;

import java.util.ArrayList;
import java.util.List;

public class PathTraverser {

    static final int MAX_RESISTANCE_VALUE = 50;

    public List<Path> traversePaths(Grid grid) {
        List<Path> paths = new ArrayList<>();

        int rowIndex = 0;
        while(rowIndex < grid.rowCount()) {
            int value = 0;
            Cell cell = grid.cellAt(rowIndex, 0);
            keepGoing(grid, paths, value, cell, new Path());
            rowIndex++;
        }
        return paths;
    }

    private void keepGoing(Grid grid, List<Path> paths, int value, Cell cell, Path path) {
        value = value + cell.getValue();
        if (value >= MAX_RESISTANCE_VALUE) {
            Path donePath = path.deepCopy();
            donePath.setComplete(false);
            paths.add(donePath);
            return;
        }

        if(cell.getColumnIndex() == grid.columnCount() - 1) { //on the the last column
            Path completedPath = path.deepCopy();
            completedPath.addCell(cell);
            completedPath.setComplete(true);
            paths.add(completedPath);
        } else {
            path.addCell(cell);
            List<Cell> candidateCells = grid.candidateCells(cell);
            for (Cell candidateCell : candidateCells) {
                keepGoing(grid, paths, value, candidateCell, path);
            }
            path.removeCell();
        }
    }
}
