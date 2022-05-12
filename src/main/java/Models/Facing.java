package Models;

//enum class to store the facing value options.
//using an enum allows easy turn left/right impl without a lot of switch + if/else commands for changing direction.
public enum Facing {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    //get new facing depending on what direction is being turned
    //dir == -1 turn left
    //dir == 1 turn right
    //No error checking, values beyond 1/-1 could cause errors.
    public Facing next(int dir) {
        if (this.ordinal() == 0 && dir == -1)
            return WEST;
        if (this.ordinal() == 3 && dir == 1)
            return NORTH;
        return Facing.values()[this.ordinal() + dir];

    }
}

