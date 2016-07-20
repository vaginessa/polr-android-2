package com.jgodha.android.pathofleastresistance;

import java.util.Stack;

public class Path {

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

    public int score() {
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
        sb.append("Score: ");
        sb.append(score());
        sb.append("\n");
        sb.append("Rows visited: ");
        for(Cell cell : cellsVisited) {
            sb.append(cell.getRowIndex() + 1 + " ");
        }
        sb.append("\n");
        return sb.toString();
    }
}
