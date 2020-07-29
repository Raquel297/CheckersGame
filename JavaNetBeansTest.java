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
                * the black pieces are Y. When I pursue graphics programming in java,
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
    /*
     * The minimax algorithm is typically modified and the modifications depend on what game we are playing
     * This standardized minimax algorithm presumes that there are two possible game states per player. 
     * So the game tree looks like a binary tree with subtrees that are min or max heaps.
     * When we play checkers, however, the level right after the root contains 9 possible game states.
     * Therefore, the game tree will look very different and thus we'll have to modify our minimax 
     * algorithm to work on a tree like that accordingly.
     * We also implement alpha-beta pruning which can significantly reduce the running-time of the algorithm. 
     */
    int MAX = 1000;
    int MIN = -1000;
    public int miniMax(int depth, int height, int position, boolean isMaxPlayer, int[][] board, int alpha, int beta){
        if(depth == height){ //If we reached a possible ending game state 
           int evaluation = staticEvaluation(board);
           if(evaluation == -5000){
               break;
           }
           else if(evaluation == 5000){
               break;
           }
        } 
        if(isMaxPlayer){ //If it is the AI's turn (the player who wants to maximize their score)
            int best = MIN;
            for(int i = 0; i < 2; i++){ //We only count  up to 2 because we assume we are dealing with a binary search tree for now
                int value = miniMax(depth + 1, height, 2*position + i, false, board, alpha, beta);
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
            for(int i = 0; i < 2; i++){
                int value = miniMax(depth + 1, height, 2*position + i, true, board, alpha, beta);
                best= Math.min(best, value);
                beta = Math.min(best, beta);
                if(beta <= alpha){
                    break;
                }
            }
            return best;
        }
    }   
    //This method calculates the height of the binary tree. It will be modified later to fit the checkers game tree
    public static int log2(int n){
        if(n == 1){
            return 0;
        }
        return 1+log2(n/2);
    }
    /* This method determines the score of a board after a move is made by the AI player.
     * I used the simplest mathematical way to determine the evaluation.
     * Evaluation = # of AI's pieces - # of human's pieces. 
     * Of course, there are other features I will add later on (after I finish the GUI)
     * that is a better evaluator for the scores of different board positions, but for now
     * I am only a novice checkers player. 
     * Variable countX represents the number of the AI's checkers pieces
     * and countY represents the number of the human's checkers pieces. 
     */
    public static int staticEvaluation(int[][] board){
        int countX = 0, countY = 0;
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                if(board[i][j] == 'X'){
                    countX += 1;
                }
                else if(board[i][j] == 'Y'){
                    countY += 1;
                }
            }
        }
        /* 
         * If the value of staticEvaluation() is greater than 0, we 
         * know that the AI is winning so far. 
         * If the value is less than 0, we know that the human is winning so far. 
         * If either countX or countY are 0, then either the AI lost or the human lost
         */
        if(countX == 0){
            return -5000;
        }
        else if(countY == 0){
             return 5000;
        }
        return countX - countY; 
    }
    /*
     * We need to figure out if either the AI or human won the checkers game. 
     * This method does just that. It returns true if the AI won and false if the 
     * human won.
     */
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
        //miniMax(); To be created fully soon
        
    }
    
}
