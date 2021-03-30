package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic;

import java.util.*;
import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.Film;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.Randomizer;


public class Director {
    private static final double MIN_GROSS = 0;
    private static final double MAX_GROSS = 200000000.0;

    private static final Map<String, String> DIRECTOR_FILM_DICT = new HashMap<String, String>();
    static {
        DIRECTOR_FILM_DICT.put("David Lynch", "Twin Peaks");
        DIRECTOR_FILM_DICT.put("Quentin Tarantino", "Pulp Fiction");
        DIRECTOR_FILM_DICT.put("Martin Scorsese", "The Wolf of Wall Street");
        DIRECTOR_FILM_DICT.put("Steven Spielberg", "JAWS");
        DIRECTOR_FILM_DICT.put("Christopher Nolan", "The Dark Night");
        DIRECTOR_FILM_DICT.put("Stanley Kubrick", "A Clockwork Orange");
        DIRECTOR_FILM_DICT.put("Alfred Hitchcock", "Psycho");
        DIRECTOR_FILM_DICT.put("James Cameron", "Titanic");
        DIRECTOR_FILM_DICT.put("Francis Coppola", "The Godfather");
        DIRECTOR_FILM_DICT.put("Akira Kurosawa", "Ran");
        DIRECTOR_FILM_DICT.put("Lars von Trier", "Melancholia");
        DIRECTOR_FILM_DICT.put("Guillermo del Toro", "Blade II");
        DIRECTOR_FILM_DICT.put("Park Chan-wook", "Oldboy");
    }
    private List<String> directors = new ArrayList<String>(DIRECTOR_FILM_DICT.keySet());

    private String name;

    public Director() {
        java.util.Random random = new Random();
        this.name = directors.get(random.nextInt(directors.size()));
    }

    public Film createFilm(double budget) {
        return new Film(DIRECTOR_FILM_DICT.get(this.name), this.name,
                budget, Randomizer.randomDouble(MIN_GROSS, MAX_GROSS));
    }
}