package Models;

public interface Robot {


    //TODO: PLACE
    void place(int x, int y, String facing);

    //TODO: MOVE
    void move();
    //TODO: LEFT
    void left();
    //TODO: RIGHT
    void right();
    //TODO: REPORT
    String reportString();

     Status reportValues();

     void reset();
}


