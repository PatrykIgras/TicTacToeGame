package models;

import board.Board;

import java.util.Random;

public class Computer {
    private Signal signal = Signal._;
    private Men men;
    private Board board;
    private Signal mensSignal = Signal._;
    private int cooX;
    private int cooY;


    public Computer(Men men, Board board) {
        this.men = men;
        this.board = board;
    }

    private void setComputersSignal(Men men1) {
        mensSignal = men1.getMensSignal();
        if (men1.getMensSignal() == Signal.X)
            signal = Signal.O;
        else if (men1.getMensSignal() == Signal.O)
            signal = Signal.X;
        else if (men1.getMensSignal() == null) {
            signal = Signal.X;
        }
    }

    public void computersMove(int moveNumber) {
        if (moveNumber <= 2) {
            randomComputersMove();
        } else if (moveNumber > 2) {
            moveCom();
        }
    }

    private void randomComputersMove() {
        setComputersSignal(men);
        Random ran = new Random();
        cooX = ran.nextInt(3);
        cooY = ran.nextInt(3);
        boolean status = false;

        do {
            if (board.getBoard()[cooX][cooY] != mensSignal) {
                status = true;
            } else {
                cooX = ran.nextInt(3);
                cooY = ran.nextInt(3);
                if (board.getBoard()[cooX][cooY] != mensSignal) {
                    status = true;
                }
            }
        } while (status == false);

        if (status == true) {
            board.setCell(cooX, cooY, signal);
        }
    }

    private void winnersMove() {
        Signal[][] position = board.getBoard();
        //piony
        if (cooY == 0 && position[cooX][1] == Signal._ && position[cooX][2] == Signal._) {
            board.setCell(cooX, cooY + 1, signal);
            cooY += 1;
        }
        //srodki pionowo
        else if (cooY == 1 && position[cooX][0] == Signal._ && position[cooX][2] == Signal._) {
            board.setCell(cooX, cooY + 1, signal);
            cooY += 1;
        }
        //piony cd
        else if (cooY == 1 && position[cooX][2] == Signal._) {
            board.setCell(cooX, cooY + 1, signal);
            cooY += 1;
        } else if (cooY == 2 && position[cooX][1] == Signal._ && position[cooX][0] == Signal._) {
            board.setCell(cooX, cooY - 1, signal);
            cooY -= 1;
        } else if (cooY == 1 && position[cooX][0] == Signal._) {
            board.setCell(cooX, cooY - 1, signal);
            cooY -= 1;

            //poziomy
        } else if (cooX == 0 && position[1][cooY] == Signal._ && position[2][cooY] == Signal._) {
            board.setCell(cooX + 1, cooY, signal);
            cooX += 1;
        }

        // Srodki poziomo
        else if (cooX == 1 && position[0][cooY] == Signal._ && position[2][cooY] == Signal._) {
            board.setCell(cooX + 1, cooY, signal);
            cooX += 1;
        }

        //poziomy cd
        else if (cooX == 1 && position[2][cooY] == Signal._) {
            board.setCell(cooX + 1, cooY, signal);
            cooX += 1;
        } else if (cooX == 2 && position[1][cooY] == Signal._ && position[0][cooY] == Signal._) {
            board.setCell(cooX - 1, cooY, signal);
            cooX -= 1;
        } else if (cooX == 1 && position[0][cooY] == Signal._) {
            board.setCell(cooX - 1, cooY, signal);
            cooX -= 1;
        }

    }

    public void blockMove() {
        Signal[][] position = board.getBoard();

        if (position[0][0] == mensSignal && position[0][1] == mensSignal && position[0][2] != mensSignal && position[0][2] != signal) {
            board.setCell(0, 2, signal);
            cooX = 0;
            cooY = 2;
        } else if (position[1][0] == mensSignal && position[1][1] == mensSignal && position[1][2] != mensSignal && position[1][2] != signal) {
            board.setCell(1, 2, signal);
            cooX = 1;
            cooY = 2;
        } else if (position[2][0] == mensSignal && position[2][1] == mensSignal && position[2][2] != mensSignal && position[2][2] != signal) {
            board.setCell(2, 2, signal);
            cooX = 2;
            cooY = 2;
        } else if (position[0][1] == mensSignal && position[0][2] == mensSignal && position[0][0] != mensSignal && position[0][0] != signal) {
            board.setCell(0, 0, signal);
            cooX = 0;
            cooY = 0;
        } else if (position[1][1] == mensSignal && position[1][2] == mensSignal && position[1][0] != mensSignal && position[1][0] != signal) {
            board.setCell(1, 0, signal);
            cooX = 1;
            cooY = 0;
        } else if (position[2][1] == mensSignal && position[2][2] == mensSignal && position[2][0] != mensSignal && position[2][0] != signal) {
            board.setCell(2, 0, signal);
            cooX = 2;
            cooY = 0;
        } else if (position[1][0] == mensSignal && position[2][0] == mensSignal && position[0][0] != mensSignal && position[0][0] != signal) {
            board.setCell(0, 0, signal);
            cooX = 0;
            cooY = 0;
        } else if (position[1][1] == mensSignal && position[2][1] == mensSignal && position[0][1] != mensSignal && position[0][1] != signal) {
            board.setCell(0, 1, signal);
            cooX = 0;
            cooY = 1;
        } else if (position[1][2] == mensSignal && position[2][2] == mensSignal && position[0][2] != mensSignal && position[0][2] != signal) {
            board.setCell(0, 2, signal);
            cooX = 0;
            cooY = 2;
        } else if (position[0][0] == mensSignal && position[1][0] == mensSignal && position[2][0] != mensSignal && position[2][0] != signal) {
            board.setCell(2, 0, signal);
            cooX = 2;
            cooY = 0;
        } else if (position[0][1] == mensSignal && position[1][1] == mensSignal && position[2][1] != mensSignal && position[2][1] != signal) {
            board.setCell(2, 1, signal);
            cooX = 2;
            cooY = 1;
        } else if (position[0][2] == mensSignal && position[1][2] == mensSignal && position[2][2] != mensSignal && position[2][2] != signal) {
            board.setCell(2, 2, signal);
            cooX = 2;
            cooY = 2;
        } else if (position[1][1] == mensSignal && position[0][2] == mensSignal && position[2][0] != mensSignal && position[2][0] != signal) {
            board.setCell(2, 0, signal);
            cooX = 2;
            cooY = 0;
        } else if (position[1][1] == mensSignal && position[2][1] == mensSignal && position[0][2] != mensSignal && position[0][2] != signal) {
            board.setCell(0, 2, signal);
            cooX = 0;
            cooY = 2;
        } else if (position[0][0] == mensSignal && position[1][1] == mensSignal && position[2][2] != mensSignal && position[2][2] != signal) {
            board.setCell(2, 2, signal);
            cooX = 2;
            cooY = 2;
        } else if (position[2][2] == mensSignal && position[1][1] == mensSignal && position[0][0] != mensSignal && position[0][0] != signal) {
            board.setCell(0, 0, signal);
            cooX = 0;
            cooY = 0;
        }
    }

    private void moveCom() {
        Signal[][] position = board.getBoard();
        if (position[0][0] == mensSignal && position[0][1] == mensSignal && position[0][2] != mensSignal && position[0][2] != signal) {
            board.setCell(0, 2, signal);
            cooX = 0;
            cooY = 2;
        } else if (position[1][0] == mensSignal && position[1][1] == mensSignal && position[1][2] != mensSignal && position[1][2] != signal) {
            board.setCell(1, 2, signal);
            cooX = 1;
            cooY = 2;
        } else if (position[2][0] == mensSignal && position[2][1] == mensSignal && position[2][2] != mensSignal && position[2][2] != signal) {
            board.setCell(2, 2, signal);
            cooX = 2;
            cooY = 2;
        } else if (position[0][1] == mensSignal && position[0][2] == mensSignal && position[0][0] != mensSignal && position[0][0] != signal) {
            board.setCell(0, 0, signal);
            cooX = 0;
            cooY = 0;
        } else if (position[1][1] == mensSignal && position[1][2] == mensSignal && position[1][0] != mensSignal && position[1][0] != signal) {
            board.setCell(1, 0, signal);
            cooX = 1;
            cooY = 0;
        } else if (position[2][1] == mensSignal && position[2][2] == mensSignal && position[2][0] != mensSignal && position[2][0] != signal) {
            board.setCell(2, 0, signal);
            cooX = 2;
            cooY = 0;
        } else if (position[1][0] == mensSignal && position[2][0] == mensSignal && position[0][0] != mensSignal && position[0][0] != signal) {
            board.setCell(0, 0, signal);
            cooX = 0;
            cooY = 0;
        } else if (position[1][1] == mensSignal && position[2][1] == mensSignal && position[0][1] != mensSignal && position[0][1] != signal) {
            board.setCell(0, 1, signal);
            cooX = 0;
            cooY = 1;
        } else if (position[1][2] == mensSignal && position[2][2] == mensSignal && position[0][2] != mensSignal && position[0][2] != signal) {
            board.setCell(0, 2, signal);
            cooX = 0;
            cooY = 2;
        } else if (position[0][0] == mensSignal && position[1][0] == mensSignal && position[2][0] != mensSignal && position[2][0] != signal) {
            board.setCell(2, 0, signal);
            cooX = 2;
            cooY = 0;
        } else if (position[0][1] == mensSignal && position[1][1] == mensSignal && position[2][1] != mensSignal && position[2][1] != signal) {
            board.setCell(2, 1, signal);
            cooX = 2;
            cooY = 1;
        } else if (position[0][2] == mensSignal && position[1][2] == mensSignal && position[2][2] != mensSignal && position[2][2] != signal) {
            board.setCell(2, 2, signal);
            cooX = 2;
            cooY = 2;
        } else if (position[1][1] == mensSignal && position[0][2] == mensSignal && position[2][0] != mensSignal && position[2][0] != signal) {
            board.setCell(2, 0, signal);
            cooX = 2;
            cooY = 0;
        } else if (position[1][1] == mensSignal && position[2][1] == mensSignal && position[0][2] != mensSignal && position[0][2] != signal) {
            board.setCell(0, 2, signal);
            cooX = 0;
            cooY = 2;
        } else if (position[0][0] == mensSignal && position[1][1] == mensSignal && position[2][2] != mensSignal && position[2][2] != signal) {
            board.setCell(2, 2, signal);
            cooX = 2;
            cooY = 2;
        } else if (position[2][2] == mensSignal && position[1][1] == mensSignal && position[0][0] != mensSignal && position[0][0] != signal) {
            board.setCell(0, 0, signal);
            cooX = 0;
            cooY = 0;
        } else if (position[2][2] == mensSignal && position[0][0] == mensSignal && position[1][1] != mensSignal && position[1][1] != signal) {
            board.setCell(1, 1, signal);
            cooX = 1;
            cooY = 1;
        } else if (position[0][2] == mensSignal && position[2][0] == mensSignal && position[1][1] != mensSignal && position[1][1] != signal) {
            board.setCell(1, 1, signal);
            cooX = 1;
            cooY = 1;
        } else if (position[0][0] == mensSignal && position[0][2] == mensSignal && position[0][1] != mensSignal && position[0][1] != signal) {
            board.setCell(0, 1, signal);
            cooX = 0;
            cooY = 1;
        } else if (position[1][0] == mensSignal && position[1][2] == mensSignal && position[1][1] != mensSignal && position[1][1] != signal) {
            board.setCell(1, 1, signal);
            cooX = 1;
            cooY = 1;
        } else if (position[2][0] == mensSignal && position[2][2] == mensSignal && position[2][1] != mensSignal && position[2][1] != signal) {
            board.setCell(2, 1, signal);
            cooX = 2;
            cooY = 1;
        } else if (position[0][0] == mensSignal && position[2][0] == mensSignal && position[1][0] != mensSignal && position[1][0] != signal) {
            board.setCell(1, 0, signal);
            cooX = 1;
            cooY = 0;
        } else if (position[0][1] == mensSignal && position[2][1] == mensSignal && position[1][1] != mensSignal && position[1][1] != signal) {
            board.setCell(1, 1, signal);
            cooX = 1;
            cooY = 1;
        } else if (position[0][2] == mensSignal && position[2][2] == mensSignal && position[1][2] != mensSignal && position[1][2] != signal) {
            board.setCell(1, 2, signal);
            cooX = 1;
            cooY = 2;
        }

        //piony
        else if (cooY == 0 && position[cooX][1] == Signal._ && position[cooX][2] == Signal._) {
            board.setCell(cooX, cooY + 1, signal);
            cooY += 1;
        }
        //srodki pionowo
        else if (cooY == 1 && position[cooX][0] == Signal._ && position[cooX][2] == Signal._) {
            board.setCell(cooX, cooY + 1, signal);
            cooY += 1;
        } else if (cooY == 1 && position[cooX][0] == Signal._ && position[cooX][2] == Signal._) {
            board.setCell(cooX, cooY - 1, signal);
            cooY -= 1;
        }

        //piony cd
        else if (cooY == 1 && position[cooX][2] == Signal._) {
            board.setCell(cooX, cooY + 1, signal);
            cooY += 1;
        } else if (cooY == 2 && position[cooX][1] == Signal._ && position[cooX][0] == Signal._) {
            board.setCell(cooX, cooY - 1, signal);
            cooY -= 1;
        } else if (cooY == 1 && position[cooX][0] == Signal._) {
            board.setCell(cooX, cooY - 1, signal);
            cooY -= 1;

            //poziomy
        } else if (cooX == 0 && position[1][cooY] == Signal._ && position[2][cooY] == Signal._) {
            board.setCell(cooX + 1, cooY, signal);
            cooX += 1;
        }

        // Srodki poziomo
        else if (cooX == 1 && position[0][cooY] == Signal._ && position[2][cooY] == Signal._) {
            board.setCell(cooX + 1, cooY, signal);
            cooX += 1;
        } else if (cooX == 1 && position[0][cooY] == Signal._ && position[2][cooY] == Signal._) {
            board.setCell(cooX - 1, cooY, signal);
            cooX -= 1;
        }

        //poziomy cd
        else if (cooX == 1 && position[2][cooY] == Signal._) {
            board.setCell(cooX + 1, cooY, signal);
            cooX += 1;
        } else if (cooX == 2 && position[1][cooY] == Signal._ && position[0][cooY] == Signal._) {
            board.setCell(cooX - 1, cooY, signal);
            cooX -= 1;
        } else if (cooX == 1 && position[0][cooY] == Signal._) {
            board.setCell(cooX - 1, cooY, signal);
            cooX -= 1;
        }
    }

    public Signal getSignal() {
        return signal;
    }
}

