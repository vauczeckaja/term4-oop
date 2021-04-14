package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic;

import java.util.List;
import java.lang.StringBuilder;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;

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

    public static double calculateProfit(Content[] contentList) {
        double totalProfit = 0;
        if (contentList != null) {
            for (Content content : contentList) {
                totalProfit += content.getProfit();
            }
        }
        return totalProfit;
    }

    public static double calculateExpenses(Content[] contentList) {
        double totalExpenses = 0;
        if (contentList != null) {
            for (Content content : contentList) {
                totalExpenses += content.getBudget();
            }
        }
        return totalExpenses;
    }

    public static String checkStatus(Content[] contentList) {
        StringBuilder res = new StringBuilder();
        if (contentList != null) {
            for (Content content : contentList) {
                String status = Status.FAILED.toString();
                if (content.getProfit() > 0) status = Status.SUCCESSFUL.toString();
                res.append(content.getName()).append(" was ").append(status).append("\n");
            }
        }
        return res.toString();
    }

    public static String showInfo(Content[]contentList) {
        StringBuilder res = new StringBuilder();
        if (contentList != null) {
            for (Content content : contentList) {
                res.append(content.toString()).append("\n");
            }
        }
        return res.toString();
    }

}