public class Node {

    // x & y - location
    // g - cost from start node
    // h - estimated cost from this to destination
    private int x, y, g, h;

    public Node(int x, int y, int g, int h) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Node() {
    }

    public void setAll(int x, int y, int g, int h) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
    }

    public void setAllExceptH(int x, int y, int g) {
        this.x = x;
        this.y = y;
        this.g = g;
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

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }


}
