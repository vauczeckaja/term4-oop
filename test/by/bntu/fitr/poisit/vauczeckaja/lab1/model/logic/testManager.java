package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Film;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;

public class testManager {

    @Test
    public void testCalculateProfitSetIsEmpty() {
        Content[] contentList = null;

        int expectedProfit = 0;
        int actualProfit = Manager.calculateProfit(contentList);

        if (expectedProfit != actualProfit) Assert.fail();
    }

    @Test
    public void testCalculateProfit() {
        Content[] contentList = new Content[] {
                new Film("", "", 10, 15),
                new Film("", "", 3, 6)
        };

        int expectedProfit = 8;
        int actualProfit = Manager.calculateProfit(contentList);

        if (expectedProfit != actualProfit) Assert.fail();
    }

    @Test
    public void testCalculateExpensesSetIsEmpty() {
        Content[] contentList = null;

        int expectedExpenses = 0;
        int actualExpenses = Manager.calculateExpenses(contentList);

        if (expectedExpenses != actualExpenses) Assert.fail();
    }

    @Test
    public void testCalculateExpenses() {
        Content[] contentList = new Content[] {
                new Film("", "", 10, 15),
                new Film("", "", 3, 6)
        };

        int expectedExpenses = 13;
        int actualExpenses = Manager.calculateExpenses(contentList);

        if (expectedExpenses != actualExpenses) Assert.fail();
    }

    @Test
    public void testCheckStatusSetIsEmpty() {
        Content[] contentList = null;

        String expectedStatus = "";
        String actualStatus = Manager.checkStatus(contentList);

        if (!expectedStatus.equals(actualStatus)) Assert.fail();
    }

    @Test
    public void testCheckStatusIsFailed() {
        Content[] contentList = new Content[] {new Film("noname", "", 10, 5)};

        String expectedStatus = "noname was failed\n";
        String actualStatus = Manager.checkStatus(contentList);

        if (!expectedStatus.equals(actualStatus)) Assert.fail();
    }

    @Test
    public void testCheckStatusIsSuccessful() {
        Content[] contentList = new Content[] {new Film("noname", "", 5, 10)};

        String expectedStatus = "noname was successful\n";
        String actualStatus = Manager.checkStatus(contentList);

        if (!expectedStatus.equals(actualStatus)) Assert.fail();
    }
}
