package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic;

import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;

import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Content;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.search.Searcher;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.patterns.strategy.sort.Sorter;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.Serializer;


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

    public static int calculateProfit(List<Content> contentList) {
        int totalProfit = 0;
        if (contentList != null) {
            for (Content content : contentList) {
                totalProfit += content.getProfit();
            }
        }
        return totalProfit;
    }

    public static int calculateExpenses(List<Content> contentList) {
        int totalExpenses = 0;
        if (contentList != null) {
            for (Content content : contentList) {
                totalExpenses += content.getBudget();
            }
        }
        return totalExpenses;
    }

    public static String checkStatus(List<Content> contentList) {
        StringBuilder res = new StringBuilder();
        res.append("\n");
        if (contentList != null) {
            for (Content content : contentList) {
                String status = Status.FAILED.toString();
                if (content.getProfit() > 0) status = Status.SUCCESSFUL.toString();
                res.append(content.getName()).append(" was ").append(status).append("\n");
            }
        }
        return res.toString();
    }

    public static String showInfo(List<Content> contentList) {
        StringBuilder res = new StringBuilder();
        if (contentList != null) {
            for (Content content : contentList) {
                res.append(content.toString()).append("\n");
            }
        }
        return res.toString();
    }

    public static String sortBy(List<Content> contentList) {
        String res = "";
        if (contentList != null) {
            List<Content> list = new ArrayList<>(Sorter.sort(contentList));
            res = showInfo(list);
        }
        return res;
    }

    public static String searchBy(List<Content> contentList) {
        String res = "";
        if (contentList != null) {
            List<Content> list = new ArrayList<>(Searcher.search(contentList));
            res = showInfo(list);
        }
        return res;
    }

    public static String performSerialization(List<Content> contentList) {
        StringBuilder res = new StringBuilder();
        if (contentList != null) {
            Serializer.write(contentList);
            res.append("\nData were serialized. Data about series were externalized.\n" +
                    "Please check file ").append(Serializer.DEFAULT_FILENAME);
            res.append("\nData were deserialized:\n");
            List<Content> deserList = Serializer.read();
            for (Content content : deserList) {
                res.append(content.toString()).append("\n");
            }
        }
        return res.toString();
    }
}