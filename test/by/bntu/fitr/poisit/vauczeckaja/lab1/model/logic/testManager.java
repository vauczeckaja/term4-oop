package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Film;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.Manager;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;

public class testManager {

    @Test
    public void testCalculateProfitSetIsEmpty() {
        ArrayList<Film> films = null;

        double expectedProfit = 0.0;
        double actualProfit = Manager.calculateProfit(films);

        if (expectedProfit != actualProfit) Assert.fail();
    }

    @Test
    public void testCalculateProfit() {

    }

    @Test
    public void testCalculateExpensesSetIsEmpty() {
        ArrayList<Film> films = null;

        double expectedExpenses = 0.0;
        double actualExpenses = Manager.calculateExpenses(films);

        if (expectedExpenses != actualExpenses) Assert.fail();
    }

    @Test
    public void testCheckStatusSetIsEmpty() {
        ArrayList<Film> films = null;

        String expectedStatus = "";
        String actualStatus = Manager.checkStatus(films);

        if (!expectedStatus.equals(actualStatus)) Assert.fail();
    }
}
