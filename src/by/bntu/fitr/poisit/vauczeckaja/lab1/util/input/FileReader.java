package by.bntu.fitr.poisit.vauczeckaja.lab1.util.input;

import java.io.File;
import java.io.IOException;

public class FileReader extends ReaderDecorator{
    private static final String DEFAULT_FILENAME = "output.txt";
    String filename;
    File file;

    FileReader(Reader reader) {
        super(reader);
        this.filename = DEFAULT_FILENAME;
        file = new File(filename);
    }

    FileReader(Reader reader, String filename) {
        super(reader);
        this.filename = filename;
        file = new File(filename);
    }

    @Override
    public String read() {
        char[] buff = null;

        try (java.io.FileReader reader = new java.io.FileReader(file)) {
            buff = new char[(int) file.length()];
            reader.read(buff);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return new String(buff);
    }

//    public String readLine() {
//        String line = "";
//        try {
//            java.io.FileReader reader = new java.io.FileReader(file);
//            BufferedReader buffReader = new BufferedReader(reader);
//            StringBuffer strBuff = new StringBuffer();
//
//            while((line=buffReader.readLine()) != null) {
//                strBuff.append(line);
//                strBuff.append("\n");
//            }
//            reader.close();
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//        return line;
//    }
}
