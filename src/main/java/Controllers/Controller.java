package Controllers;

import Models.Grid;
import Models.Robot;

import java.util.Scanner;
public class Controller {
    Grid grid;
    Robot robot;
    Scanner scanner ;

    public Controller(Grid grid, Robot robot) {
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

    public boolean executeCommand(String command){
        String commandUpper = command.toUpperCase();
        String[] split = commandUpper.split(" ");
        if(split.length > 1) commandUpper = split[0];
        switch (commandUpper){
            case "PLACE":
                String xs = split [1];
                String ys = split [2];
                String fs = split [3];
                try {
                    int x = Integer.parseInt(xs);
                    int y = Integer.parseInt(ys);
                    robot.place(x, y, fs, grid);
                }
                catch (Exception e){
                    //bad value passed
                    System.out.println("invalid parameter passed to Place Command");
                }
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
            case "READFILE":
                return false;
            case "QUIT":
                return true;
            default:
                System.out.println(command + " is not a valid input");
                return false;
        }
    }






}
