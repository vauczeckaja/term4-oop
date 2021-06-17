package by.bntu.fitr.poisit.vauczeckaja.lab1.util;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializer {
    public static final String DEFAULT_FILENAME = "bytecode.bin";

    public static void write(List<Content> contentList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DEFAULT_FILENAME))) {
            oos.writeObject(contentList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Content> read() {
        List<Content> contentList = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DEFAULT_FILENAME))) {
            contentList = (List<Content>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contentList;
    }
}
