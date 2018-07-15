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

    public Node getNode(int row, int column) {
        return this.matrix[row][column];
    }





}
