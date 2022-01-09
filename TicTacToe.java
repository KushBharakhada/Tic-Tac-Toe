// Author: Kush Bharakhada
// A 2 player tic-tac-toe game

import java.util.Scanner;

public class TicTacToe {
  
  private static String[] board;
  private static String playerTurn;

  public static void initialArray() {
    // Fill in the board with "-" to start with
    for (int i=0; i<board.length; i++) {
      board[i] = "-";
    }
  }

  public static void displayBoard() {
    // Display to show which numbers correspond to which position
    System.out.println("|1|2|3|");
    System.out.println("|4|5|6|");
    System.out.println("|7|8|9|");
    System.out.println();

    // Current board display
    System.out.println("|" + board[0] + "|" + board[1] + "|" + board[2] + "|");
    System.out.println("|" + board[3] + "|" + board[4] + "|" + board[5] + "|");
    System.out.println("|" + board[6] + "|" + board[7] + "|" + board[8] + "|");
  }

  public static void switchPlayer() {
    if (playerTurn == "X") {
      playerTurn = "O";
    }
    else {
      playerTurn = "X";
    }
  }

  public static void askForPosition() {
    Scanner sc = new Scanner(System.in);
    boolean validPosition = false;

    System.out.println("Player " + playerTurn + "'s turn!");

    while (!validPosition) {
      System.out.print("Enter a position [1-9]: ");
      int position = sc.nextInt();
      // Keep asking for an integer if the input is not between 1 and 9 inclusive
      while (position < 1 || position > 9) {
        System.out.print("Enter a position [1-9]: ");
        position = sc.nextInt();
      }
      System.out.println();

      // Check if board position is taken or not
      if (board[position-1] == "-") {
        board[position-1] = playerTurn;
        validPosition = true;
      }
      else {
        System.out.println("Position is already taken!");
      }
    }
  }

  public static boolean checkRows() {
    boolean winner = false;
    String rowOne = board[0] + board[1] + board[2];
    String rowTwo = board[3] + board[4] + board[5];
    String rowThree = board[6] + board[7] + board[8];

    if (rowOne.equals("XXX") || rowOne.equals("OOO")) {
      winner = true;
    }
    else if (rowTwo.equals("XXX") || rowTwo.equals("OOO")) {
      winner = true;
    }
    else if (rowThree.equals("XXX") || rowThree.equals("OOO")) {
      winner = true;
    }
    return winner;
  }

  public static boolean checkColumns() {
    boolean winner = false;
    String columnOne = board[0] + board[3] + board[6];
    String columnTwo = board[1] + board[4] + board[7];
    String columnThree = board[2] + board[5] + board[8];

    if (columnOne.equals("XXX") || columnOne.equals("OOO")) {
      winner = true;
    }
    else if (columnTwo.equals("XXX") || columnTwo.equals("OOO")) {
      winner = true;
    }
    else if (columnThree.equals("XXX") || columnThree.equals("OOO")) {
      winner = true;
    }
    return winner;
  }

  public static boolean checkDiagonals() {
    boolean winner = false;
    String diagonalOne = board[0] + board[4] + board[8];
    String diagonalTwo = board[6] + board[4] + board[2];

    if (diagonalOne.equals("XXX") || diagonalOne.equals("OOO")) {
      winner = true;
    }
    else if (diagonalTwo.equals("XXX") || diagonalTwo.equals("OOO")) {
      winner = true;
    }
    return winner;
  }

  public static boolean checkWinner() {
    boolean winner = false;
    if (checkRows() || checkDiagonals() || checkColumns()) {
      winner = true;
    }
    return winner;
  }

  public static boolean checkDraw() {
    boolean draw = true;
    // Game is a draw if no "-" remain on the board
    for (int i=0; i<board.length; i++) {
      if (board[i].equals("-")) {
        draw = false;
      }
    }
    return draw;
  }

  public static void main(String[] args) {
    // Initial values
    board = new String[9];
    playerTurn = "X";
    boolean gameOver = false;
     
    initialArray();
    displayBoard();
    while (!gameOver) {
      askForPosition();
      displayBoard();
      if (checkWinner()) {
        System.out.println("The WINNER is " + playerTurn + "!");
        gameOver = true;
      }
      else if (checkDraw()) {
        System.out.println("It is a DRAW!");
        gameOver = true;
      }
      switchPlayer();
    }

    System.out.println("Thank you for playing!"); 
  }

}