package Mocks;

import Models.Grid;
import Models.Robot;
import Models.Status;

public class mockRobot implements Robot {
    String action;

    @Override
    public void place(int x, int y, String facing, Grid grid) {
        action = String.format("PLACE%2d%2d %s", x, y, facing);
    }

    @Override
    public void place(String x, String y, String facing, Grid grid) {
        action = String.format("PLACE %s %s %s", x, y, facing);
    }

    @Override
    public void move(Grid grid) {
        action = "MOVE";
    }

    @Override
    public void left() {
        action = "LEFT";
    }

    @Override
    public void right() {
        action = "RIGHT";
    }

    @Override
    public String report() {
        String retString = action;
        action = "REPORTSTRING";
        return retString;
    }

    @Override
    public Status reportValues() {
        return null;
    }

}
