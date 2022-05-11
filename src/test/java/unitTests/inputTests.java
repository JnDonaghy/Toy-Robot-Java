package unitTests;

import Mocks.mockRobot;
import Models.*;
import org.junit.Before;
import org.junit.Test;
import Controllers.*;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class inputTests {

    //TODO: update to use Controllers.Controller
    Grid grid;
    Controller c ;
    ByteArrayOutputStream baos;

    Robot robot;

    @Before
    public void beforeAll(){
        grid = new GridImpl(5,5);
        robot = new mockRobot();
        c = new Controller(grid, robot);
    }

    @Test
    public void testPlace() {
        //Should trigger the robot.place() method
        c.executeCommand("PLACE 0 0 EAST");
        String status = robot.report();
        assertEquals(status, "PLACE 0 0 EAST");
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
    public void testTurnLeft(){
        //Should trigger the robot.left() method
        c.executeCommand("PLACE 0 0 EAST");
        c.executeCommand("LEFT");
        String status = robot.report();
        assertEquals(status, "LEFT");
    }
    @Test
    public void testTurnRight(){
        //Should trigger the robot.right() method
        c.executeCommand("PLACE 0 0 EAST");
        c.executeCommand("RIGHT");
        String status = robot.report();
        assertEquals(status, "RIGHT");
    }


}
