package by.bntu.fitr.poisit.vauczeckaja.lab1.controller;

import java.util.ArrayList;

import by.bntu.fitr.poisit.vauczeckaja.lab1.util.UserInput;
import by.bntu.fitr.poisit.vauczeckaja.lab1.view.Printer;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.Manager;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.Director;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Film;

public class Lab1 {
    public static final String MENU = "\nYou are film producer. In this program you can:\n" +
            "1 - hire director and create a film (or set of films)\n" +
            "2 - calculate profit of your company\n" +
            "3 - calculate expenses of your company\n" +
            "4 - check if films were successful\n" +
            "5 - check info about all films\n" +
            "6 - exit.\n";

    public static void main(String[] args) {
        int choice;

        while (true) {
            choice = UserInput.inputInt(MENU+ "Input your choice: ");
            switch (choice) {
                case 1:
                    Director director = Manager.hireDirector();
                    director.createFilm(Manager.allocateBudget());
                    break;

                case 2:
                    Printer.print("Company profit: " + Manager.calculateProfit(Film.filmSet) + "\n");
                    break;

                case 3:
                    Printer.print("Company expenses: " + Manager.calculateExpenses(Film.filmSet) + "\n");
                    break;

                case 4:
                    Printer.print(Manager.checkStatus(Film.filmSet));
                    break;

                case 5:
                    Printer.print(Manager.showInfo(Film.filmSet));
                    break;

                case 6:
                    return;

                default:
                    Printer.print("Wrong input! Please, try again.\n");
                    break;

            }
        }
    }
}
