package by.bntu.fitr.poisit.vauczeckaja.lab1.model.entity.content;

public final class AnimatedFilm extends Film {
	private String animator;

	{
		type = ContentType.ANIMATED_FILM;
	}
    public AnimatedFilm() {
    }

    public AnimatedFilm(String name, String creator, int budget, int gross) {
    	super(name, creator, budget, gross);
    }

    public AnimatedFilm(AnimatedFilm film) {
    	super(film);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}