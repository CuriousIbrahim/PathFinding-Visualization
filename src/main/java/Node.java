public class Node {

    // x & y - location
    // w - weight (cost to move to this node)
    private int x, y, w;

    public Node(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}
