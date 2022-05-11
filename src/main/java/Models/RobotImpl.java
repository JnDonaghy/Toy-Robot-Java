package Models;

public class RobotImpl implements Robot {
    int x;
    int y;
    boolean placed;
    Facing facing;
    Status priorState;

    @Override
    public void place(int x, int y, String Facing) {
    }

    @Override
    public void move() {

    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public String reportString() {
        return null;
    }

    @Override
    public Status reportValues() {
        return null;
    }

    @Override
    public void reset() {
        //TODO: revert to prior state.
    }


    public String report() {
        return null;
    }

    private void updatePrior(){
        priorState.x = this.x;
        priorState.y = this.y;
        priorState.facing = this.facing;
    }


}
