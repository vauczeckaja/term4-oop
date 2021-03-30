package by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content;

public class Film {
    public static final double MIN_COST = 0;

    private String name;
    private String director;
    private double budget;
    private double gross;
    private double profit;


    public Film() {
    }

    public Film(String name, String director, double budget, double gross) {
        this.name = name;
        this.director = director;
        this.budget = budget;
        this.gross = gross;
        this.profit = gross - budget;
    }

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
}
