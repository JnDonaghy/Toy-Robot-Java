package Models;

public interface Robot {


    //TODO: PLACE
    void place(int x, int y, String facing,Grid grid);

    //TODO: MOVE
    void move(Grid grid);
    //TODO: LEFT
    void left();
    //TODO: RIGHT
    void right();
    //TODO: REPORT
    String report();

     Status reportValues();

}


