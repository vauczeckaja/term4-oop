package by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content;

import java.util.EnumSet;

public abstract class Content {
    protected static final double MIN_COST = 0;

    protected enum ContentType {
        FILM ("film"),
        SERIES("series"),
        ANIMATED_FILM("animated film"),
        NOT_DEFINED("not defined");

        private final String type;

        private ContentType(final String type) {
            this.type = type;
        }

        public ContentType get(String value) {
            for (ContentType el : EnumSet.allOf(ContentType.class)) {
                if (el.type.equals(value)) return el;
            }
            return NOT_DEFINED;
        }

        @Override
        public String toString() { return type; }
    }

    protected ContentType type;
    protected String name;
    protected double budget;
    protected double gross;
    protected double profit;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
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
                + "\nType: " + type
                + "\nBudget: " + budget
                + "\nGross: " + gross;
    }
}
