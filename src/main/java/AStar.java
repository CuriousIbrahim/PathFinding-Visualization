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

        scoreForNode.put(graph.getStartNode(), 0);
        openList.add(graph.getStartNode());

        System.out.println("Start node is " + graph.getStartNode());

        Node current = graph.getStartNode();

        while (!openList.isEmpty()) {

            System.out.println("Checking adjacent nodes to " + current);
            List<Node> neighbours = cleanNodeList(graph.getNodesAdjacentTo(current));


            System.out.println("neighbours: " + neighbours.toString());

            for (Node neighbour : neighbours) {

                if (closedList.contains(neighbour) || neighbour == null) {
                    continue;
                }

                System.out.println("\t" + neighbour);

                int score = neighbour.getW() + getPathCost();                  // Weight of neighbour + path (Start to Current)
                int heuristic = neighbour.getDistanceFrom(graph.getEndNode());  // Heuristic of neighbour

                System.out.println("\t\tScore of " + neighbour + " is " + score);
                System.out.println("\t\tHeuristic of " + neighbour + " is " + heuristic);
                System.out.println("\t\tTotal score of " + neighbour + " is " + (score + heuristic));
                scoreForNode.put(neighbour, score);
                heuristicForNode.put(neighbour, heuristic);
                totalScoreForNode.put(neighbour, score + heuristic);

                System.out.println("totalScoreForNode: " + totalScoreForNode.toString());

            }

            Node cheapestNeighbour = null;
            for (Node node : neighbours) {
                if (!closedList.contains(node) && node != null) {
                    cheapestNeighbour = node;
                    break;
                }
            }
            System.out.println("Checking for cheapest neighbour");
            for (Node node : neighbours) {

                if (closedList.contains(node) || node == null) {
                    continue;
                }

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

            System.out.println("Cheapest neighbour is " + cheapestNeighbour);

            openList.remove(current);
            closedList.add(current);

            path.add(current);

            current = cheapestNeighbour;

            openList.add(current);

            System.out.println("Closed List: " + closedList);

            if (current.equals(graph.getEndNode())) {
                System.out.println("current == endNode : " + current + " == " + graph.getEndNode());
                path.add(current);
                break;
            }
        }

        System.out.println("Printing path:\n");

        for (Node node : path)
            System.out.println(node);


    }

    public int getPathCost() {

        int total = 0;

        for (Node node : path) {
            total += node.getW();
        }

        // This is because the score includes the startNode. Subtracting the total by 1 will compensate for that.
        total-=1;

        return total;
    }

    private List<Node> cleanNodeList(List<Node> nodes) {

        List<Node> toReturn = new ArrayList<>();

        for (Node node : nodes) {
            if (node != null && !node.equals(graph.getStartNode()))
                toReturn.add(node);
        }

        return toReturn;

    }

}
