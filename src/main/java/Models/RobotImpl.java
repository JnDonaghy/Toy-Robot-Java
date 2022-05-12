package Models;

public class RobotImpl implements Robot {
    int x;
    int y;
    Facing facing;

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
        if(isValid())
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
        //Spec has report on non-placed robot have no action.
        //added warning, as requesting a Report and getting no response is a bad user experience
        //and could be interpreted as a bug by user.
        if(!isValid()){
            System.out.println("Robot not on Board use 'PLACE x y f' command");
            return null;
        }
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
