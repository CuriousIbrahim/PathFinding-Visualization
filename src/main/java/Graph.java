import java.util.List;

public class Graph {



    private Node matrix[][];

    public Graph(int row, int column) {
        this.matrix = new Node[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                this.matrix[i][j] = new Node();
            }
        }
    }

    public Graph (List<Node> nodes) {

        int highestX = 0;

        for (Node node : nodes) {
            if (node.getX() > highestX) {
                highestX = node.getX();
            }
        }

        int highestY = 0;

        for (Node node: nodes) {
            if (node.getY() > highestY) {
                highestY = node.getY();
            }
        }

        this.matrix = new Node[highestY][highestX];

        for (Node node : nodes) {
            this.matrix[node.getY()][node.getX()] = node;
        }

    }

    public Node getNode(int row, int column) {
        return this.matrix[row][column];
    }

    public Node[] getNodesAdjacentTo(int row, int column) {

    }

    class





}
