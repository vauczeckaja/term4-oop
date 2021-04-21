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
        seasonsAmount = MIN_SEASONS_AMOUNT;
        seriesInSeasonAmount = MIN_SERIES_AMOUNT;
    }

    public Series(String name, String director, int seasons, int seriesInSeason, int budget, int gross) {
        this();

        this.name = name;
        this.creator = director;

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
        creator = series.creator;
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
                + "\nCreator: " + creator
                + "\nNumber of series in season: " + seriesInSeasonAmount
                + "\nNumber of seasons: " + seasonsAmount
                + "\nBudget: " + budget
                + "\nGross: " + gross;
    }
}
