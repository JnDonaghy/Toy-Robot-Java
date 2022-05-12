package unitTests;
//unit tests

import Models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class robotTest {

    Grid grid;
    int xMax = 5;
    int yMax = 5;

    @Before
    public void before() {
        grid = new GridImpl(xMax, yMax);
    }

    @Test
    public void testCreate() {
        // should report current robot status
        Robot robot = new RobotImpl();
        Status status = robot.reportValues();
        assertNull(status.facing);
    }

    @Test
    public void testPlace() {
        //Should create a robot object if valid parameters passed
        Robot robot = new RobotImpl();
        robot.place(0, 0, "East", grid);
        Status status = robot.reportValues();
        assertEquals(status.x, 0);
        assertEquals(status.y, 0);
        assertEquals(status.facing, Facing.EAST);
    }

    @Test
    public void testReport() {
        //Should create a robot object if valid parameters passed
        Robot robot = new RobotImpl();
        robot.place(0, 0, "East", grid);
        String status = robot.report();
        String expectStatus = "0,0,EAST";
        assertEquals(status, expectStatus);
    }

    @Test
    public void testMove() {
        //Should create a robot object if valid parameters passed
        Robot robot = new RobotImpl();
        robot.place(0, 0, "East", grid);
        robot.move(grid);
        Status status = robot.reportValues();
        assertEquals(status.x, 1);
        assertEquals(status.y, 0);
        assertEquals(status.facing, Facing.EAST);
    }

    @Test
    public void testTurnLeft() {
        //should change facing when turning left.
        Robot robot = new RobotImpl();
        robot.place(0, 0, "East", grid);
        robot.left();
        Status status = robot.reportValues();
        assertEquals(status.x, 0);
        assertEquals(status.y, 0);
        assertEquals(status.facing, Facing.NORTH);
    }

    @Test
    public void testTurnRight() {
        //should change facing when turning right
        Robot robot = new RobotImpl();
        robot.place(0, 0, "East", grid);
        robot.right();
        Status status = robot.reportValues();
        assertEquals(status.x, 0);
        assertEquals(status.y, 0);
        assertEquals(status.facing, Facing.SOUTH);
    }

    @Test
    public void testFailIfInvalidNorth() {
        //should fail if trying to move off the grid (north)
        Robot robot = new RobotImpl();
        robot.place(0, yMax, "NORTH", grid);
        robot.move(grid);
        Status status = robot.reportValues();
        assertEquals(status.x, 0);
        assertEquals(status.y, yMax);
        assertEquals(status.facing, Facing.NORTH);
    }

    @Test
    public void testFailIfInvalidEast() {
        //should fail if trying to move off the grid (east)
        Robot robot = new RobotImpl();
        robot.place(xMax, 0, "EAST", grid);
        robot.move(grid);
        Status status = robot.reportValues();
        assertEquals(status.x, xMax);
        assertEquals(status.y, 0);
        assertEquals(status.facing, Facing.EAST);
    }

    @Test
    public void testFailIfInvalidSouth() {
        //should fail if trying to move off the grid (south)
        Robot robot = new RobotImpl();
        robot.place(0, 0, "South", grid);
        robot.move(grid);
        Status status = robot.reportValues();
        assertEquals(status.x, 0);
        assertEquals(status.y, 0);
        assertEquals(status.facing, Facing.SOUTH);
    }

    @Test
    public void testFailIfInvalidWest() {
        //should fail if trying to move off the grid (west)
        Robot robot = new RobotImpl();
        robot.place(0, 0, "West", grid);
        robot.move(grid);
        Status status = robot.reportValues();
        assertEquals(status.x, 0);
        assertEquals(status.y, 0);
        assertEquals(status.facing, Facing.WEST);
    }

    @Test
    public void testFailIfPlacedOffGrid() {
        Robot robot = new RobotImpl();
        robot.place(-1, 0, "EAST", grid);
        robot.place(6, 0, "EAST", grid);
        robot.place(0, -1, "EAST", grid);
        robot.place(0, 6, "EAST", grid);
        Status status = robot.reportValues();
        assertNull(status.facing);
    }

    @Test
    public void testFailIfInvalidFacingValue() {
        Robot robot = new RobotImpl();
        robot.place(0, 6, "SOUTHEAST", grid);
        Status status = robot.reportValues();
        assertNull(status.facing);
    }


}





