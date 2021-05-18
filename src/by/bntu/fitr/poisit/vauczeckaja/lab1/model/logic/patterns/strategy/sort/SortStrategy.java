package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.sort;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;

import java.util.List;

public interface SortStrategy {
    List<Content> sort(List<Content> list);
}
