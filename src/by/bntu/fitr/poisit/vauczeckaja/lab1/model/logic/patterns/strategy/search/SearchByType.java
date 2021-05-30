package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.search;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content.ContentType;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.input.ConsoleReader;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.input.Reader;

import java.util.ArrayList;
import java.util.List;

public class SearchByType implements SearchStrategy {
    private static final String MENU = "\nInput type of the content you'd like to see:\n" +
            ContentType.FILM.toString()+ " - for films\n" +
            ContentType.ANIMATED_FILM.toString()+ " - for animated films\n" +
            ContentType.SERIES.toString()+ " - for series\n";

    private static final Reader CONSOLE_READER = new ConsoleReader();

    @Override
    public List<Content> search(List<Content> list) {
        List<Content> requiredList = new ArrayList<>();

        String typeChoice = CONSOLE_READER.read(MENU + "Input your choice: ");
        ContentType type = ContentType.get(typeChoice);

        for (Content c : list) {
            if (c.getType() == type) {
                requiredList.add(c);
            }
        }
        return requiredList;
    }
}
