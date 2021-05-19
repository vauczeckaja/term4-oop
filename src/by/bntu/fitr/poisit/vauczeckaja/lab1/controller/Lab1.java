package by.bntu.fitr.poisit.vauczeckaja.lab1.controller;


import java.util.EnumSet;
import java.util.List;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.Manager;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.utils.ContentCreator;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.utils.ContentInitializer;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.UserInput;
import by.bntu.fitr.poisit.vauczeckaja.lab1.view.Printer;


public class Lab1 {
    private static final String MENU = "\nYou are film producer. In this program you can:\n" +
            "1 - create content (films, tv series, animated films\n" +
            "2 - calculate profit of your company\n" +
            "3 - calculate expenses of your company\n" +
            "4 - check if films were successful\n" +
            "5 - check info about all films\n" +
            "6 - sort set by a parameter\n" +
            "7 - search info by a parameter\n" +
            "8 - exit.\n";

    private enum Task {
        CREATE_CONTENT(1),
        CALC_PROFIT(2),
        CALC_EXPENSES(3),
        CHECK_STATUS(4),
        SHOW_INFO(5),
        SORT(6),
        SEARCH(7),
        EXIT(8),
        WRONG_INPUT(0);

        private final int task;

        Task(final int task) {
            this.task = task;
        }

        public static Task is(int choice) {
            for (final Task el : EnumSet.allOf(Task.class)) {
                if (el.task == choice) return el;
            }
            return WRONG_INPUT;
        }
    }

    public static void main(String[] args) {
        int choice;
        List<Content> contentList = ContentCreator.createContent();

        while (true) {
            choice = UserInput.inputInt(MENU+ "Input your choice: ");
            switch (Task.is(choice)) {
                case CREATE_CONTENT:
                    ContentInitializer.init(contentList);
                    break;

                case CALC_PROFIT:
                    Printer.print("\nCompany profit: " + Manager.calculateProfit(contentList) + "\n");
                    break;

                case CALC_EXPENSES:
                    Printer.print("\nCompany expenses: " + Manager.calculateExpenses(contentList) + "\n");
                    break;

                case CHECK_STATUS:
                    Printer.print(Manager.checkStatus(contentList));
                    break;

                case SHOW_INFO:
                    Printer.print(Manager.showInfo(contentList));
                    break;

                case SORT:
                    Printer.print(Manager.sortBy(contentList));
                    break;

                case SEARCH:
                    Printer.print(Manager.searchBy(contentList));
                    break;

                case EXIT:
                    return;

                default:
                    Printer.print("Wrong input! Please, try again.\n");
                    break;

            }
        }
    }

}
