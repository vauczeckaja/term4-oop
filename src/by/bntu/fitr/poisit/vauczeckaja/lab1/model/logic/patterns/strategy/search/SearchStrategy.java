package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.search;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;

import java.util.List;

public interface SearchStrategy {
    List<Content> search(List<Content> list);
}
