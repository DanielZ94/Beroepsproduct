import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.Assert.*;

public class MoveTest {
/**
* simple test with a simplified level
*/
    private int rows = 0; // the row in which the player is located
    private int columns = 0; // the column in which the player is located
    private Point point = new Point();
    //Playfield p = new Playfield();
    protected  String[][] grid = { //level 1
            {"p", "w", "g",    "g", "g", "g", "g", "g", "g", "g"},
            {"g", "w", "w",    "w", "w", "g", "g", "g", "g", "g"},
            {"g", "g", "g", "k100", "g", "g", "g", "g", "g", "g"},
            {"w", "w", "w",    "w", "w", "g", "g", "g", "g", "g"},
            {"g", "g", "g",    "g", "g", "g", "g", "g", "g", "g"},
            {"g", "g", "g",    "g", "g", "g", "g", "g", "g", "g"},
            {"g", "g", "g",    "g", "g", "g", "g", "g", "g", "g"},
            {"g", "g", "g",    "g", "g", "g", "g", "g", "g", "g"},
            {"g", "g", "g",    "g", "g", "g", "g", "g", "g", "g"},
            {"g", "g", "g",    "g", "g", "g", "g", "g", "g", "g"}
    };

    /**
    * cheks if left is a legal move
    */
    public void left() {
        if (columns > 1 && grid[rows][columns-1].equals("g") || columns > 1 && grid[rows][columns-1].equals("k100") || columns > 1 && grid[rows][columns-1].equals("k200") ||
            columns > 1 && grid[rows-1][columns].equals("k300")) {
            columns--;
            point.setLocation(columns, rows);
            System.out.println(point);
        } else {
            System.out.println("you can't go left");
        }
    }

    /**
    * cheks if right is a legal move
    */
    public void right() {
        if (columns < 9 && grid[rows][columns+1].equals("g") || columns < 9 && grid[rows][columns+1].equals("k100") ||
                columns < 9 && grid[rows][columns+1].equals("k200") || columns < 9 && grid[rows+1][columns].equals("k300")) {
            columns++;
            point.setLocation(columns, rows);
            System.out.println(point);
        } else {
            System.out.println("you can't go rigth");
        }
    }


    /**
    * cheks if up is a legal move
    */
    public void up() {
        if (rows > 1 && grid[rows-1][columns].equals("g") || rows > 1 && grid[rows-1][columns].equals("k100") ||
                rows > 1 && grid[rows-1][columns].equals("k200") || rows > 1 && grid[rows-1][columns].equals("k300")) {
            rows--;
            point.setLocation(columns, rows);
            System.out.println(point);
        } else {
            System.out.println("you can't go up");
        }
    }

   /**
    * cheks if down is a legal move
    */
    public void down() {
        if (rows > 9) {
            System.out.println("down out of bounds");
        }
        if (rows < 9 && grid[rows+1][columns].equals("g") || rows < 9 && grid[rows+1][columns].equals("k100") ||
                rows < 9 && grid[rows+1][columns].equals("k200") || grid[rows+1][columns].equals("k300")) {
            rows++;
            point.setLocation(columns, rows);
            System.out.println(point);
        } else {
            System.out.println("you can't go down");
        }
    }

    @Test
    public void testGUI() {
        Point expected = new Point(4,2);
        down();  // 0,1
        up();    // 0,1 because up is illegal
        left();  // 0,1 because left is illegal
        down();  // 0,2
        down();  // 0,2 because down is illegal
        right(); // 1,2
        right(); // 2,2
        right(); // 3,2
        right(); // 4,2
        assertEquals(expected, point); //test passes because point is expected

    }
}
