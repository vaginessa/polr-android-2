package com.jgodha.android.pathofleastresistance;

import java.util.Stack;

public class Path implements Comparable<Path> {

    private Stack<Cell> cellsVisited = new Stack<>();
    private boolean complete;

    public Stack<Cell> getCellsVisited() {
        return cellsVisited;
    }

    public void setCellsVisited(Stack<Cell> cellsVisited) {
        this.cellsVisited = cellsVisited;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void addCell(Cell cell) {
        cellsVisited.push(cell);
    }

    public Cell removeCell() {
        return cellsVisited.pop();
    }

    public int cost() {
        int score = 0;
        for(Cell cell : cellsVisited) {
            score = score + cell.getValue();
        }
        return score;
    }

    public String generateResult() {
        StringBuilder sb = new StringBuilder("RESULT");
        sb.append("\n");
        sb.append("Complete: ");
        sb.append(complete ? "Yes" : "No");
        sb.append("\n");
        sb.append("Cost: ");
        sb.append(cost());
        sb.append("\n");
        sb.append("Rows visited: ");
        for(Cell cell : cellsVisited) {
            sb.append(cell.getRowIndex() + 1 + " ");
        }
        sb.append("\n");
        return sb.toString();
    }

    public Path deepCopy() {
        Path copy = new Path();
        copy.setComplete(complete);
        copy.setCellsVisited((Stack<Cell>)cellsVisited.clone());
        return copy;
    }

    @Override
    public int compareTo(Path path) {
        if(cost() > path.cost()) {
            return 1;
        }
        if(cost() < path.cost()) {
            return -1;
        }
        return 0;
    }
}
