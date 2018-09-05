package me.kupchenko.task1.impl;

import me.kupchenko.task1.GNode;

import java.util.Collection;
import java.util.HashSet;

public class GNodeImpl implements GNode {
    private String name;
    private Collection<GNode> nodes = new HashSet<>();


    public GNodeImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public GNode[] getChildren() {
        return nodes.toArray(new GNode[]{});
    }

    public void addChildren(GNode gNode) {
        nodes.add(gNode);
    }

    @Override
    public String toString() {
        return "GNode(" + name + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GNodeImpl gNode = (GNodeImpl) o;

        return name != null ? name.equals(gNode.name) : gNode.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
