/*
 * 1) Check for adjacent paths
 * 2) Calculate the score by adding a) cost of the path from start Node, and b) the estimated cost of the cheapest path
 *    to the destination Node
 * 3) Pick the cheapest one
 * 4) Repeat
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AStar {

    private Graph graph;

    private List<Node> openList;
    private List<Node> closedList;

    private List<Node> path;

    private Map<Node, Integer> scoreForNode;
    private Map<Node, Integer> heuristicForNode;

    public AStar(Graph graph) {
        this.graph = graph;
        this.openList = new ArrayList<>();
        this.closedList = new ArrayList<>();
        this.scoreForNode = new HashMap<>();
        this.heuristicForNode = new HashMap<>();
        this.path = new ArrayList<>();
    }

    private int calculateHeuristic(Node current) {
        return current.getDistanceFrom(this.graph.getEndNode());
    }


}
