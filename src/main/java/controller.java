
import Models.Grid;
import Models.Robot;

import java.util.Scanner;
public class controller {
    Grid grid;
    Robot robot;
    Scanner scanner ;

    public controller(Grid grid, Robot robot) {
        this.grid = grid;
        this.robot = robot;
        scanner = new Scanner(System.in);
    }

    public void listenForCommands(){
        boolean done = false;
        while(!done){
            done = listenForCommand();
        }
    }

    private boolean listenForCommand(){

            // Using Scanner for Getting Input from User
            String command = scanner.nextLine();

            return executeCommand(command);
    }

    private boolean executeCommand(String command){
        String commandUpper = command.toUpperCase();
        switch (commandUpper){
            case "PLACE":
                return false;
            case "MOVE":
                return false;
            case "LEFT":
                return false;
            case "RIGHT":
                return false;
            case "REPORT":
                return false;
            case "READFILE":
                return false;
            case "QUIT":
                return true;
            default:
                return false;
        }
    }

    //TODO: Decide weather to pass map to Robot, or keep map boundry logic in controller. leaning to robot.

    public void placeRobot(){

    }





}
