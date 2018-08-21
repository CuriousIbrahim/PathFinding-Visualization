import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestPathFinding {

    @Test
    public void checkPath1PathScore() {

        AStar aStar = path1();

        int actual = 5;

        assertEquals(aStar.getPathCost(), actual);

    }


    public AStar path1() {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(0, 0, 1));
        nodes.add(new Node(0, 1, 1));
        nodes.add(new Node(0, 2, 1));
        nodes.add(new Node(0, 3, 1));
        nodes.add(new Node(1, 0, 1)); // Start
        nodes.add(new Node(1, 1, 1));
        nodes.add(new Node(1, 3, 1)); // End


        /*
            Visualization of List<Node> nodes

            N = Node; S = Start Node; E = End Node (destination)

            N --- N --- N --- N
            |     |           |
            |     |           |
            |     |           |
            S --- N           E

         */

        Graph graph = new Graph(nodes);

        graph.setStartNode(1, 0);
        graph.setEndNode(1, 3);

        AStar aStar = new AStar(graph);

        aStar.star();

        return aStar;
    }

}
