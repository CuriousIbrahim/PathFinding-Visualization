public class Node {

    // x & y - location
    // w - weight (cost to move to this node)
    private int row, column, w;

    public Node(int row, int column, int w) {
        this.row = row;
        this.column = column;
        this.w = w;
    }

    public Node(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Node() {
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

   public void setRowAndColumn(int row, int column) {
        this.row = row;
        this.column = column;
   }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getDistanceFrom (Node node) {
        int x = this.row + node.row;
        int y = this.column + node.column;

        return x + y;
    }

    @Override
    public String toString() {
        return "Node{" +
                "row=" + row +
                ", column=" + column +
                ", w=" + w +
                '}';
    }
}
