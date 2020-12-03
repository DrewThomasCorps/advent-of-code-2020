package com.adventofcode._03;

import java.util.List;

public class Forest {
    private final List<List<Boolean>> treeList;

    public Forest(List<List<Boolean>> treeList) {
        this.treeList = treeList;
    }

    public boolean hasTreeAtCoordinate(Coordinate coordinate) {
        return treeList.get(coordinate.down)
                .get(coordinate.right % treeList.get(coordinate.down).size());
    }

    public boolean contains(Coordinate coordinate) {
        return coordinate.down < treeList.size();
    }
}
