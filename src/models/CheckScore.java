package models;

import board.Board;
import board.PrintBoard;


public class CheckScore {
    private Board board;
    private boolean status;
    private PrintBoard printBoard;


    public CheckScore(Board board, PrintBoard printBoard) {
        this.board = board;
        this.printBoard = printBoard;
    }

    public void score(){
        if (check(Signal.O) == true){
            System.out.println();
            System.out.println();
            printBoard.printBoard();
            System.out.println();
            System.out.println("Wygrały KÓŁKA");
            status = true;
        }
        else if (check(Signal.X) == true){
            System.out.println();
            System.out.println();
            printBoard.printBoard();
            System.out.println();
            System.out.println("Wygrały KRZYŻYKI");
            status = true;
        }
    }

    private boolean check(Signal signal) {
        return checkScore(signal);
    }

    private boolean checkScore(Signal signal) {
        boolean score;
        if (checkHorizon(0, signal) == true)
            score = true;
        else if (checkHorizon(1, signal) == true)
            score = true;
        else if (checkHorizon(2, signal) == true)
            score = true;
        else if (checkVertical(0, signal) == true)
            score = true;
        else if (checkVertical(1, signal) == true)
            score = true;
        else if (checkVertical(2, signal) == true)
            score = true;
        else if (checkSlantL(signal) == true)
            score = true;
        else if (checkSlantR(signal) == true)
            score = true;
        else
            score = false;
        return score;
    }


    private boolean checkVertical(int line, Signal signal) {
        return board.getBoard()[line][0] == signal &&
                board.getBoard()[line][1] == signal &&
                board.getBoard()[line][2] == signal;
    }

    private boolean checkHorizon(int line, Signal signal) {
        return board.getBoard()[0][line] == signal &&
                board.getBoard()[1][line] == signal &&
                board.getBoard()[2][line] == signal;
    }

    private boolean checkSlantR(Signal signal) {
        return board.getBoard()[0][0] == signal &&
                board.getBoard()[1][1] == signal &&
                board.getBoard()[2][2] == signal;
    }

    private boolean checkSlantL(Signal signal) {
        return board.getBoard()[2][0] == signal &&
                board.getBoard()[1][1] == signal &&
                board.getBoard()[0][2] == signal;
    }

    public boolean isStatus() {
        return status;
    }
}
