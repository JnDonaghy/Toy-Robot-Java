import Controllers.Controller;
import Models.Grid;
import Models.GridImpl;
import Models.Robot;
import Models.RobotImpl;

public class main {

    //args array: first value: size of grid in X direction
    //            second value: size of grid in Y direction.
    public static void main(String[] args){
        int x = 5, y = 5;
        if(args.length == 2){
            try{
                int tmpx = Integer.parseInt(args[0]);
                int tmpy = Integer.parseInt(args[1]);
                x = tmpx;
                y = tmpy;
            }catch(NumberFormatException e){
                System.out.println("Grid size Arguments invalid, using default, 5,5 grid size");
            }
        }
        Grid grid = new GridImpl(x,y);
        Robot robot = new RobotImpl();
        Controller controller = new Controller(grid, robot);
        controller.listenForCommands();

        System.out.println("Final Robot Status: " + robot.report());

        //TODO: Run code formatting tool
        //TODO: add Comments
        //TODO: add E2E test
        //TODO: add file input if needed.

    }

}
