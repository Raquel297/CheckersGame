/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javanetbeanstest;
import java.util.Scanner;

/**
 *
 * @author Raquel A. 
 */
public class JavaNetBeansTest{ //Automatically creates the class for you!!!!
    /*
     * @param args the command line arguments
     * 
     */
    public static void populateBoard(char[][] board){
       for(int i = 0; i <= 7; i++){
           for(int j = 0; j <=7; j++){
               /*
                * Here, we place the pieces on the board
                * The round pieces on the board will be placed onto only the black squares
                * By seeing the board displayed, one can tell which squares are black and white
                * The round pieces are represented as W or B. The white pieces are W and 
                * the black pieces are B. When I pursue graphics programming in java,
                * the board will be drawn more realistically with actual colors and shapes. 
                */
                if((i <= 2) && ((i % 2 == 0 && j % 2 == 0) ||(i % 2 != 0 && j % 2 != 0))){
                   board[i][j] = 'W'; 
                }
                if((i >= 5 && i <= 7) && ((i % 2 == 0 && j % 2 == 0) ||(i % 2 != 0 && j % 2 != 0))){
                   board[i][j] = 'B'; 
                }
                /*
                 * This is where we display each square with or without a piece
                 * If there are no round pieces (W or B) to display, nothing in the square will display
                 */
                /*
                 * Java uses UTF-16 Encoding where characters are mapped to integers based on 
                 * their unicode representation. In java, null is represented as 0.
                 * Therefore, if a board square is not filled with W or B, it is empty and 
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
    /*
     * The minimax algorithm is typically modified and the modifications depend on what game we are playing
     * This standardized minimax algorithm presumes that there are two possible game states per player. 
     * So the game tree looks like a binary tree with subtrees that are min or max heaps.
     * When we play checkers, however, the level right after the root contains 9 possible game states.
     * Therefore, the game tree will look very different and thus we'll have to modify our minimax 
     * algorithm to work on a tree like that accordingly.
     * We also implement alpha-beta pruning which can significantly reduce the running-time of the algorithm. 
     */
    static int MAX = Integer.MAX_VALUE;
    static int MIN = Integer.MIN_VALUE;
    public static int miniMax(int depth, int height, int position, boolean isMaxPlayer, char[][] board, int alpha, int beta){
        if(depth == height){ //If we reached a possible ending game state 
           int evaluation = staticEvaluation(board);
           if(evaluation == -5000){
               whoWon(evaluation);
               return evaluation;
           }
           else if(evaluation == 5000){
               whoWon(evaluation);
               return evaluation;
           }
        } 
        if(isMaxPlayer){ //If it is the AI's turn (the player who wants to maximize their score)
            int best = MIN;
            for(int i = 0; i < 8; i++){ 
                int value = miniMax(depth + 1, height, 7*position + i, false, board, alpha, beta);
                best = Math.max(best, value);
                alpha = Math.max(best, alpha);
                if(beta <= alpha){
                    break;
                }

            }
            return best;
        }
        else{
            int best = MAX;
            for(int i = 0; i < 8; i++){
                int value = miniMax(depth + 1, height, 7*position + i, true, board, alpha, beta);
                best= Math.min(best, value);
                beta = Math.min(best, beta);
                if(beta <= alpha){
                    break;
                }
            }
            return best;
        }
    }   
    //This method calculates the height of the game tree.
    public static int log7(int n){
        if(n == 1){
            return 0;
        }
        return 1+log7(n/7);
    }
    /* This method determines the score of a board after a move is made by the AI player.
     * I used the simplest mathematical way to determine the evaluation.
     * Evaluation = # of AI's pieces - # of human's pieces. 
     * Of course, there are other features I will add later on (after I finish the GUI)
     * that is a better evaluator for the scores of different board positions, but for now
     * I am only a novice checkers player. 
     * Variable countW represents the number of the AI's checkers pieces
     * and countB represents the number of the human's checkers pieces. 
     */
    public static int staticEvaluation(int[][] board){
        int countW = 0, countB = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(board[i][j] == 'W'){
                    countW += 1;
                }
                else if(board[i][j] == 'B'){
                    countB += 1;
                }
            }
        }
        /* 
         * If the value of staticEvaluation() is greater than 0, we 
         * can predict that the AI should likely take that path on the tree.
         * If the value is less than 0, we know that the human should likely take that path on the tree. 
         * If either countW or countB are 0, then either the AI lost or the human lost
         */
        if(countW == 0){
            return -5000;
        }
        else if(countB == 0){
             return 5000;
        }
        return countW - countB; 
    }
    /*
     * We need to figure out if either the AI or human won the checkers game. 
     * This method does just that. It returns true if the AI won and false if the 
     * human won or if the game is still in session. 
     */
    public static void whoWon(int value){
        if(value == 5000){
            System.out.println("I won! You lose! Aha!");
        }
        else{
            System.out.println("I lost! You won... no fair!");
        }
    }
    
    public static boolean isMoveLegal(int coordinate1, int coordinate2, char[][] board){
        if(coordinate1 < 0 || coordinate1 > 7 || coordinate2 < 0 || coordinate2 > 7){
           return false;
        }
        //We check to see if the square is not empty. You can only move onto an empty square.
        if(board[coordinate1][coordinate2] != 0){
            return false;
        }
        //We check to see if the coordinates picked are allowed. You can only move diagonally in checkers.
        if((coordinate1 % 2 != 0 && coordinate2 % 2 == 0) || (coordinate1 % 2 == 0 && coordinate2 % 2 != 0)){
           return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        /*
         * I created a 2-d array to represent the checkers board. 
         * The checkers board has 64 squares total, with an 8 squares per row and column
         * I think it is unnecessary to store 8 in a final constant because a standardized 
         * checkers board is of dimensions 8 by 8
         */
        Scanner read = new Scanner(System.in);
        char[][] board = new char[8][8]; 
        populateBoard(board);
        //I still need to figure out what the height of the game tree is.
        int depth = 0, height = log7(64), position = 0, alpha = 0, beta = 0; 
        boolean isMaxPlayer = true;
        //Variables coor1 and coor2 represent the coordinates the human player chooses 
        int coor1, coor2; 
        System.out.println("Make a move. Enter two numeric coordinates in the range of 0 to 7 inclusive."
                + "Remember, the move must be legal.");
        coor1 = read.nextInt();
        coor2 = read.nextInt();
        while(isMoveLegal(coor1, coor2, board) == false){
            System.out.println("Illegal move. Try again.");
            coor1 = read.nextInt();
            coor2 = read.nextInt();
            isMoveLegal(coor1, coor2, board);
        }
        //This is to be done three weeks from August 12th, 2020. The board will be updated directly with the GUI
        //updateBoard(coor1, coor2, board[][]);
        int value = miniMax(depth, height, position, isMaxPlayer, board, alpha, beta);
        
       
    }
    
}
