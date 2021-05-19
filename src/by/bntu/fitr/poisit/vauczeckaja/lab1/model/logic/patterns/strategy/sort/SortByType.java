package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.sort;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content.ContentType;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.UserInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByType implements SortStrategy {
    @Override
    public List<Content> sort(List<Content> list) {
        List<Content> requiredList = new ArrayList<>(list);
        Collections.sort(requiredList, this::compare);

        return requiredList;
    }

    @Override
    public int compare(Content obj1, Content obj2) {
        String type1 = obj1.getType().toString();
        String type2 = obj2.getType().toString();

        return type1.compareTo(type2);
    }
}