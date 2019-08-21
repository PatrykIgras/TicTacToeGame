package models;

import java.util.Scanner;

public class Men {
    private int coordinateX;
    private int coordinateY;
    private Signal mensSignal;
    private Scanner scan = new Scanner(System.in);

    public void choseSignal() {
        String signal;
        System.out.println("Co wybierasz?");
        System.out.println("Kółko 'O'  czy   Krzyżyk 'X'");
        signal = scan.nextLine();
        if (signal.equals("X"))
            this.mensSignal = Signal.X;
        else if (signal.equals("O"))
            this.mensSignal = Signal.O;
        else
            throw new IllegalArgumentException("Błędnie wybrałeś znak! do wybowu jest kółko 'O' lub krzyżyk 'X'");
    }


    public void mensMove() {
        System.out.println("Podaj współrzędne X znaku");
        coordinateX = scan.nextInt();
        System.out.println("Podaj współrzędne Y znaku");
        coordinateY = scan.nextInt();
    }

    public Signal getMensSignal() {
        return mensSignal;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }
}
