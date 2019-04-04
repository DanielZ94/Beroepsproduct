import javax.swing.*;
import javax.xml.bind.Marshaller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.logging.Level;

class Move extends JFrame implements KeyListener {

    public int rows = 0; // the row in which the player is located
    public int columns = 0; // the column in which the player is located
    private int attempts = 1; //the number of attempts




    public Move(){

    }


    public void keyTyped(KeyEvent e) {
        //no code here
    }

    /**
     * @param e
     * the key which is pressed
     * you can use the arrow keys to move around
     */

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode(); // number for a certain KeyEvent

        switch (keyCode) {

            //when left key is pressed
            case KeyEvent.VK_LEFT: //moves player to the left
                if (columns > 0 && Playfield.grid[rows][columns-1].equals("g")) {
                    Playfield.grid[rows][columns] = "g";
                    columns--;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.drawGrid();
                } else if (columns > 0 && Playfield.grid[rows][columns-1].equals("k100")) {
                    Playfield.grid[rows][columns] = "g";
                    columns--;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("you found a key");
                    Playfield.keyValue = 100;
                    Playfield.drawGrid();
                } else if (columns > 0 && Playfield.grid[rows][columns-1].equals("k200")) {
                    Playfield.grid[rows][columns] = "g";
                    columns--;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("you found a scissor");
                    Playfield.keyValue = 200;
                    Playfield.drawGrid();
                } else if (columns > 0 && Playfield.grid[rows][columns-1].equals("k300")) {
                    Playfield.grid[rows][columns] = "g";
                    columns--;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("you found a chainsaw");
                    Playfield.keyValue = 300;
                    Playfield.drawGrid();
                } else if (columns > 0 && Playfield.grid[rows][columns-1].equals("b100") && Playfield.keyValue != 100) {
                    Playfield.info.setText("you need a key to open this barricade");
                    Playfield.info.setText("");
                } else if (columns > 0 && Playfield.grid[rows][columns-1].equals("b200") && Playfield.keyValue != 200) {
                    Playfield.info.setText("you need a key to open this barricade");
                } else if (columns > 0 && Playfield.grid[rows][columns-1].equals("b300") && Playfield.keyValue != 300) {
                    Playfield.info.setText("");
                    Playfield.info.setText("you need a chainsaw to break this stump");
                } else if (columns > 0 && Playfield.grid[rows][columns-1].equals("b100") || columns > 0 && Playfield.grid[rows][columns-1].equals("b200") || columns > 0 && Playfield.grid[rows][columns-1].equals("b300")) {
                    Playfield.grid[rows][columns] = "g";
                    columns--;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.drawGrid();
                } else {
                    Playfield.info.setText("you can't go there");
                }
                break;

            //when right key is pressed
            case KeyEvent.VK_RIGHT: //moves player to the right
                if (columns < 9 && Playfield.grid[rows][columns+1].equals("g")) {
                    Playfield.grid[rows][columns] = "g";
                    columns++;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.drawGrid();
                } else if (columns < 9 && Playfield.grid[rows][columns+1].equals("f")) {
                    Playfield.grid[rows][columns] = "g";
                    columns++;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.drawGrid();
                    finish();
                } else if (columns < 9 && Playfield.grid[rows][columns+1].equals("k100")) {
                    Playfield.grid[rows][columns] = "g";
                    columns++;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("");
                    Playfield.info.setText("you found a key");
                    Playfield.keyValue = 100;
                    Playfield.drawGrid();
                } else if (columns < 9 && Playfield.grid[rows][columns+1].equals("k200")) {
                    Playfield.grid[rows][columns] = "g";
                    columns++;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("you found a scissor");
                    Playfield.keyValue = 200;
                    Playfield.drawGrid();
                } else if (columns < 9 && Playfield.grid[rows][columns+1].equals("k300")) {
                    Playfield.grid[rows][columns] = "g";
                    columns++;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("you found a chainsaw");
                    Playfield.keyValue = 300;
                    Playfield.drawGrid();
                } else if (columns < 9 && Playfield.grid[rows][columns+1].equals("b100") && Playfield.keyValue != 100) {
                    Playfield.info.setText("you need a key to open this barricade");
                } else if (columns < 9 && Playfield.grid[rows][columns+1].equals("b200") && Playfield.keyValue != 200) {
                    Playfield.info.setText("");
                } else if (columns < 9 && Playfield.grid[rows][columns+1].equals("b300") && Playfield.keyValue != 300) {
                    Playfield.info.setText("you need a chainsaw to break this stump");
                } else if (columns < 9 && Playfield.grid[rows][columns+1].equals("b100") || columns < 9 && Playfield.grid[rows][columns+1].equals("b200") || columns < 9 && Playfield.grid[rows][columns+1].equals("b300")) {
                    Playfield.grid[rows][columns] = "g";
                    columns++;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.drawGrid();
                } else {
                    Playfield.info.setText("you can't go there");
                }
                break;

            //when up key is pressed
            case KeyEvent.VK_UP: //moves player up
                if (rows > 0 && Playfield.grid[rows-1][columns].equals("g")) {
                    Playfield.grid[rows][columns] = "g";
                    rows--;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.drawGrid();
                } else if (rows > 0 && Playfield.grid[rows-1][columns].equals("k100")) {
                    Playfield.grid[rows][columns] = "g";
                    rows--;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("you found a key");
                    Playfield.keyValue = 100;
                    Playfield.drawGrid();
                } else if (rows > 0 && Playfield.grid[rows-1][columns].equals("k200")) {
                    Playfield.grid[rows][columns] = "g";
                    rows--;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("you found a scissor");
                    Playfield.keyValue = 200;
                    Playfield.drawGrid();
                } else if (rows > 0 && Playfield.grid[rows-1][columns].equals("k300")) {
                    Playfield.grid[rows][columns] = "g";
                    rows--;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("you found a chainsaw");
                    Playfield.keyValue = 300;
                    Playfield.drawGrid();
                } else if (rows > 0 && Playfield.grid[rows-1][columns].equals("b100") && Playfield.keyValue != 100) {
                    Playfield.info.setText("you need a key to open this barricade");
                } else if (rows > 0 && Playfield.grid[rows-1][columns].equals("b200") &&Playfield. keyValue != 200) {
                    Playfield.info.setText("you need a scissor to cut this bush");
                } else if (rows > 0 && Playfield.grid[rows-1][columns].equals("b300") &&Playfield. keyValue != 300) {
                    Playfield.info.setText("you need a chainsaw to break this stump");
                } else if (rows > 0 && Playfield.grid[rows-1][columns].equals("b100") || rows > 0 && Playfield.grid[rows-1][columns].equals("b200") || rows > 0 && Playfield.grid[rows-1][columns].equals("b300")) {
                    Playfield.grid[rows][columns] = "g";
                    rows--;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.drawGrid();
                } else {
                    Playfield.info.setText("you can't go there");
                }
                break;

            //when down key is pressed
            case KeyEvent.VK_DOWN: //moves player down
                if (rows < 9 && Playfield.grid[rows+1][columns].equals("g")) {
                    Playfield.grid[rows][columns] = "g";
                    rows++;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.drawGrid();
                } else if (rows < 9 && Playfield.grid[rows+1][columns].equals("f")) {
                    Playfield.grid[rows][columns] = "g";
                    rows++;
                    Playfield.grid[rows][columns] = "p" ;
                    Playfield.drawGrid();
                    finish();
                } else if (rows < 9 && Playfield.grid[rows+1][columns].equals("k100")) {
                    Playfield.grid[rows][columns] = "g";
                    rows++;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("you found a key");
                    Playfield.keyValue = 100;
                    Playfield.drawGrid();
                } else if (rows < 9 && Playfield.grid[rows+1][columns].equals("k200")) {
                    Playfield.grid[rows][columns] = "g";
                    rows++;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("you found a scissor");
                    Playfield.keyValue = 200;
                    Playfield.drawGrid();
                } else if (rows < 9 && Playfield.grid[rows+1][columns].equals("k300")) {
                    Playfield.grid[rows][columns] = "g";
                    rows++;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.info.setText("you found a chainsaw");
                    Playfield.keyValue = 300;
                    Playfield.drawGrid();
                } else if (rows < 9 && Playfield.grid[rows+1][columns].equals("b100") && Playfield.keyValue != 100) {
                    Playfield.info.setText("you need a key to open this barricade");
                } else if (rows < 9 && Playfield.grid[rows+1][columns].equals("b200") && Playfield.keyValue != 200) {
                    Playfield.info.setText("you need a scissor to cut this bush");
                } else if (rows < 9 && Playfield.grid[rows+1][columns].equals("b300") && Playfield.keyValue != 300) {
                    Playfield.info.setText("you need a chainsaw to break this stump");
                } else if (rows < 9 && Playfield.grid[rows+1][columns].equals("b100") || rows < 9 && Playfield.grid[rows+1][columns].equals("b200") || rows < 9 && Playfield.grid[rows+1][columns].equals("b300")) {
                    Playfield.grid[rows][columns] = "g";
                    rows++;
                    Playfield.grid[rows][columns] = "p" ;
                    System.out.println(rows + ", " + columns);
                    Playfield.drawGrid();
                } else {
                    Playfield.info.setText("you can't go there");
                }
                break;

            //when R is pressed
            case KeyEvent.VK_R: //restores the level to it's original state
                rows = 0;
                columns = 0;
                Playfield.keyValue = 0;
                attempts++;
                if (StartMenu.level.equals("level 1")) {
                    String[][] lvl1 = { //level 1
                            {"p", "w", "k300", "w", "k200", "w", "b300", "k100", "w", "w"},
                            {"g", "w", "g", "w", "g", "w", "b200", "w", "w", "w"},
                            {"g", "w", "g", "w", "g", "w", "b300", "w", "w", "w"},
                            {"g", "w", "b200", "w", "b300", "w", "b200", "w", "w", "w"},
                            {"k200", "g", "g", "g", "g", "g", "b300", "g", "g", "w"},
                            {"w", "w", "b200", "w", "b200", "w", "b300", "w", "g", "w"},
                            {"w", "w", "g", "w", "g", "w", "g", "w", "g", "w"},
                            {"w", "w", "g", "w", "g", "w", "g", "w", "g", "w"},
                            {"w", "w", "g", "w", "g", "w", "g", "w", "b200", "w"},
                            {"w", "w", "k300", "w", "k300", "w", "k200", "w", "b100", "f"}
                    };
                    Playfield.grid = lvl1;
                } else if (StartMenu.level.equals("level 2")) {
                    String[][] lvl2 = { //level 2
                            {"p", "w", "w", "w", "w", "g", "b300", "b300", "w", "w"},
                            {"g", "w", "w", "w", "w", "g", "w", "b300", "b300", "k100"},
                            {"g", "w", "w", "w", "w", "g", "w", "w", "w", "w"},
                            {"g", "k100", "g", "g", "g", "g", "g", "g", "g", "g"},
                            {"w", "b100", "w", "b100", "w", "b300", "w", "w", "w", "b200"},
                            {"g", "g", "w", "b200", "w", "b200", "b200", "b200", "b200", "b200"},
                            {"g", "w", "w", "b200", "w", "b200", "w", "w", "w", "b100"},
                            {"g", "g", "w", "b200", "w", "b200", "w", "b300", "b300", "b300"},
                            {"w", "g", "w", "b200", "w", "b200", "w", "b300", "w", "b100"},
                            {"k200", "g", "w", "k300", "w", "b300", "b300", "b300", "w", "f"}
                    };
                    Playfield.grid = lvl2;
                } else {
                    String[][] lvl3 = { //level 3
                            {"p", "w", "k300", "g", "g", "g", "g", "g", "w", "w"},
                            {"g", "w", "w", "w", "w", "w", "w", "g", "w", "w"},
                            {"g", "b300", "g", "g", "g", "k200", "w", "g", "w", "w"},
                            {"g", "w", "w", "w", "w", "w", "w", "g", "w", "w"},
                            {"g", "g", "g", "g", "g", "k300", "w", "g", "w", "w"},
                            {"b200", "w", "w", "w", "w", "w", "w", "g", "w", "w"},
                            {"g", "w", "k100", "g", "w", "g", "g", "g", "w", "w"},
                            {"g", "w", "g", "g", "b300", "g", "w", "g", "g", "b300"},
                            {"g", "w", "w", "w", "w", "w", "w", "g", "w", "b100"},
                            {"g", "g", "g", "g", "g", "g", "g", "g", "w", "f"}
                    };
                    Playfield.grid = lvl3;
                }

                Playfield.drawGrid();
                Playfield.info.setText("level has been reset");
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        //no code here
    }

    public void finish() {  //todo change method so player will return to StartMenu
        Endscreen es = new Endscreen();
        Playfield.drawGrid();
        Playfield.frame.setVisible(false);
    }
}