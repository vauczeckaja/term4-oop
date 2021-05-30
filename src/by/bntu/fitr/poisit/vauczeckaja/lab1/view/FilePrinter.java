package by.bntu.fitr.poisit.vauczeckaja.lab1.view;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FilePrinter extends PrinterDecorator {
    private static final String DEFAULT_FILENAME = "output.txt";
    String filename;
    File file;

    public FilePrinter(Printer printer) {
        super(printer);
        filename = DEFAULT_FILENAME;
        file = new File(filename);
    }

    public FilePrinter(Printer printer, String filename) {
        super(printer);
        this.filename = filename;
        file = new File(this.filename);
    }

    @Override
    public void print(String data) {

        try (OutputStream fos = new FileOutputStream(file, true)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void println(String data) {
        print(data);
    }
}
