package com.jgodha.android.pathofleastresistance;

import java.util.Collections;
import java.util.List;

public class LeastResistantPathDeterminer {

    public Path determine(List<Path> paths) {
        Collections.sort(paths);
        for(Path path : paths) {
            if(path.isComplete()) {
                return path;
            }
        }
        Collections.reverse(paths);
        return paths.get(0);
    }
}
