package board;

import models.Signal;


public class Board {
    private Signal[][] board = new Signal[3][3];
    private int moveNumber = 1;

    public Board() {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                board[i][j] = Signal._;
            }
        }
    }

    public Signal[][] getBoard() {
        return board;
    }


    public void setCell(int x, int y, Signal signal){
        board[x][y] = signal;
        moveNumber += 1;
    }

    public int getMoveNumber() {
        return moveNumber;
    }
}
