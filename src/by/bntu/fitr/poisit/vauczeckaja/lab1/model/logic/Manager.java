package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic;

import java.util.ArrayList;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Film;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.Randomizer;


public class Manager {
    private static final double MIN_BUDGET = 0.0;
    private static final double MAX_BUDGET = 100000000.0;
    private static final String STATUS_FAILED = "failed";
    private static final String STATUS_SUCCESSFUL = "successful";


    public static double allocateBudget() {
        return Randomizer.randomDouble(MIN_BUDGET, MAX_BUDGET);
    }

    public static double calculateProfit(ArrayList<Film> films) {
        double totalProfit = 0;
        if (films != null) {
            for (Film film : films) {
                totalProfit += film.getProfit();
            }
        }
        return totalProfit;
    }

    public static double calculateExpenses(ArrayList<Film> films) {
        double totalExpenses = 0;
        if (films != null) {
            for (Film film : films) {
                totalExpenses += film.getBudget();
            }
        }
        return totalExpenses;
    }

    public static String checkStatus(ArrayList<Film> films) {
        String res = "";
        if (films != null) {
            for (Film film : films) {
                String status = STATUS_FAILED;
                if (film.getProfit() > 0) status = STATUS_SUCCESSFUL;
                res += film.getName() + " was " + status + "\n";
            }
        }
        return res;
    }

    public static Director hireDirector() {
        return new Director();
    }

    public static String showInfo(ArrayList<Film> films) {
        String res = "";
        if (films != null) {
            for (Film film : films) {
                res += film.toString() + "\n";
            }
        }
        return res;
    }

}

// @Test
// aaa - arrange act assert
/*

import org.junit.Test;
import org.junit.Assert;
public void testSum() {
Assert.fail();
 */