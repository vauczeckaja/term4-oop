package by.bntu.fitr.poisit.vauczeckaja.lab1.model.logic.utils;


import by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content.*;

public class ContentCreator {
	public static Content[] createContent(int size) {
		return new Content[size];
	}

	public static Film[] createFilm(int size) {
		Film[] films = new Film[size];
		for (int i = 0; i < films.length; i++) {
			films[i] = new Film[];
		}
		return films;
	}

	public static Series[] createSeries(int size) {
		Series[] series = new Series[size];
		for (int i = 0; i < series.length; i++) {
			series[i] = new Series[];
		}
		return films;
	}
}