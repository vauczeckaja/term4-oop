package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic;

import java.util.List;
import java.lang.StringBuilder;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.*;

public class Manager {

    private enum Status {
        FAILED("failed"),
        SUCCESSFUL("successful");

        private final String status;

        Status(final String status) {
            this.status = status;
        }

        @Override
        public String toString() { return status; }
    }

    public static double calculateProfit(List<Film> films) {
        double totalProfit = 0;
        if (films != null) {
            for (Film film : films) {
                totalProfit += film.getProfit();
            }
        }
        return totalProfit;
    }

    public static double calculateExpenses(List<Film> films) {
        double totalExpenses = 0;
        if (films != null) {
            for (Film film : films) {
                totalExpenses += film.getBudget();
            }
        }
        return totalExpenses;
    }

    public static String checkStatus(List<Film> films) {
        StringBuilder res = new StringBuilder();
        if (films != null) {
            for (Film film : films) {
                String status = Status.FAILED.toString();
                if (film.getProfit() > 0) status = Status.SUCCESSFUL.toString();
                res.append(film.getName()).append(" was ").append(status).append("\n");
            }
        }
        return res.toString();
    }

    public static String showInfo(List<Film> films) {
        StringBuilder res = new StringBuilder();
        if (films != null) {
            for (Film film : films) {
                res.append(film.toString()).append("\n");
            }
        }
        return res.toString();
    }

}