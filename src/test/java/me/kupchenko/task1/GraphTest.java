package me.kupchenko.task1;


import me.kupchenko.task1.impl.GNodeImpl;
import me.kupchenko.task1.impl.GraphImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class GraphTest {

    @Test
    public void shouldReturnAllGNodesInGraph() {
        GNode gNode = prepareGraph();
        GraphImpl graph = new GraphImpl();
        List<GNode> gNodes = graph.walkGraph(gNode);
        assertThat(prepareGraphItems(), containsInAnyOrder(gNodes.toArray()));
    }

    @Test
    public void shouldReturnAllPathsInGraph() {
        GNode gNode = prepareGraph();
        GraphImpl graph = new GraphImpl();
        List<List<GNode>> gNodes = graph.paths(gNode);
        Assert.assertEquals(gNodes, prepareGraphPaths());
    }




    private GNode prepareGraph() {
        GNode gNodeA = new GNodeImpl("A");
        GNode gNodeB = new GNodeImpl("B");
        gNodeA.addChildren(gNodeB);

        GNode gNodeE = new GNodeImpl("E");
        GNode gNodeF = new GNodeImpl("F");
        gNodeB.addChildren(gNodeE);
        gNodeB.addChildren(gNodeF);


        GNode gNodeC = new GNodeImpl("C");
        gNodeA.addChildren(gNodeC);

        GNode gNodeG = new GNodeImpl("G");
        GNode gNodeH = new GNodeImpl("H");
        GNode gNodeI = new GNodeImpl("I");
        gNodeC.addChildren(gNodeG);
        gNodeC.addChildren(gNodeH);
        gNodeC.addChildren(gNodeI);


        GNode gNodeD = new GNodeImpl("D");
        gNodeA.addChildren(gNodeD);
        return gNodeA;
    }


    private List<List<GNode>> prepareGraphPaths() {
        List<List<GNode>> gnodes = new ArrayList<>();
        gnodes.add(Arrays.asList(getGNode("A"), getGNode("B"), getGNode("E")));
        gnodes.add(Arrays.asList(getGNode("A"), getGNode("B"), getGNode("F")));

        gnodes.add(Arrays.asList(getGNode("A"), getGNode("C"), getGNode("G")));
        gnodes.add(Arrays.asList(getGNode("A"), getGNode("C"), getGNode("H")));
        gnodes.add(Arrays.asList(getGNode("A"), getGNode("C"), getGNode("I")));

        gnodes.add(Arrays.asList(getGNode("A"), getGNode("D")));

        return gnodes;
    }

    private List<GNode> prepareGraphItems() {
        List<GNode> gnodes = new ArrayList<>();
        gnodes.add(getGNode("A"));
        gnodes.add(getGNode("B"));
        gnodes.add(getGNode("C"));
        gnodes.add(getGNode("D"));
        gnodes.add(getGNode("E"));
        gnodes.add(getGNode("F"));
        gnodes.add(getGNode("G"));
        gnodes.add(getGNode("H"));
        gnodes.add(getGNode("I"));
        return gnodes;
    }

    private GNode getGNode(String name) {
        return new GNodeImpl(name);
    }
}
