package Models;

// grid implementation
public class GridImpl implements Grid {
    int x;
    int y;

    public GridImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
