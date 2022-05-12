package Models;

//used to store an object (robot) state on the grid.
public class Status {
    public int x;
    public int y;
    public Facing facing;

    public Status(int x, int y, Facing f) {
        this.x = x;
        this.y = y;
        this.facing = f;
    }
}
