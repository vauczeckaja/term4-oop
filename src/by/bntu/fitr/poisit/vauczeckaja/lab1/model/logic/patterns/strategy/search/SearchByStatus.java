package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.search;

import by.bntu.fitr.poisit.vauczeckaja.lab1.controller.Lab1;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.input.ConsoleReader;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.input.Reader;

import java.util.ArrayList;
import java.util.List;

public class SearchByStatus implements SearchStrategy {
    private static final String MENU = "\nDecide whether you want to see " +
            "list of successful films for list of failed ones:\n" +
            "1 - successful\n" +
            "2 - failed\n";
    private static final Reader CONSOLE_READER = new ConsoleReader();

    @Override
    public List<Content> search(List<Content> list) {
        List<Content> requiredList = new ArrayList<>();
        try {
            int choice = Integer.parseInt(CONSOLE_READER.read(MENU+ "Input your choice: "));

            for (Content c : list) {
                if (isSuccessed(c) && choice == 1) requiredList.add(c);
                else if (!isSuccessed(c) && choice == 2) requiredList.add(c);
            }

        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }

        return requiredList;
    }

    private boolean isSuccessed(Content c) {
        return c.getProfit() >= 0 ? true : false;
    }


}
