package Models;

public class RobotImpl implements Robot {
    int x;
    int y;
    Facing facing;

    //places the robot with a given position and facing
    //grid is used to check that the position is valid.
    @Override
    public void place(int x, int y, String facing, Grid grid) {
        //try to parse the given facing, if the facing isn't valid, print error and do nothing.
        Facing f;
        try {
            f = Facing.valueOf(facing.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Facing value invalid: must be one of: NORTH, SOUTH, EAST, WEST");
            return;
        }
        //check x and y coordinates are within the grid and if so place robot
        if (grid.getX() >= x && grid.getY() >= y && x >= 0 && y >= 0) {
            this.facing = f;
            this.x = x;
            this.y = y;
        }

    }

    //overload for place(int,int,...) method, accepts and parses strings to int.
    public void place(String xs, String ys, String facing, Grid grid) {
        try {
            int x = Integer.parseInt(xs);
            int y = Integer.parseInt(ys);
            place(x, y, facing, grid);
        } catch (Exception e) {
            //bad value passed
            System.out.println("invalid parameter passed to Place Command");
        }
    }

    //move the robot forward 1 space
    @Override
    public void move(Grid grid) {
        //check the robot has been placed - move in the direction it's facing
        //unless that would put it off the grid.
        if (isValid()) switch (facing) {
            case EAST:
                // +1 x direction
                if (x + 1 <= grid.getX()) x++;
                break;
            case WEST:
                // -1 x direction
                if (x - 1 >= 0) x--;
                break;
            case SOUTH:
                //-1 y direction
                if (y - 1 >= 0) y--;
                break;
            case NORTH:
                //  +1 y direction
                if (y + 1 <= grid.getY()) y++;
                break;
        }
    }

    //turns the robot left
    @Override
    public void left() {
        if (isValid()) this.facing = this.facing.next(-1);
    }

    //turns the robot right
    @Override
    public void right() {
        if (isValid()) this.facing = this.facing.next(1);
    }

    //reports the current status of the robot
    @Override
    public String report() {
        //Spec has report on non-placed robot have no action.
        //added warning, as requesting a Report and getting no response is a bad user experience
        //and could be interpreted as a bug by user.
        if (!isValid()) {
            System.out.println("Robot not on Board use 'PLACE x y f' command");
            return null;
        }
        String report = String.format("%d,%d,%s", x, y, facing);
        System.out.println(report);
        return report;
    }

    //returns the status of the robot as an object for tests.
    //this allows tests to use fast integer/enum comparisons, rather than comparatively slow string matching.
    @Override
    public Status reportValues() {
        return new Status(x, y, facing);
    }

    //a function that returns true if the robot has been placed, false if not.
    private boolean isValid() {
        return facing != null;
    }

}
