package by.bntu.fitr.poisit.vauczeckaja.lab1.view;

public class ConsolePrinter implements Printer {
    public ConsolePrinter() {
    }

    @Override
    public void print(String data) {
        System.out.print(data);
    }

    @Override
    public void println(String data) {
        System.out.println(data);
    }
}
