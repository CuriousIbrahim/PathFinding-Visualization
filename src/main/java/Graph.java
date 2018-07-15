import java.util.List;

public class Graph {

    private Node matrix[][];
    private int rows;
    private int columns;

    public Graph(int row, int column) {

        this.rows = row;
        this.columns = column;

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

        this.rows = highestY;
        this.columns = highestX;

        this.matrix = new Node[highestY][highestX];

        for (Node node : nodes) {
            this.matrix[node.getY()][node.getX()] = node;
        }

    }

    public Node getNode(int row, int column) {
        if (row >= this.rows && row < 0 && column >= this.columns && column < 0) {
            return null;
        }
        return this.matrix[row][column];
    }

    public Node[] getNodesAdjacentTo(int row, int column) {

    }


}
