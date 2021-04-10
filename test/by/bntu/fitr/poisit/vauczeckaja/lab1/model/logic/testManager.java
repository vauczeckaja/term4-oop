package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Film;

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
        ArrayList<Film> films = new ArrayList<Film>(){{
                    add(new Film("Film1", "", 10., 20.));
                    add(new Film("Film2", "", 5., 10.));
        }};

        double expectedProfit = 15.;
        double actualProfit = Manager.calculateProfit(films);

        if (expectedProfit != actualProfit) Assert.fail();
    }

    @Test
    public void testCalculateExpensesSetIsEmpty() {
        ArrayList<Film> films = null;

        double expectedExpenses = 0.0;
        double actualExpenses = Manager.calculateExpenses(films);

        if (expectedExpenses != actualExpenses) Assert.fail();
    }

    @Test
    public void testCalculateExpenses() {
        ArrayList<Film> films = new ArrayList<Film>(){{
            add(new Film("Film1", "", 10., 20.));
            add(new Film("Film2", "", 5., 10.));
        }};

        double expectedExpenses = 15.;
        double actualExpenses = Manager.calculateProfit(films);

        if (expectedExpenses != actualExpenses) Assert.fail();
    }

    @Test
    public void testCheckStatusSetIsEmpty() {
        ArrayList<Film> films = null;

        String expectedStatus = "";
        String actualStatus = Manager.checkStatus(films);

        if (!expectedStatus.equals(actualStatus)) Assert.fail();
    }

    @Test
    public void testCheckStatusIsFailed() {
        ArrayList<Film> films = new ArrayList<Film>(){{
            add(new Film("Film1", "", 10., 5.));
        }};

        String expectedStatus = "Film1 was failed\n";
        String actualStatus = Manager.checkStatus(films);

        if (!expectedStatus.equals(actualStatus)) Assert.fail();
    }

    @Test
    public void testCheckStatusIsSuccessful() {
        ArrayList<Film> films = new ArrayList<Film>(){{
            add(new Film("Film1", "", 10., 15.));
        }};

        String expectedStatus = "Film1 was successful\n";
        String actualStatus = Manager.checkStatus(films);

        if (!expectedStatus.equals(actualStatus)) Assert.fail();
    }
}
