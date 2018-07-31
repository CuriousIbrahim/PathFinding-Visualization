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
    private Map<Node, Integer> totalScoreForNode;

    public AStar(Graph graph) {
        this.graph = graph;
        this.openList = new ArrayList<>();
        this.closedList = new ArrayList<>();
        this.scoreForNode = new HashMap<>();
        this.heuristicForNode = new HashMap<>();
        this.totalScoreForNode = new HashMap<>();
        this.path = new ArrayList<>();
    }

    public void star() {

        System.out.println("A Star Starting");


        path.add(graph.getStartNode());

        scoreForNode.put(graph.getStartNode(), 0);
        openList.add(graph.getStartNode());

        System.out.println("Start node is " + graph.getStartNode());

        Node current = graph.getStartNode();

        while (!openList.isEmpty()) {

            System.out.println("Checking adjacent nodes to " + current);
            List<Node> neighbours = graph.getNodesAdjacentTo(current);

            System.out.println("neighbours: " + neighbours.toString());

            for (Node neighbour : neighbours) {

                if (closedList.contains(neighbour) || neighbour == null) {
                    continue;
                }

                System.out.println("\t" + neighbour);

                int score = neighbour.getW() + getPathScore();                  // Weight of neighbour + path (Start to Current)
                int heuristic = neighbour.getDistanceFrom(graph.getEndNode());  // Heuristic of neighbour

                System.out.println("\t\tScore of " + neighbour + " is " + score);
                System.out.println("\t\tHeuristic of " + neighbour + " is " + heuristic);
                System.out.println("\t\tTotal score of " + neighbour + " is " + (score + heuristic));
                scoreForNode.put(neighbour, score);
                heuristicForNode.put(neighbour, heuristic);
                totalScoreForNode.put(neighbour, score + heuristic);

                System.out.println("totalScoreForNode: " + totalScoreForNode.toString());

            }

            Node cheapestNeighbour = neighbours.get(0);
            System.out.println("Checking for cheapest neighbour");
            for (Node node : neighbours) {
                if (node != null && !node.equals(graph.getStartNode()) && !cheapestNeighbour.equals(graph.getStartNode())) {
                    System.out.println("Comparing " + cheapestNeighbour + " whose score is " +
                            totalScoreForNode.get(cheapestNeighbour)+ " to " + node + " whose total score is " +
                            totalScoreForNode.get(node));
                    if (totalScoreForNode.get(cheapestNeighbour) > totalScoreForNode.get(node)) {
                        cheapestNeighbour = node;
                    } else {
                        // Check if cheapestNeighbour is pointing to the same object
                        if (cheapestNeighbour != node) {
                            closedList.add(node);
                        }
                    }
                }
            }

            System.out.println("Cheapest neighbour is " + cheapestNeighbour);

            openList.remove(current);
            closedList.add(current);

            path.add(current);

            current = cheapestNeighbour;

            openList.add(current);

        }

        System.out.println("Printing path:\n");

        for (Node node : path)
            System.out.println(node);


    }

    private int getPathScore() {

        int total = 0;

        for (Node node : path) {
            total += node.getW();
        }

        return total;
    }

}
