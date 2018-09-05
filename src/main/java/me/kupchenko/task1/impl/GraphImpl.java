package me.kupchenko.task1.impl;

import me.kupchenko.task1.GNode;
import me.kupchenko.task1.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphImpl implements Graph {
    public List<GNode> walkGraph(GNode node) {
        List<GNode> gNodes = new ArrayList<>();
        gNodes.add(node);
        collectNodes(node, gNodes);
        return gNodes;
    }

    private void collectNodes(GNode node, List<GNode> gNodes) {
        for (GNode gNode : node.getChildren()) {
            gNodes.add(gNode);
            collectNodes(gNode, gNodes);
        }
    }

    public List<List<GNode>> paths(GNode node) {
        List<List<GNode>> retLists = new ArrayList<>();

        if (node.getChildren().length == 0) {
            List<GNode> leafList = new LinkedList<>();
            leafList.add(node);
            retLists.add(leafList);
        } else {
            buildPath(node, retLists);
        }

        return retLists;
    }

    private void buildPath(GNode node, List<List<GNode>> retLists) {
        for (GNode сNode : node.getChildren()) {
            List<List<GNode>> nodeLists = paths(сNode);
            for (List<GNode> nodeList : nodeLists) {
                nodeList.add(0, node);
                retLists.add(nodeList);
            }
        }
    }
}