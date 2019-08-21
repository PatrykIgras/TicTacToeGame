package models;

import board.Board;

import java.util.Scanner;

public class Men2 {
    private int coordinateX;
    private int coordinateY;
    private Signal mens2Signal = Signal._;
    private Signal mensSignal = Signal._;
    private Men men;
    private Scanner scan = new Scanner(System.in);

    public Men2(Men men){
        this.men = men;
    }

    public void setMen2Signal(Men men1) {
        mensSignal = men1.getMensSignal();
        if (men1.getMensSignal() == Signal.X)
            mens2Signal = Signal.O;
        else if (men1.getMensSignal() == Signal.O)
            mens2Signal = Signal.X;
    }


    public void mensMove() {
        System.out.println("Podaj współrzędne X znaku");
        coordinateX = scan.nextInt();
        System.out.println("Podaj współrzędne Y znaku");
        coordinateY = scan.nextInt();
    }

    public Signal getMensSignal() {
        return mens2Signal;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }
}
