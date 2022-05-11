package unitTests;

import Models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class inputTests {

    //TODO: update to use Controller
    Grid grid;
    @Before
    public void beforeAll(){
        grid.init(5,5);
    }
    public void testCreate() {
        // should report current robot status
        Robot robot = new RobotImpl();
        assert(robot != null );
        Status status = robot.reportValues();
        assertNull(status.x);
    }

    @Test
    public void testPlace() {
        //Should create a robot object if valid parameters passed
        Robot robot = new RobotImpl();
        robot.place(0,0, "East");
        Status status = robot.reportValues();
        assertEquals(status.x, 0);
        assertEquals(status.y, 0);
        assertEquals(status.facing, Facing.EAST);
    }

    @Test
    public void testReport() {
        //Should create a robot object if valid parameters passed
        Robot robot = new RobotImpl();
        robot.place(0,0, "East");
        String status = robot.reportString();
        String expectStatus = "0,0,EAST";
        assertEquals(status, expectStatus);
    }
    @Test
    public void testMove() {
        //Should create a robot object if valid parameters passed
        Robot robot = new RobotImpl();
        robot.place(0,0, "East");
        robot.move();
        Status status = robot.reportValues();
        assertEquals(status.x, 1);
        assertEquals(status.y, 0);
        assertEquals(status.facing, Facing.EAST);
    }
    @Test
    public void testTurnLeft(){
        Robot robot = new RobotImpl();
        robot.place(0,0, "East");
        robot.left();
        Status status = robot.reportValues();
        assertEquals(status.x, 0);
        assertEquals(status.y, 0);
        assertEquals(status.facing, Facing.NORTH);
    }
    @Test
    public void testTurnRight(){
        Robot robot = new RobotImpl();
        robot.place(0,0, "East");
        robot.right();
        Status status = robot.reportValues();
        assertEquals(status.x, 0);
        assertEquals(status.y, 0);
        assertEquals(status.facing, Facing.SOUTH);
    }
    @Test
    public void testFailIfInvalidNorth(){
        Robot robot = new RobotImpl();
        robot.place(0,5, "NORTH");
        robot.move();
        Status status = robot.reportValues();
        assertEquals(status.x, 0);
        assertEquals(status.y, 5);
        assertEquals(status.facing, Facing.NORTH);
    }
    @Test
    public void testFailIfInvalidEAST(){
        Robot robot = new RobotImpl();
        robot.place(0,5, "NORTH");
        robot.move();
        Status status = robot.reportValues();
        assertEquals(status.x, 0);
        assertEquals(status.y, 5);
        assertEquals(status.facing, Facing.NORTH);
    }
}
