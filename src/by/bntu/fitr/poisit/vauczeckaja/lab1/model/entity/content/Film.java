package by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content;

import java.util.ArrayList;
import java.util.List;

public class Film extends Content {

    {
        type = ContentType.FILM;
    }

    public Film() {
        name = "noname";
        director = "noname";
        budget = MIN_COST;
        gross = MIN_COST;
        profit = MIN_COST;
    }

    public Film(String name, String director, double budget, double gross) {
        this.name = name;
        this.director = director;
        this.budget = budget;
        this.gross = gross;
        this.profit = gross - budget;
    }

    public Film(Film film) {
        name = film.name;
        director = film.director;
        budget = film.budget;
        gross = film.gross;
        profit = film.profit;
    }

    @Override
    public String toString() {
        return "\nName: " + name
                + "\nType: " + type
                + "\nDirector: " + director
                + "\nBudget: " + budget
                + "\nGross: " + gross;
    }
}
