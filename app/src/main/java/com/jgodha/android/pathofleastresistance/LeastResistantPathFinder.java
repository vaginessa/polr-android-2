package com.jgodha.android.pathofleastresistance;

import java.util.List;

public class LeastResistantPathFinder {

    private InputParser inputParser = new InputParser();
    private PathTraverser pathTraverser = new PathTraverser();
    private LeastResistantPathDeterminer leastResistantPathDeterminer = new LeastResistantPathDeterminer();


    public Path find(String gridData) {
        Grid grid = inputParser.generateGrid(gridData);
        List<Path> paths = pathTraverser.traversePaths(grid);
        Path path = leastResistantPathDeterminer.determine(paths);
        return path;
    }

    public void setInputParser(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public void setPathTraverser(PathTraverser pathTraverser) {
        this.pathTraverser = pathTraverser;
    }

    public void setLeastResistantPathDeterminer(LeastResistantPathDeterminer leastResistantPathDeterminer) {
        this.leastResistantPathDeterminer = leastResistantPathDeterminer;
    }
}
