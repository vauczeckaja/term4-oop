package by.bntu.fitr.poisit.vauczeckaja.lab1.view;

public class PrinterDecorator implements Printer {

    protected Printer wrapper;

    public PrinterDecorator(Printer wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void print(String data) {
        wrapper.print(data);
    }

    @Override
    public void println(String msg) {
        wrapper.println(msg);
    }
}
