import Controllers.Controller;
import Models.Grid;
import Models.GridImpl;
import Models.Robot;
import Models.RobotImpl;

public class main {

    //args array: first value: size of grid in X direction
    //            second value: size of grid in Y direction.
    public static void main(String[] args) {
        int x = 5, y = 5;
        if (args.length == 2) {
            try {
                int tmpx = Integer.parseInt(args[0]);
                int tmpy = Integer.parseInt(args[1]);
                x = tmpx;
                y = tmpy;
            } catch (NumberFormatException e) {
                System.out.println("Grid size Arguments invalid, using default, 5,5 grid size");
            }

            //IMPL file input via commandline here:
            //Skipped for time
            //would allow easy e2e/integration testing
            //if(args.length == 1 || args.length==3)
            //read file
            //would break current try parseint logic, and readfile logic into their own methods
            //and call the relevent from each of the 3 possible combinations
            //1 param - fileName given
            //2 params, x, y grid size given
            //3 params, x, y grid size + filename given
            //then:
            //after create controller but before listenForCommands()
            //loop through each line in the given file, and pass each line through to controller.executeCommand()
            //could choose to not run regular toyRobot listener if file is given, functionality could be desirable.
        }

        //create grid, robot and controller, and begin listening for commands
        Grid grid = new GridImpl(x, y);
        Robot robot = new RobotImpl();
        Controller controller = new Controller(grid, robot);
        controller.listenForCommands();

        //the user has quit the program - print final status to console.
        if (robot.reportValues().facing != null) System.out.println("Final Robot Status: " + robot.report());
        else System.out.println("Robot never Placed");


    }

}
