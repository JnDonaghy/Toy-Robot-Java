package Controllers;

import Models.Grid;
import Models.Robot;

import java.util.Scanner;

//Controller to handle user input
public class Controller {
    Grid grid;
    Robot robot;
    Scanner scanner;

    public Controller(Grid grid, Robot robot) {
        this.grid = grid;
        this.robot = robot;
        scanner = new Scanner(System.in);
    }

    //a loop that will run until the user terminates the program (by closing the console or typing 'quit')
    //each loop waits for user input, then attempts to execute.
    public void listenForCommands() {
        System.out.println("Running Toy Robot");
        System.out.println("Enter commands on your console. View ReadMe for commands");
        boolean done = false;
        while (!done) {
            done = listenForCommand();
        }
    }

    private boolean listenForCommand() {
        // Using Scanner for Getting Input from User
        String command = scanner.nextLine();
        return executeCommand(command);
    }

    //executes a given command.
    public boolean executeCommand(String command) {
        String commandUpper = command.toUpperCase();
        //we split to identify a PLACE command (or any command with parameters)
        //and identify the command type for the switch statement.
        String[] split = commandUpper.split(" ");
        if (split.length > 1) commandUpper = split[0];

        switch (commandUpper.trim()) {
            case "PLACE":
                //validate that we got the correct number of parameters, and pass them through to the robot.
                //then pass the command onto the robot.
                if (split.length != 4) {
                    System.out.println("PLACE command must be passed with 3 space separated parameters x, y, facing eg 'PLACE 0 0 EAST'");
                    return true;
                }
                String xs = split[1];
                String ys = split[2];
                String fs = split[3];
                robot.place(xs, ys, fs, grid);

                return false;
            case "MOVE":
                robot.move(grid);
                return false;
            case "LEFT":
                robot.left();
                return false;
            case "RIGHT":
                robot.right();
                return false;
            case "REPORT":
                robot.report();
                return false;
            case "QUIT":
                return true;
            default:
                System.out.println(command + " is not a valid input");
                return false;
        }
    }


}
