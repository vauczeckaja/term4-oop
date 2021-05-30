package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.sort;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.search.SearchByStatus;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.search.SearchByType;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.search.Searcher;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.input.ConsoleReader;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.input.Reader;

import java.util.EnumSet;
import java.util.List;

public class Sorter {
    private static final String MENU = "\nInput parameter you'd like to sort by:\n" +
            "1 - by type of the content\n" +
            "2 - by budget\n" +
            "3 - by gross\n" +
            "4 - by profit\n";
    private static final Reader CONSOLE_READER = new ConsoleReader();

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
        try {
            int choice = Integer.parseInt(CONSOLE_READER.read(MENU+ "Input your choice: "));

            if (Parameter.is(choice) == Parameter.BY_TYPE) strategy = new SortByType();
            else if (Parameter.is(choice) == Parameter.BY_BUDGET) strategy = new SortByBudget();
            else if (Parameter.is(choice) == Parameter.BY_GROSS) strategy = new SortByGross();
            else if (Parameter.is(choice) == Parameter.BY_PROFIT) strategy = new SortByProfit();

        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
