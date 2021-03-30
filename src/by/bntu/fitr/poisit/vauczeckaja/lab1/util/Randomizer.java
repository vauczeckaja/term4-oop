package by.bntu.fitr.poisit.vauczeckaja.lab1.util;

import java.util.Random;

public class Randomizer {
	private static Random r = new Random();

	public static double randomDouble(double min, double max) {
		return min + (max - min + 1) * r.nextDouble();
	}
}
