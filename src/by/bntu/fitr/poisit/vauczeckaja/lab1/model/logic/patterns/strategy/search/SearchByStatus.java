package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.search;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.UserInput;

import java.util.ArrayList;
import java.util.List;

public class SearchByStatus implements SearchStrategy {
    public static final String MENU = "\nDecide whether you want to see " +
            "list of successful films for list of failed ones:\n" +
            "1 - successful\n" +
            "2 - failed\n";

    @Override
    public List<Content> search(List<Content> list) {
        List<Content> requiredList = new ArrayList<>();

        int choice = UserInput.inputInt(MENU + "Input yout choice: ");

        for (Content c : list) {
            if (isSuccessed(c) && choice == 1) requiredList.add(c);
            else if (!isSuccessed(c) && choice == 2) requiredList.add(c);
        }

        return requiredList;
    }

    private boolean isSuccessed(Content c) {
        return c.getProfit() >= 0 ? true : false;
    }


}
