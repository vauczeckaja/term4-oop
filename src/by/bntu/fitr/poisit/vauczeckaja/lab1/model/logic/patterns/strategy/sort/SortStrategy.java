package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.sort;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;

import java.util.Comparator;
import java.util.List;

public interface SortStrategy extends Comparator<Content> {
    List<Content> sort(List<Content> list);
    int compare(Content obj1, Content obj2);
}
