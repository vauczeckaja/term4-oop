package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.utils;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;


import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.*;
import by.bntu.fitr.poisit.vauczeckaja.lab1.util.Randomizer;

public class ContentInitializer {
	private static final double MIN_GROSS = 0;
    private static final double MAX_GROSS = 200000000.0;
	private static final double MIN_BUDGET = 0.0;
	private static final double MAX_BUDGET = 100000000.0;

	private static final Map<String, String> CREATOR_CONTENT_DICT = new HashMap<>();
	private List<String> CREATORS = new ArrayList<>(CREATOR_CONTENT_DICT.keySet());
	private static final List<Content.ContentType> TYPES = Collections.unmodifiableList(Arrays.asList(Content.ContentType.values()));
	private static final Random RANDOM = new Random();

	private static String creator;
	private static double budget;
	private static double gross;

	static {
		CREATOR_CONTENT_DICT.put("David Lynch", "Twin Peaks");
		CREATOR_CONTENT_DICT.put("Quentin Tarantino", "Pulp Fiction");
		CREATOR_CONTENT_DICT.put("Martin Scorsese", "The Wolf of Wall Street");
		CREATOR_CONTENT_DICT.put("Steven Spielberg", "JAWS");
		CREATOR_CONTENT_DICT.put("Christopher Nolan", "The Dark Night");
		CREATOR_CONTENT_DICT.put("Stanley Kubrick", "A Clockwork Orange");
		CREATOR_CONTENT_DICT.put("Alfred Hitchcock", "Psycho");
		CREATOR_CONTENT_DICT.put("James Cameron", "Titanic");
		CREATOR_CONTENT_DICT.put("Francis Coppola", "The Godfather");
		CREATOR_CONTENT_DICT.put("Akira Kurosawa", "Ran");
		CREATOR_CONTENT_DICT.put("Lars von Trier", "Melancholia");
		CREATOR_CONTENT_DICT.put("Guillermo del Toro", "Blade II");
		CREATOR_CONTENT_DICT.put("Park Chan-wook", "Oldboy");

		CREATOR_CONTENT_DICT.put("David Benioff, D.W. Weiss", "Game of Thrones");
		CREATOR_CONTENT_DICT.put("Frank Darabont, Angela Kang", "The Walking Dead");
		CREATOR_CONTENT_DICT.put("Chuck Lorre, Bill Prady", "The Big Bang Theory");
		CREATOR_CONTENT_DICT.put("Brad Falchuk, Ryan Murphy", "American Horror Story");
		CREATOR_CONTENT_DICT.put("Vince Gilligan", "Breaking Bad");
		CREATOR_CONTENT_DICT.put("Eric Kripke", "Supernatural");
		CREATOR_CONTENT_DICT.put("Beau Willimon", "House of Cards");
		CREATOR_CONTENT_DICT.put("James Manos Jr.", "Dexter");
		CREATOR_CONTENT_DICT.put("Julie Plec, Kevin Williamson", "The Vampire Diaries");
		CREATOR_CONTENT_DICT.put("David Shore", "House M.D.");
		CREATOR_CONTENT_DICT.put("Nic Pizzolatto", "True Detective");
	}

	{
		budget = Randomizer.randomDouble(MIN_BUDGET, MAX_BUDGET);
		gross = Randomizer.randomDouble(MIN_GROSS, MAX_GROSS);
		creator = CREATORS.get(RANDOM.nextInt(CREATORS.size()));
	}


	public static void init(Content[] content) {
		for (int i = 0; i < content.length; i++) {

			Content.ContentType type = TYPES.get(RANDOM.nextInt(TYPES.size()));

			if (type == Content.ContentType.FILM) content[i] = createFilm();
			else if (type == Content.ContentType.SERIES) content[i] = createdSeries();
			else content[i] = createAnimatedFilm();
		}
	}

	private static Film createFilm() {
		return new Film(CREATOR_CONTENT_DICT.get(creator), creator, budget, gross);
	}

	private static AnimatedFilm createAnimatedFilm() {
		return new AnimatedFilm(CREATOR_CONTENT_DICT.get(creator), creator, budget, gross);
	}

	private static Series createdSeries() {
		int seriesInSeason = RANDOM.nextInt();
		int seasons = RANDOM.nextInt();
		return new Series(CREATOR_CONTENT_DICT.get(creator), creator, seasons, seriesInSeason, budget, gross);
	}

}