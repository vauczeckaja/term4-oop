package by.bntu.fitr.poisit.vauczeckaja.lab1.util;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public static int inputInt(String msg) {
        System.out.print(msg);
        return scanner.nextInt();
    }

    public static double inputDouble(String msg) {
        System.out.print(msg);
        return scanner.nextDouble();
    }
}