package app;

import board.Board;
import board.PrintBoard;
import models.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Board board = new Board();
    private Men men = new Men();
    private Men2 men2 = new Men2(men);
    private Computer computer = new Computer(men, board);
    private PrintBoard print = new PrintBoard(board);
    private CheckScore checkScore = new CheckScore(board, print);
    private int playOrder;
    private Scanner scan = new Scanner(System.in);
    private String gameMode;
    private String player;
    private Computer2 computer2 = new Computer2(board);
    private Computer3 computer3 = new Computer3(board);

    public void play() {
        System.out.println("-------------START GRY-------------");
        choseGameMode();
        player();

        if (gameMode.equals("pVc")) {
            men.choseSignal();
            men2.setMen2Signal(men);
        }else if (gameMode.equals("pVp")) {
            men.choseSignal();
            men2.setMen2Signal(men);
        }else {
            gameMode();
        }

        order();
        whoStart();
        startPlay();
    }

    private void choseGameMode() {
        System.out.println("Wybierz tryb gry 'pVc'   'pVp'   'cVc'");
        gameMode = scan.nextLine();
    }

    private void gameMode() {
        if (gameMode.equals("pVc")) {
            pVc();
        } else if (gameMode.equals("pVp")) {
            pVp();
        } else if (gameMode.equals("cVc")){
            cVc();
        }
    }


    private void startPlay() {
        do {
            gameMode();
        } while (isEndGame() == true);
        System.exit(0);
    }

    private void stopPlay() {
        if (checkScore.isStatus() == true)
            System.exit(0);
    }

    private boolean isEndGame() {
        boolean status = false;
        List signalsList = Arrays.asList(board.getBoard());
        if (signalsList.contains(Signal._))
            status = false;
        else
            status = true;

        return status;
    }

    private void order() {
        Random random = new Random();
        playOrder = random.nextInt(2);
    }

    private void pVc() {
        if (playOrder == 0) {
            men.mensMove();
            board.setCell(men.getCoordinateX(), men.getCoordinateY(), men.getMensSignal());
            checkScore.score();
            stopPlay();
            computer.computersMove(board.getMoveNumber());
            print.printBoard();
            checkScore.score();
            stopPlay();
        } else if (playOrder == 1) {
            computer.computersMove(board.getMoveNumber());
            print.printBoard();
            checkScore.score();
            stopPlay();
            men.mensMove();
            board.setCell(men.getCoordinateX(), men.getCoordinateY(), men.getMensSignal());
            checkScore.score();
            stopPlay();
        }
    }

    private void pVp() {

        if (playOrder == 0) {
            System.out.println();
            System.out.println("ruch gracza");
            men.mensMove();
            board.setCell(men.getCoordinateX(), men.getCoordinateY(), men.getMensSignal());
            print.printBoard();
            checkScore.score();
            stopPlay();

            System.out.println();
            System.out.println("ruch gracza 2");
            men2.mensMove();
            board.setCell(men2.getCoordinateX(), men2.getCoordinateY(), men2.getMensSignal());
            print.printBoard();
            checkScore.score();
            stopPlay();

        } else if (playOrder == 1) {

            System.out.println();
            System.out.println("ruch gracza 2");
            men2.mensMove();
            board.setCell(men2.getCoordinateX(), men2.getCoordinateY(), men2.getMensSignal());
            print.printBoard();
            checkScore.score();
            stopPlay();

            System.out.println();
            System.out.println("ruch gracza");
            men.mensMove();
            board.setCell(men.getCoordinateX(), men.getCoordinateY(), men.getMensSignal());
            print.printBoard();
            checkScore.score();
            stopPlay();
        }
    }

    private void cVc() {

        System.out.println("Ruch komputera 1");
        computer2.computersMove(board.getMoveNumber());
        print.printBoard();
        checkScore.score();
        stopPlay();

        System.out.println("Ruch komputera 2");
        computer3.computersMove(board.getMoveNumber());
        print.printBoard();
        checkScore.score();
        stopPlay();
    }

    private void whoStart() {
        if (playOrder == 0)
            System.out.println("Grę rozpoczyna gracz");
        else if (playOrder == 1)
            System.out.println("Grę rozpoczyna " + player);
    }


    private void player() {
        if (gameMode.equals("pVc")) {
            player = "komputer";
        } else if (gameMode.equals("pVp")) {
            player = "gracz 2";
        }
    }
}
