package unitTests;

import Controllers.Controller;
import Mocks.mockRobot;
import Models.Grid;
import Models.GridImpl;
import Models.Robot;
import Models.RobotImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class inputTest {

    Grid grid;
    Controller c;

    Robot robot;

    @Before
    public void beforeAll() {
        grid = new GridImpl(5, 5);
        robot = new mockRobot();
        c = new Controller(grid, robot);
    }

    @Test
    public void testPlace() {
        //Should trigger the robot.place() method
        c.executeCommand("PLACE 0 0 EAST");
        String status = robot.report();
        assertEquals("PLACE 0 0 EAST", status);
    }

    @Test
    public void testReport() {
        //Should trigger the robot.reportString() method
        c.executeCommand("REPORT");
        String status = robot.report();
        assertEquals(status, "REPORTSTRING");
    }

    @Test
    public void testMove() {
        ////Should trigger the robot.move() method
        c.executeCommand("PLACE 0 0 EAST");
        c.executeCommand("MOVE");
        String status = robot.report();
        assertEquals(status, "MOVE");
    }

    @Test
    public void testTurnLeft() {
        //Should trigger the robot.left() method
        c.executeCommand("PLACE 0 0 EAST");
        c.executeCommand("LEFT");
        String status = robot.report();
        assertEquals(status, "LEFT");
    }

    @Test
    public void testTurnRight() {
        //Should trigger the robot.right() method
        c.executeCommand("PLACE 0 0 EAST");
        c.executeCommand("RIGHT");
        String status = robot.report();
        assertEquals(status, "RIGHT");
    }

    @Test
    public void testFailIfMissingPlaceParams() {
        Robot testRobot = new RobotImpl();
        c = new Controller(grid, testRobot);
        c.executeCommand("PLACE 0 0");
        c.executeCommand("PLACE 0 East 0");
        String status = robot.report();
        assertNull(status);
    }


}
