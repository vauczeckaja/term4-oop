package by.bntu.fitr.poisit.vauczeckaja.lab1.controller;


import java.util.EnumSet;
import java.util.List;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.Manager;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.utils.ContentCreator;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.utils.ContentInitializer;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.input.ConsoleReader;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.input.Reader;
import by.bntu.fitr.poisit.vauczeckaja.lab1.view.ConsolePrinter;
import by.bntu.fitr.poisit.vauczeckaja.lab1.view.FilePrinter;
import by.bntu.fitr.poisit.vauczeckaja.lab1.view.Printer;


public class Lab1 {
    private static final String OUTPUT_MENU = "\nDo you want to...\n" +
            "1 - print data on the console\n" +
            "2 - print to the file \"output.txt\"\n";
    private static final String MENU = "\nYou are film producer. In this program you can:\n" +
            "1 - create content (films, tv series, animated films\n" +
            "2 - calculate profit of your company\n" +
            "3 - calculate expenses of your company\n" +
            "4 - check if films were successful\n" +
            "5 - check info about all films\n" +
            "6 - sort set by a parameter\n" +
            "7 - search info by a parameter\n" +
            "8 - serialize and deserialize info about films\n" +
            "9 - exit.\n";

    private static final Reader CONSOLE_READER = new ConsoleReader();

    private enum Task {
        CREATE_CONTENT(1),
        CALC_PROFIT(2),
        CALC_EXPENSES(3),
        CHECK_STATUS(4),
        SHOW_INFO(5),
        SORT(6),
        SEARCH(7),
        SERIALIZE(8),
        EXIT(9),
        WRONG_INPUT(0);

        private final int value;

        Task(final int task) {
            this.value = task;
        }

        public static Task is(int choice) {
            for (final Task el : EnumSet.allOf(Task.class)) {
                if (el.value == choice) return el;
            }
            return WRONG_INPUT;
        }
    }

    private enum Output {
        CONSOLE(1),
        ECHO(2),
        WRONG_INPUT(0);

        private final int value;

        Output(final int value) { this.value = value; }

        public static Output is(int choice) {
            for (final Output el : EnumSet.allOf(Output.class)) { if (el.value == choice) return el; }
            return WRONG_INPUT;
        }
    }

    public static void main(String[] args) {
        int choice = Task.WRONG_INPUT.value;
        List<Content> contentList = ContentCreator.createContent();
        Printer printer = printingWayIs();

        while (true) {
            try {
                choice = Integer.parseInt(CONSOLE_READER.read(MENU+ "Input your choice: "));
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }

            switch (Task.is(choice)) {
                case CREATE_CONTENT:
                    ContentInitializer.init(contentList);
                    break;

                case CALC_PROFIT:
                    printer.println("\nCompany profit: " + Manager.calculateProfit(contentList));
                    break;

                case CALC_EXPENSES:
                    printer.println("\nCompany expenses: " + Manager.calculateExpenses(contentList));
                    break;

                case CHECK_STATUS:
                    printer.println(Manager.checkStatus(contentList));
                    break;

                case SHOW_INFO:
                    printer.println(Manager.showInfo(contentList));
                    break;

                case SORT:
                    printer.println(Manager.sortBy(contentList));
                    break;

                case SEARCH:
                    printer.println(Manager.searchBy(contentList));
                    break;

                case SERIALIZE:
                    printer.println(Manager.performSerialization(contentList));
                    break;

                case EXIT:
                    return;

                default:
                    printer.println("Wrong input! Please, try again.\n");
                    break;

            }
        }
    }

    private static Printer printingWayIs() {
        Printer printer = new ConsolePrinter();

        try {
            int choice = Integer.parseInt(CONSOLE_READER.read(OUTPUT_MENU + "\nYour choice: "));

            if (Output.is(choice) == Output.ECHO) printer = new FilePrinter(new ConsolePrinter());
            else if (Output.is(choice) == Output.CONSOLE) printer = new ConsolePrinter();
            else printer.println("Wrong input. Default way (console printing) is chosen");

        } catch (NumberFormatException ex) {
            printer.println(ex.getMessage());
        }

        return printer;
    }
}
