/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflifeadivMAIN;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.Timer;
import gameoflifeadivOTHER.OtherElements;

/**
 * This class is responsible for translating info on the board to other classes
 * Major component of the overall program
 *
 * @author Adi Venkatesh
 */
public class LifeEngine {
//I chose to do a square board to make my life easier, so height is equal to width

    private int widthBoard;

//These are two gameboards (2d arrays), the update gameboard is where everything is done
//At the beginning, gameBoard is copied to update, and at the end update is copied to gameBoard
    private int[][] update;
    private int[][] gameBoard;

    /*
    PSEUDOCODE FOR TICK METHOD()
    Given two 2D arraylists: 1 is an update, the other is the gameboard.
        update gets updated to equal gameboard
        COUNTED 2D LOOP: Loops through the 2D array by row, followed by column
            initialize temporary counter variable count
            
            COUNTED 2D LOOP: Loops through all the tiles (including itself) around the tile
                DECISION: if the index is itself, then ignore. Otherwise:
                    TRY-CATCH: catchs the error if it tries to access an index out of the range
                        DECISION: If the value at the tile next to the current tile is alive,
                                  add one to the count
                        END OF DECISION            
                    END OF TRY-CATCH    
                END OF DECISION
                
            DECISION: Checks rules for automation: (These updates are assigned to update)
                        - If the cell has less than 2 or more than 3 neighbors, it dies.
                        - If the cell has 3 neighbors, it lives or becomes existent.
                        - Otherwise, do not change the state of the cell
        END OF COUNTED 2D LOOP
        
        Assign gameBoard to the values of placeholder.    
    END OF UPDATE METHOD
        
     */
    /**
     * Updates cells on the board based on the Game of Life rules found online
     */
    public void tick() {
        //2d array gameBoard is being copied to 2d array update
        for (int i = 0; i < gameBoard.length; i++) {
            update[i] = gameBoard[i].clone();
        }

        //For the entire board, go through every tile
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                //Counting neighbours
                int count = 0;

                //For the current tile, go through all the neighbouring tiles
                for (int y = -1; y <= 1; y++) {
                    for (int x = -1; x <= 1; x++) {
                        if (x == 0 && y == 0) {
                        } else {
                            try {
                                if (gameBoard[y + i][x + j] > 0) {
                                    count++;
                                }
                            } catch (Exception e) {
                            }
                        }
                    }
                }

                //Automation Rules (check)
                if (count < 2 || count >= 4) {
                    update[i][j] = -1;
                } else if (count == 3) {
                    update[i][j] = 1;
                }

            }
        }

        //Once board, neighbours, and automation are completed
        //2d array update is copied back to the original 2d array gameBoard
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = update[i].clone();
        }
    }

    /**
     * Responsible for resizing the board in LifeEngine
     * @param widthBoard used to set the width of the 2d arrays
     */
    public void size(int widthBoard) {
        //Assigns parameter widthBoard to a variable in the class
        this.widthBoard = widthBoard;

        //Initializes both arrays with the dimensions of widthBoard (parameter)
        update = new int[widthBoard][widthBoard];
        gameBoard = new int[widthBoard][widthBoard];

        //Calling clear method, performs function
        clear();

    }

    /**
     * Responsible for setting all values in gameBoard to "dead" state (-1) In
     * paintComponent, board will be empty since all cells are in dead state
     */
    public void clear() {
        //This for loop assigns every value in the gameBoard array to -1
        //Using the Arrays.fill method and the for loop it fills in all sub arrays
        for (int i = 0; i < gameBoard.length; i++) {
            Arrays.fill(gameBoard[i], -1);
        }
    }

    /**
     * Responsible for toggling the value stored at (x,y) in gameBoard to a
     * value between -1 or 1 Later comes into use when setting specific values
     * @param x is the x index of where you are accessing gameBoard
     * @param y is the y index of where you are accessing gameBoard
     */
    public void toggle(int x, int y) {

        //The value at index [y][x] is multiplied by -1, toggling it between -1 and 1, and stored
        gameBoard[y][x] *= -1; 
    }

    /**
     * Responsible for the ability to access the gameBoard array from other
     * classes
     *
     * @return gameBoard returns the variable stored in gameBoard in LifeEngine
     */
    public int[][] get() {
        return gameBoard;
    }

    /**
     * Constructor for LifeEngine
     * @param widthBoard takes in the width and height in tiles in order to
     * initialize the 2d arrays
     */
    public LifeEngine(int widthBoard) {
        //sets the size of update and gameBoard
        size(widthBoard);
        //Calling the clear method, performs function
        clear();

    }

}
