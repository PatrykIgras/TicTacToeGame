package board;

import models.Signal;

public class PrintBoard {

    private Board board;

    public PrintBoard(Board board) {
        this.board = board;
    }

    public void printBoard() {
        Signal p1 = board.getBoard()[0][0];
        Signal p2 = board.getBoard()[0][1];
        Signal p3 = board.getBoard()[0][2];
        Signal p4 = board.getBoard()[1][0];
        Signal p5 = board.getBoard()[1][1];
        Signal p6 = board.getBoard()[1][2];
        Signal p7 = board.getBoard()[2][0];
        Signal p8 = board.getBoard()[2][1];
        Signal p9 = board.getBoard()[2][2];

        System.out.println(p1 + " | " + p2 + " | " + p3);
        System.out.println("----------");
        System.out.println(p4 + " | " + p5 + " | " + p6);
        System.out.println("----------");
        System.out.println(p7 + " | " + p8 + " | " + p9);
    }

}
