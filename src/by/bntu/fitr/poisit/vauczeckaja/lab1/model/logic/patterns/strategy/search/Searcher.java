package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.search;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.UserInput;

import java.util.EnumSet;
import java.util.List;

public class Searcher {
    private static final String MENU = "\nInput parameter you'd like to search by:\n" +
            "1 - by type of the content\n" +
            "2 - by profit\n";

    private static SearchStrategy strategy;

    private enum Parameter {
        BY_TYPE(1),
        BY_STATUS(2),
        WRONG_INPUT(0);

        private final int param;

        Parameter(final int parameter) {
            this.param = parameter;
        }

        public static Parameter is(int choice) {
            for (final Parameter el : EnumSet.allOf(Parameter.class)) {
                if (el.param == choice) return el;
            }
            return WRONG_INPUT;
        }
    }

    public static List<Content> search(List<Content> list) {
        chooseStrategy();
        return strategy.search(list);
    }

    private static void chooseStrategy() {
        int choice = UserInput.inputInt(MENU + "Your choice: ");

        if (Parameter.is(choice) == Parameter.BY_TYPE) strategy = new SearchByType();
        else if (Parameter.is(choice) == Parameter.BY_STATUS) strategy = new SearchByStatus();
    }
}