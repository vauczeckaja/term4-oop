package by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content;

import java.util.ArrayList;
import java.util.List;

public class Film {
    private static final double MIN_COST = 0;

    private String name;
    private String director;
    private double budget;
    private double gross;
    private double profit;

    public static List<Film> filmSet;

    public Film() {
        filmSet = new ArrayList<>();
    }

    public Film(String name, String director, double budget, double gross) {
        this();

        this.name = name;
        this.director = director;
        this.budget = budget;
        this.gross = gross;
        this.profit = gross - budget;

        if (!hasFilm()) filmSet.add(this);
    }

//    public Film(String name, String director, double budget, double gross, List<Film> films) {
//        filmSet = films;
//        this.name = name;
//        this.director = director;
//        this.budget = budget;
//        this.gross = gross;
//        this.profit = gross - budget;
//
//        if (!hasFilm()) filmSet.add(this);
//    }


    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setDirector(String director) {
        this.director = director;
   }
    public String getDirector() {
        return this.director;
    }
// TOdO exception
    public void setBudget(double budget) {
        if (budget >= MIN_COST)
            this.budget = budget;
    }
    public double getBudget() {
        return this.budget;
    }

    public void setGross(double gross) {
        if (gross >= MIN_COST)
            this.gross = gross;
    }
    public double getGross() {
        return this.gross;
    }

    public double getProfit() {
        return this.profit;
    }

    @Override
    public String toString() {
        return "\nName: " + name
                + "\nDirector: " + director
                + "\nBudget: " + budget
                + "\nGross: " + gross;
    }

    private boolean hasFilm() {
        for (Film film : filmSet) {
            if (film.name == this.name) return true;
        }
        return false;
    }
}
