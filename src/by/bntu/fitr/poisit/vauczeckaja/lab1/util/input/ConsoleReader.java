package by.bntu.fitr.poisit.vauczeckaja.lab1.util.input;

import java.util.Scanner;

public class ConsoleReader implements Reader {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public ConsoleReader() {
    }

    @Override
    public String read(String request) {
        System.out.print(request);
        return scanner.nextLine();
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}