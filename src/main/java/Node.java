public class Node {

    // x & y - location
    // g - cost from start node
    // h - estimated cost from this to destination
    private int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

   public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
   }

}
