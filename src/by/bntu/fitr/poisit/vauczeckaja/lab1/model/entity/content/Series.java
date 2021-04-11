package by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content;

public class Series extends Content {
    private static final int MIN_SEASONS_AMOUNT = 1;
    private static final int MIN_SERIES_AMOUNT = 1;

    int seasonsAmount;
    int seriesInSeasonAmount;

    {
        type = ContentType.SERIES;
    }

    public Series() {
        name = "noname";
        director = "noname";
        seasonsAmount = MIN_SEASONS_AMOUNT;
        seriesInSeasonAmount = MIN_SERIES_AMOUNT;
        budget = MIN_COST;
        gross = MIN_COST;
        profit = MIN_COST;
    }

    public Series(String name, String director, int seasons, int seriesInSeason, double budget, double gross) {
        this();

        this.name = name;
        this.director = director;

        if (budget >= MIN_COST && gross >= MIN_COST && seasons >= MIN_SEASONS_AMOUNT && seriesInSeason >= MIN_SERIES_AMOUNT) {
            this.seasonsAmount = seasons;
            this.seriesInSeasonAmount = seriesInSeason;
            this.budget = budget;
            this.gross = gross;
            this.profit = gross - budget;
        }
    }

    public Series(Series series) {
        name = series.name;
        director = series.director;
        seriesInSeasonAmount = series.seriesInSeasonAmount;
        seasonsAmount = series.seasonsAmount;
        budget = series.budget;
        gross = series.gross;
        profit = series.profit;
    }

    public int getSeasonsAmount() {
        return seasonsAmount;
    }
    public void setSeasonsAmount(int seasonsAmount) {
        if (seasonsAmount > MIN_SEASONS_AMOUNT) this.seasonsAmount = seasonsAmount;
        else this.seasonsAmount = MIN_SEASONS_AMOUNT;
    }

    public int getSeriesInSeasonAmount() {
        return seriesInSeasonAmount;
    }
    public void setSeriesInSeasonAmount(int seriesInSeasonAmount) {
        this.seriesInSeasonAmount = seriesInSeasonAmount;
        if (seriesInSeasonAmount > MIN_SERIES_AMOUNT) this.seriesInSeasonAmount = seriesInSeasonAmount;
        else this.seriesInSeasonAmount = MIN_SERIES_AMOUNT;
    }

    @Override
    public String toString() {
        return "\nName: " + name
                + "\nType: " + type
                + "\nDirector: " + director
                + "\nBudget: " + budget
                + "\nGross: " + gross;
    }
}
