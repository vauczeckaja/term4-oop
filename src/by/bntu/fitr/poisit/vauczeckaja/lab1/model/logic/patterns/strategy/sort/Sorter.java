package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.sort;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.UserInput;

import java.util.EnumSet;
import java.util.List;

public class Sorter {
    private static final String MENU = "\nInput parameter you'd like to sort by:\n" +
            "1 - by type of the content\n" +
            "2 - by budget\n" +
            "3 - by gross\n" +
            "4 - by profit\n";

    private static SortStrategy strategy;

    private enum Parameter {
        BY_TYPE(1),
        BY_BUDGET(2),
        BY_GROSS(3),
        BY_PROFIT(4),
        WRONG_INPUT(0);

        private final int param;

        Parameter(final int parameter) { this.param = parameter; }

        public static Parameter is(int choice) {
            for (final Parameter el : EnumSet.allOf(Parameter.class)) {
                if (el.param == choice) return el;
            }
            return WRONG_INPUT;
        }
    }

    public static List<Content> sort(List<Content> list) {
        chooseStrategy();
        return strategy.sort(list);
    }

    private static void chooseStrategy() {
        int choice = UserInput.inputInt(MENU + "Your choice: ");

        if (Parameter.is(choice) == Parameter.BY_TYPE) strategy = new SortByType();
        else if (Parameter.is(choice) == Parameter.BY_BUDGET) strategy = new SortByBudget();
        else if (Parameter.is(choice) == Parameter.BY_GROSS) strategy = new SortByGross();
        else if (Parameter.is(choice) == Parameter.BY_PROFIT) strategy = new SortByProfit();
    }
}
