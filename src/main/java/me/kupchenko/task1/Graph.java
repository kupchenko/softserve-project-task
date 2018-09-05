package me.kupchenko.task1;

import java.util.List;

public interface Graph {
    /**
     * Method returns the list of nodes that are in the Graph.
     *
     * @param node - the root node
     * @return list of GNode in the graph
     */
    List<GNode> walkGraph(GNode node);

    /**
     * Method returns all possible paths in the graph.
     *
     * @param node - the root node
     * @return list of lists of GNode
     */
    List<List<GNode>> paths(GNode node);
}
