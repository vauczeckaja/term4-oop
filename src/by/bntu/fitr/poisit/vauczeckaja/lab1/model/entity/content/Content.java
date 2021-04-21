package by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content;

import java.util.EnumSet;

public class Content {
    protected static final int MIN_COST = 0;

    public enum ContentType {
        FILM ("film"),
        SERIES("series"),
        ANIMATED_FILM("animated film"),
        NOT_DEFINED("not defined");

        private final String type;

        ContentType(final String type) {
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
    protected int budget;
    protected int gross;
    protected int profit;

    public Content() {
        type = ContentType.NOT_DEFINED;
        name = "noname";
        creator ="noname";
        budget = MIN_COST;
        gross = MIN_COST;
        profit = MIN_COST;
    }

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

    public String getCreator() {
        return this.creator;
    }

    public void setBudget(int budget) {
        if (budget >= MIN_COST)
            this.budget = budget;
    }
    public int getBudget() {
        return this.budget;
    }

    public void setGross(int gross) {
        if (gross >= MIN_COST)
            this.gross = gross;
    }
    public int getGross() {
        return this.gross;
    }

    public int getProfit() {
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
