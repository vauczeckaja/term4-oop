package by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content;

public class Series extends Content {
    private static final int MIN_SEASONS_AMOUNT = 1;
    private static final int MIN_SERIES_AMOUNT = 1;

    int seasons;
    int seriesInSeason;

    {
        type = ContentType.SERIES;
    }

    public Series() {
        seasons = MIN_SEASONS_AMOUNT;
        seriesInSeason = MIN_SERIES_AMOUNT;
    }

    public Series(String name, String director, int seasons, int seriesInSeason, int budget, int gross) {
        this();

        this.name = name;
        this.creator = director;

        if (budget >= MIN_COST && gross >= MIN_COST && seasons >= MIN_SEASONS_AMOUNT && seriesInSeason >= MIN_SERIES_AMOUNT) {
            this.seasons = seasons;
            this.seriesInSeason = seriesInSeason;
            this.budget = budget;
            this.gross = gross;
            this.profit = gross - budget;
        }
    }

    public Series(Series series) {
        name = series.name;
        creator = series.creator;
        seriesInSeason = series.seriesInSeason;
        seasons = series.seasons;
        budget = series.budget;
        gross = series.gross;
        profit = series.profit;
    }

    public int getSeasons() {
        return seasons;
    }
    public void setSeasons(int seasons) {
        if (seasons > MIN_SEASONS_AMOUNT) this.seasons = seasons;
        else this.seasons = MIN_SEASONS_AMOUNT;
    }

    public int getSeriesInSeason() {
        return seriesInSeason;
    }
    public void setSeriesInSeason(int seriesInSeason) {
        this.seriesInSeason = seriesInSeason;
        if (seriesInSeason > MIN_SERIES_AMOUNT) this.seriesInSeason = seriesInSeason;
        else this.seriesInSeason = MIN_SERIES_AMOUNT;
    }

    @Override
    public String toString() {
        return "\nName: " + name
                + "\nType: " + type
                + "\nCreator: " + creator
                + "\nNumber of series in season: " + seriesInSeason
                + "\nNumber of seasons: " + seasons
                + "\nBudget: " + budget
                + "\nGross: " + gross;
    }
}
