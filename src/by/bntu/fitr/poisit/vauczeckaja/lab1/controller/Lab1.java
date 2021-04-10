package by.bntu.fitr.poisit.vauczeckaja.lab1.controller;


import java.util.EnumSet;

import by.bntu.fitr.poisit.vauczeckaja.lab1.util.UserInput;
import by.bntu.fitr.poisit.vauczeckaja.lab1.view.Printer;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.Manager;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.Director;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Film;



public class Lab1 {
    private static final String MENU = "\nYou are film producer. In this program you can:\n" +
            "1 - hire director and create a film (or set of films)\n" +
            "2 - calculate profit of your company\n" +
            "3 - calculate expenses of your company\n" +
            "4 - check if films were successful\n" +
            "5 - check info about all films\n" +
            "6 - exit.\n";

    private enum Task {
        CREATE_FILM(1),
        CALC_PROFIT(2),
        CALC_EXPENSES(3),
        CHECK_STATUS(4),
        SHOW_INFO(5),
        EXIT(6),
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

        while (true) {
            choice = UserInput.inputInt(MENU+ "Input your choice: ");
            switch (Task.is(choice)) {
                case CREATE_FILM:
                    Director director = Manager.hireDirector();
                    director.createFilm(Manager.allocateBudget());
                    break;

                case CALC_PROFIT:
                    Printer.print("Company profit: " + Manager.calculateProfit(Film.filmSet) + "\n");
                    break;

                case CALC_EXPENSES:
                    Printer.print("Company expenses: " + Manager.calculateExpenses(Film.filmSet) + "\n");
                    break;

                case CHECK_STATUS:
                    Printer.print(Manager.checkStatus(Film.filmSet));
                    break;

                case SHOW_INFO:
                    Printer.print(Manager.showInfo(Film.filmSet));
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
