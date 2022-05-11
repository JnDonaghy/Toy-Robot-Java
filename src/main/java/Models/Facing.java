package Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public enum Facing {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    //get new facing depending on what direction is being turned
    //dir == -1 turn left
    //dir == 1 turn right
    //No error checking, values beyond 1/-1 could cause errors.
    public Facing next(int dir){
        if(this.ordinal() == 0 && dir == -1)
            return WEST;
        if(this.ordinal() == 3 && dir == 1)
            return NORTH;
        return Facing.values()[this.ordinal()+dir];

    }
}

