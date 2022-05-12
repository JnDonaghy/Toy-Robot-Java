package Models;

public class RobotImpl implements Robot {
    int x;
    int y;
    boolean placed;
    Facing facing;
    Status priorState;

    @Override
    public void place(int x, int y, String facing, Grid grid) {
        Facing f;
        try {
            f = Facing.valueOf(facing.toUpperCase());
        }catch (IllegalArgumentException e){
            System.out.println("Facing value invalid: must be one of: NORTH, SOUTH, EAST, WEST");
            return;
        }

        if(grid.getX() >= x &&
                grid.getY() >= y &&
                x >= 0 &&
                y >= 0) {
            this.facing = f;
            this.x = x;
            this.y = y;
        }

    }

    @Override
    public void move(Grid grid) {
        // valid check not required, if facing is null, switch statement will do nothing.
        switch (facing){
            case EAST:
                // +1 x direction
                if(x + 1 <= grid.getX())
                    x++;
                break;
            case WEST:
                // -1 x direction
                if(x-1 >=0)
                    x--;
                break;
            case SOUTH:
                //-1 y direction
                if(y -1 >=0)
                    y--;
                break;
            case NORTH:
                //  +1 y direction
                if(y+1 <= grid.getY())
                    y++;
                break;
        }
    }

    @Override
    public void left() {
        if(isValid())
            this.facing = this.facing.next(-1);
    }

    @Override
    public void right() {
        if(isValid())
            this.facing = this.facing.next(1);
    }

    @Override
    public String report() {
        String report = String.format("%d,%d,%s", x,y,facing);
        System.out.println(report);
        return report;
    }

    @Override
    public Status reportValues() {
        return new Status(x,y,facing);
    }


    private boolean isValid(){
        if(facing != null) return true;
        return false;
    }

}
