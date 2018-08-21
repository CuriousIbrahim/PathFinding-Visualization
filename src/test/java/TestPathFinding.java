import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPathFinding {

    @Test
    public void checkPath1PathScore() {

        AStar aStar = path1();

        int actual = 5;

        assertEquals(aStar.getPathCost(), actual);

    }
    @Test
    public void checkPath1Path() {
        AStar aStar = path1();

        List<Node> actual = new ArrayList<>();
        actual.add(new Node(1, 0, 1));
        actual.add(new Node(0, 0, 1));
        actual.add(new Node(0, 1, 1));
        actual.add(new Node(0, 2, 1));
        actual.add(new Node(0, 3, 1));
        actual.add(new Node(1, 3, 1));

        System.out.println();

        // After printing the test and actual, they look the exact same, yet it keeps stating that they are not.
        // I don't know why!
        for (int i = 0; i < actual.size(); i++) {
            System.out.println(aStar.getPath().get(i) + "\t\t\t" + actual.get(i));
        }

        System.out.println(aStar.getPath().equals(actual));

        assertTrue(aStar.getPath().equals(actual));

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
