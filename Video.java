import java.io.Serializable;
import java.util.List;

public abstract class Video implements Serializable {
	
	
	private int length;
	private String director;
	private String name;
	private String genre;
	private int releaseYear;
	private List<String> stars; // top-billed actors and actresses

	public Video(String name, int length, String director, String genre, int releaseYear, List<String> stars) {
		this.length = length;
		this.director = director;
		this.name = name;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.stars = stars;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public String getName() {
		return name;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public List<String> getStars() {
		return stars;
	}

	public String getGenre() {
		return genre;
	}

	public String toString() {
		return String.format("%s (%d)%nDirected by %s%nGenre: %s%nRunning length: %d minutes%nStarring: %s", name,
				releaseYear, director, genre, length, stars());
	}

	private String stars() {
		String s = "";
		for (int i = 0; i < stars.size(); i++) {
			if (i > 0)
				s += ", ";
			s += stars.get(i);
		}
		return s;
	}

}
