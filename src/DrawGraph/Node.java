package DrawGraph;

import java.awt.Color;

/**
 *
 * @author Joshua Raiser
 */
public class Node {

    int x, y;
    String name;
    boolean init;

    public Node(String myName, int myX, int myY) {
        x = myX;
        y = myY;
        name = myName;
        init = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

}
