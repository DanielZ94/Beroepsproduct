import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class MoveTest {

    /**
     * simple JUnit test to test if the movement system is working correctly
     */

    private int rows = 0; // the row in which the player is located
    private int columns = 0; // the column in which the player is located
    private Point point = new Point(); // x and y location
    private String[][] grid = { // simplified level
            {"g", "w", "g",    "g", "g", "g", "g", "g", "g", "g"},
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
     * checks if left is a legal move
     */

    public void left() {
        if (columns <= 0|| grid[rows][columns-1].equals("w")) {
            System.out.println("you can't go left here");
        } else if (grid[rows][columns-1].equals("g") || grid[rows][columns-1].equals("k100")||
                grid[rows][columns-1].equals("k200") || grid[rows][columns-1].equals("k300")||
                Playfield.grid[rows][columns-1].equals("b100") && Playfield.keyValue == 100 ||
                Playfield.grid[rows][columns-1].equals("b200") && Playfield.keyValue == 200 ||
                Playfield.grid[rows][columns-1].equals("b300") && Playfield.keyValue == 300) {
            columns--;
            point.setLocation(columns, rows);
            System.out.println(point);
        }
    }

    /**
     * checks if right is a legal move
     */

    public void right() {
        if (grid[rows][columns+1].equals("w") || columns >= 9) {
            System.out.println("you can't go right here");
        } else if (grid[rows][columns+1].equals("g") || grid[rows][columns+1].equals("k100")||
                    grid[rows][columns+1].equals("k200") || grid[rows][columns+1].equals("k300")||
                    Playfield.grid[rows][columns+1].equals("b100") && Playfield.keyValue == 100 ||
                    Playfield.grid[rows][columns+1].equals("b200") && Playfield.keyValue == 200 ||
                    Playfield.grid[rows][columns+1].equals("b300") && Playfield.keyValue == 300) {
                columns++;
                point.setLocation(columns, rows);
                System.out.println(point);
            }
    }


    /**
     * checks if up is a legal move
     */

    public void up() {
        if (rows <= 0|| grid[rows-1][columns].equals("w")) {
            System.out.println("you can't go up here");
        } else if (grid[rows][columns-1].equals("g") || grid[rows][columns-1].equals("k100")||
                grid[rows][columns-1].equals("k200") || grid[rows][columns-1].equals("k300")||
                Playfield.grid[rows-1][columns].equals("b100") && Playfield.keyValue == 100 ||
                Playfield.grid[rows-1][columns].equals("b200") && Playfield.keyValue == 200 ||
                Playfield.grid[rows-1][columns].equals("b300") && Playfield.keyValue == 300) {
            rows--;
            point.setLocation(columns, rows);
            System.out.println(point);
        }
    }

    /**
     * checks if down is a legal move
     */

    public void down() {
        if (grid[rows+1][columns].equals("w") || columns >= 9) {
            System.out.println("you can't go down here");
        } else if (grid[rows+1][columns].equals("g") || grid[rows+1][columns].equals("k100")||
                grid[rows+1][columns].equals("k200") || grid[rows+1][columns].equals("k300")||
                Playfield.grid[rows+1][columns].equals("b100") && Playfield.keyValue == 100 ||
                Playfield.grid[rows+1][columns].equals("b200") && Playfield.keyValue == 200 ||
                Playfield.grid[rows+1][columns].equals("b300") && Playfield.keyValue == 300) {
            rows++;
            point.setLocation(columns, rows);
            System.out.println(point);
        }
    }

    /**
     * simulates movement,
     * if the methods are working correctly, player will end at Point x=4, y=2
     */

    @Test
    public void testGUI() {
        Point expected = new Point(4,2);
        left();  // illegal move
        up();    // illegal move
        right(); // illegal move
        down();  // 0,1
        down();  // 0,2
        down();  // illegal move
        right(); // 1,2
        right(); // 2,2
        right(); // 3,3
        right(); // 4,2
        assertEquals(expected, point); //test passes because point is expected
    }
}
