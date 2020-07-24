/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetbeanstest;

/**
 *
 * @author Raquel A. 
 */
public class JavaNetBeansTest{ //Automatically creates the class for you!!!!
    /*
     * @param args the command line arguments
     * 
     */
    static void populateBoard(char[][] board){
       for(int i = 0; i <= 7; i++){
           for(int j = 0; j <=7; j++){
               /*
                * Here, we place the pieces on the board
                * The round pieces on the board will be placed onto only the black squares
                * By seeing the board displayed, one can tell which squares are black and white
                * The round pieces are represented as X or Y. The white pieces are X and 
                * the red pieces are Y. When I pursue graphics programming in java,
                * the board will be drawn more realistically with actual colors and shapes. 
                */
                if((i <= 2) && ((i % 2 == 0 && j % 2 == 0) ||(i % 2 != 0 && j % 2 != 0))){
                   board[i][j] = 'X'; 
                }
                if((i >= 5 && i <= 7) && ((i % 2 == 0 && j % 2 == 0) ||(i % 2 != 0 && j % 2 != 0))){
                   board[i][j] = 'Y'; 
                }
                /*
                 * This is where we display each square with or without a piece
                 * If there are no round pieces (X or Y) to display, nothing in the square will display
                 */
                /*
                 * Java uses UTF-16 Encoding where characters are mapped to integers based on 
                 * their unicode representation. In java, null is represented as 0.
                 * Therefore, if a board square is not filled with X or Y, it is empty and 
                 * we need a space between the two border lines of the board
                 */
                if(board[i][j] != 0){ 
                  System.out.print("|" + board[i][j] + "|");
                }
                else{
                    System.out.print("| |");
                }
            }
           /*
            * When we finish displaying a row, we want to make a new line for the next row
           */
            System.out.println();             
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        /*
         * I created a 2-d array to represent the checkers board. 
         * The checkers board has 64 squares total, with an 8 squares per row and column
         * I think it is unnecessary to store 8 in a final constant because a standardized 
         * checkers board is of dimensions 8 by 8
         */
        char[][] board = new char[8][8]; 
        populateBoard(board);
    }
    
}