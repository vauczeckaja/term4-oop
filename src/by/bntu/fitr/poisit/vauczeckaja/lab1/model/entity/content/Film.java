package by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content;

public class Film extends Content {

    {
        type = ContentType.FILM;
    }

    public Film() {
    }

    public Film(String name, String director, int budget, int gross) {
        this.name = name;
        this.creator = director;
        this.budget = budget;
        this.gross = gross;
        this.profit = gross - budget;
    }

    public Film(Film film) {
        name = film.name;
        creator = film.creator;
        budget = film.budget;
        gross = film.gross;
        profit = film.profit;
    }

    @Override
    public String toString() {
        return "\nName: " + name
                + "\nType: " + type
                + "\nCreator: " + creator
                + "\nBudget: " + budget
                + "\nGross: " + gross;
    }
}
