package by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content;

import java.util.EnumSet;

public abstract class Content {
    protected static final double MIN_COST = 0;

    public enum ContentType {
        FILM ("film"),
        SERIES("series"),
        ANIMATED_FILM("animated film"),
        NOT_DEFINED("not defined");

        private final String type;

        private ContentType(final String type) {
            this.type = type;
        }

        public static ContentType get(String value) {
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
    protected String creator;
    protected double budget;
    protected double gross;
    protected double profit;

    public void setType(String type) {
        this.type = ContentType.get(type);
    }
    public ContentType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void getDirector(String director) {
        this.creator = Content.this.creator;
    }
    public String getCreator() {
        return this.creator;
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
                + "\nCreator: " + creator
                + "\nBudget: " + budget
                + "\nGross: " + gross;
    }
}
