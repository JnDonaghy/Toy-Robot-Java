package Models;

//interface for the robot object. contains functions relevant to given requirements.
public interface Robot {

    //places the robot with a given position and facing
    void place(int x, int y, String facing, Grid grid);

    //alternative to place that accepts and parses strings for x and y
    void place(String x, String y, String facing, Grid grid);

    //move the robot forward 1 space
    void move(Grid grid);

    //turns the robot left
    void left();

    //turns the robot right
    void right();

    //reports the current status of the robot
    String report();

    //returns the status of the robot as an object for tests.
    Status reportValues();

}


