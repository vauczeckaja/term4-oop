package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.sort;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByBudget implements SortStrategy {
    @Override
    public List<Content> sort(List<Content> list) {
        List<Content> requiredList = new ArrayList<>(list);
        Collections.sort(requiredList, this::compare);

        return requiredList;
    }

    @Override
    public int compare(Content obj1, Content obj2) {
        if (obj1.getBudget() > obj2.getBudget()) return 1;
        else if (obj1.getBudget() < obj2.getBudget()) return -1;
        else return 0;
    }
}