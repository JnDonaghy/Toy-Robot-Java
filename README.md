# Toy-Robot-Java
Toy robot coding challenge

To see challenge requirements see requirements.txt/requirements2.txt

<b>Intro</b><br/>
Toy Robot is a Console java application where a user can move a robot around on a grid.

The Main method is located at main/java/main.java

The code is designed in a basic MVC implementation, where the View is just the command window (cmd/terminal/shell of choice)<br/> 
Controller and model classes can be found under their respective packages in the main/java folder

To compile and run the program you will need the java 8 JDK and JRE installed on your system, as well as Maven.<br/>
all commands are to be run from the Toy Robot directory, using a cmd window or equivalent. 

<br/><b>compiling the code</b><br/>
Execute the following command to compile the code:

`````` 
        mvn install 
``````
This will create and populate a target folder in ToyRobot directory.

<br/><b>Running Tests</b><br/>
To run unit tests, use ````mvn test````

<br/><b>Executing the program</b><br/>
To execute the code execute this command:
````
    java -jar target/ToyRobot-1.0.0.jar
````
You will get a prompt telling you that the program is running, and to provide input.

By default, ToyRobot will run with a grid size of 5x5. this can be overloaded with input parameters for a custom size grid.
<br/> for example, to create a grid 100x100 run the following
````
    java -jar target/ToyRobot-1.0.0.jar 100 100
````

<br/><b>Driving the robot</b><br/>
The robot can be driven by 5 commands. Any invalid commands will be ignored. Inputs are not case-sensitive

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>PLACE x y facing</b><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;This places the robot on the board, none of the other commands will function<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;until place has been executed at least once. <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Example: 'PLACE 2 3 EAST' will place the robot at x=2, y=3, facing east<br/>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>MOVE</b><br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Moves the robot in the direction it is facing by one square. Can not move off the grid. <br/>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>LEFT</b> <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Turns the robot left (changes it's Facing) <br/>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>RIGHT</b> <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Turns the robot right (changes it's Facing) <br/>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>REPORT</b> <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Prints the current robot status to the console. Format: 'x,y,facing' <br/>

When finished with the program, users can type <b>quit</b> to terminate the process. 

<br/><b>Implementation Notes</b><br/>
Due to time limitations read file and E2E tests were skipped. <br/>
My proposed implementation for read file functionality is listed in the main method in comments.<br/>
End to End (E2E/Integration) tests would be best served through readFile functionality, as then you could execute the<br/> 
program with a list of commands, listen to the output and validate it is what is expected.<br/>
This would allow the test to function as a full E2E test, executing through the main method. 

Beyond that, other tools I would like to have set up prior to calling something 'production ready' would be<br/> 
formatting/code compliance tools to run automatically on committing to git. <br/>
This helps ensure a reasonable level of code quality moving forward



