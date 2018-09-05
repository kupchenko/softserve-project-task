package me.kupchenko.task1;

/**
 * This class represents a node in the Graph. Contains information about node's name and it's children.
 */
public interface GNode {
    /**
     * Method returns the node's name.
     *
     * @return the name of the Node
     */
    String getName();

    /**
     * Helps to get all children of this node.
     *
     * @return an array with all node's children
     */
    GNode[] getChildren();


    /**
     * Provides functionality to add a child node.
     *
     * @param node the node which to add
     */
    void addChildren(GNode node);
}
