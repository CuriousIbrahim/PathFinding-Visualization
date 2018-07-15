import java.util.ArrayList;
import java.util.List;

public class Graph {

    private Node matrix[][];
    private int rows;
    private int columns;

    private Node start;
    private Node end;

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

        int highestRow = 0;

        for (Node node : nodes) {
            if (node.getRow() > highestRow) {
                highestRow = node.getRow();
            }
        }

        int highestColumn = 0;

        for (Node node: nodes) {
            if (node.getColumn() > highestColumn) {
                highestColumn = node.getColumn();
            }
        }

        this.rows = highestRow;
        this.columns = highestColumn;

        this.matrix = new Node[highestRow][highestColumn];

        for (Node node : nodes) {
            this.matrix[node.getRow()][node.getColumn()] = node;
        }

    }

    public Node getNode(int row, int column) {
        if (row >= this.rows && row < 0 && column >= this.columns && column < 0) {
            return null;
        }
        return this.matrix[row][column];
    }

    public List<Node> getNodesAdjacentTo(int row, int column) {

        List<Node> adjacentNodes = new ArrayList<>();

        adjacentNodes.add(getNode(row-1, column));
        adjacentNodes.add(getNode(row+1, column));
        adjacentNodes.add(getNode(row, column-1));
        adjacentNodes.add(getNode(row, column+1));

        adjacentNodes.remove(null);

        return adjacentNodes;

    }

    public List<Node> getNodesAdjacentTo(Node node) {
        return this.getNodesAdjacentTo(node.getRow(), node.getColumn());
    }

    public boolean setStartNode(int column, int row) {
        Node node = getNode(row, column);

        if (node == null) {
            return false;
        }

        this.start = node;

        return true;
    }

    public boolean setEndNode(int column, int row) {
        Node node = getNode(row, column);

        if (node == null) {
            return false;
        }

        this.end = node;

        return true;
    }

    public Node getStartNode() {
        return start;
    }

    public Node getEndNode() {
        return end;
    }
}
