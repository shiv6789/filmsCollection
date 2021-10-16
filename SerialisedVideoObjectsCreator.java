import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerialisedVideoObjectsCreator {
	private static final String serialFilename = "videos.ser";

	public List<Video> fromSerialized(String filename) throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Video> videos = null;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		videos = (List<Video>) in.readObject();
		in.close();

		return videos;
	}

	private void serializeToDisk(List<Video> videos) throws IOException {
		FileOutputStream fos = new FileOutputStream(serialFilename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(videos);
		fos.close();
		oos.close();
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
	    SerialisedVideoObjectsCreator svoc = new SerialisedVideoObjectsCreator();
		svoc.makeVideoObjects();
		svoc.showSerialisedVideos();
	}
	
	

	private void showSerialisedVideos() throws IOException, ClassNotFoundException {
		List<Video> videos = fromSerialized(serialFilename);
		for (Video v : videos) {
			System.out.format("%s%n%n",v);
		}
	}
	private void makeVideoObjects() throws IOException {
		ArrayList<Video> videos = new ArrayList<>();

//    Video(String name, int length, String director, String genre, int releaseYear, List<String> stars) {
//    StreamingVideo = Video() + (String site, String URL)
//    PhysicalVideo = Video() + (String location, String mediaType)
//    DownloadedVideo = Video() + (String filepath)

		StreamingVideoBuilder vb1 = new StreamingVideoBuilder();
		vb1.name("The Shawshank Redemption")
				.length(142)
				.director("Frank Darabont")
				.genre("Drama")
				.year(1994)
				.star("Tim Robbins")
				.star("Morgan Freeman")
				.star("Bob Gunton")
				.site("Amazon Prime")
				.url("https://www.amazon.co.uk/Shawshank-Redemption-Morgan-Freeman/dp/B00I6EZ408");
		videos.add(vb1.build());

		PhysicalVideoBuilder vb2 = new PhysicalVideoBuilder();
		vb2.name("The Godfather")
				.length(175)
				.director("Francis Ford Coppola")
				.genre("Crime Drama")
				.year(1972)
				.star("Marlon Brando")
				.star("Al Pacino")
				.star("James Caan")
				.location("The shelves by the TV")
				.type("DVD");
		videos.add(vb2.build());

		DownloadedVideoBuilder vb3 = new DownloadedVideoBuilder();
		vb3.name("The Godfather: Part II")
				.length(202)
				.director("Francis Ford Coppola")
				.genre("Crime Drama")
				.year(1974)
				.star("Al Pacino")
				.star("Robert De Niro")
				.star("Diane Keaton")
				.star("Robert Duvall")
				.filepath("E:\\My Films\\The_Godfather_Part_2.mp4");
		videos.add(vb3.build());

		videos.add(new PhysicalVideoBuilder()
				.name("Independence Day")
				.length(145)
				.director("Roland Emmerich")
				.genre("Sci-Fi Action Adventure")
				.year(1996)
				.star("Will Smith")
				.star("Bill Pullman")
				.star("Jeff Goldblum")
				.location("Next to the BluRay player")
				.type("BluRay")
				.build()
		);

		videos.add(new StreamingVideoBuilder()
				.name("Flight of the Navigator")
				.length(90)
				.director("Randal Kleiser")
				.genre("Family Sci-Fi Adventure Comedy")
				.year(1986)
				.star("Joey Cramer")
				.star("Paul Reubens")
				.star("Cliff De Young")
				.star("Sarah Jessica Parker")
				.site("All 4")
				.url("https://www.channel4.com/programmes/flight-of-the-navigator/on-demand/61259-001")
				.build()
		);

		videos.add(new DownloadedVideoBuilder()
				.name("2001: A Space Odyssey")
				.length(149)
				.director("Stanley Kubrick")
				.genre("Sci-Fi")
				.year(1968)
				.star("Keir Dullea")
				.star("Gary Lockwood")
				.star("William Sylvester")
				.filepath("E:\\My Films\\Favourites\\2001 A Space Odyssey.mkv")
				.build()
		);

		videos.add(new DownloadedVideoBuilder()
				.name("Psycho")
				.length(109)
				.director("Alfred Hitchcock")
				.genre("Mystery Horror Thriller")
				.year(1960)
				.star("Anthony Perkins")
				.star("Janet Leigh")
				.star("Vera Miles")
				.filepath("E:\\My Films\\Favourites\\Psycho.mkv")
				.build()
		);

		videos.add(new StreamingVideoBuilder()
				.name("To Kill a Mockingbird")
				.length(129)
				.director("Robert Mulligan")
				.genre("Drama")
				.year(1962)
				.star("Gregory Peck")
				.star("John Megna")
				.star("Frank Overton")
				.site("Rakuten")
				.url("https://rakuten.tv/uk/movies/to-kill-a-mockingbird")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("Vertigo")
				.length(128)
				.director("Alfred Hitchcock")
				.genre("Mystery Romance Thriller")
				.year(1958)
				.star("James Stewart")
				.star("Kim Novak")
				.star("Barbara Bel Geddes")
				.location("The shelves by the TV")
				.type("DVD")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("Rear Window")
				.length(112)
				.director("Alfred Hitchcock")
				.genre("Mystery Thriller")
				.year(1954)
				.star("James Stewart")
				.star("Grace Kelly")
				.star("Wendell Corey")
				.location("The shelves by the TV")
				.type("DVD")
				.build()
		);

		videos.add(new DownloadedVideoBuilder()
				.name("Singin' in the Rain")
				.length(103)
				.director("Stanley Donen & Gene Kelly")
				.genre("Musical Comedy Romance")
				.year(1952)
				.star("Gene Kelly")
				.star("Donald O'Connor")
				.star("Debbie Reynolds")
				.star("Jean Hagen")
				.filepath("E:\\My Films\\Musicals\\Singin'_in_the_Rain.wmv")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("Rebecca")
				.length(130)
				.director("Alfred Hitchcock")
				.genre("Mystery Romance Drama")
				.year(1940)
				.star("Laurence Olivier")
				.star("Joan Fontaine")
				.star("George Sanders")
				.location("The shelves by the TV")
				.type("DVD")
				.build()
		);

		videos.add(new StreamingVideoBuilder()
				.name("Casablanca")
				.length(102)
				.director("Michael Curtiz")
				.genre("War Romance Drama")
				.year(1942)
				.star("Humphrey Bogart")
				.star("Ingrid Bergman")
				.star("Paul Henreid")
				.site("YouTube")
				.url("https://www.youtube.com/watch?v=BnaM9nq4EVw")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("Citizen Kane")
				.length(119)
				.director("Orson Welles")
				.genre("Mystery Drama")
				.year(1941)
				.star("Orson Welles")
				.star("Joseph Cotten")
				.star("Dorothy Comingore")
				.type("DVD")
				.location("The shelves by the TV")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("It's a Wonderful Life")
				.length(130)
				.director("Frank Capra")
				.genre("Family Fantasy Drama")
				.year(1946)
				.star("James Stewart")
				.star("Donna Reed")
				.star("Lionel Barrymore")
				.type("BluRay")
				.location("Next to the BluRay player")
				.build()
		);

		videos.add(new DownloadedVideoBuilder()
				.name("Goodfellas")
				.length(146)
				.director("Martin Scorsese")
				.genre("Biography Crime Drama")
				.year(1990)
				.star("Robert De Niro")
				.star("Ray Liotta")
				.star("Joe Pesci")
				.star("Lorraine Bracco")
				.filepath("E:\\My Films\\Mafia Films\\Goodfellas (1990).mp4")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("The Lord of the Rings: The Fellowship of the Ring")
				.length(178)
				.director("Peter Jackson")
				.genre("Fantasy Action Adventure Drama")
				.year(2001)
				.star("Elijah Wood")
				.star("Ian McKellen")
				.star("Orlando Bloom")
				.star("Sean Astin")
				.star("Sean Bean")
				.star("Cate Blanchett")
				.type("BluRay")
				.location("The high shelf in the bedroom")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("The Lord of the Rings: The Two Towers")
				.length(179)
				.director("Peter Jackson")
				.genre("Fantasy Action Adventure Drama")
				.year(2002)
				.star("Elijah Wood")
				.star("Ian McKellen")
				.star("Viggo Mortensen")
				.star("Sean Astin")
				.star("Cate Blanchett")
				.star("Orlando Bloom")
				.type("BluRay")
				.location("The high shelf in the bedroom")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("The Lord of the Rings: The Return of the King")
				.length(201)
				.director("Peter Jackson")
				.genre("Fantasy Action Adventure Drama")
				.year(2003)
				.star("Elijah Wood")
				.star("Viggo Mortensen")
				.star("Ian McKellen")
				.star("Sean Astin")
				.star("Sean Bean")
				.star("Cate Blanchett")
				.star("Orlando Bloom")
				.type("BluRay")
				.location("The high shelf in the bedroom")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("12 Angry Men")
				.length(96)
				.director("Sidney Lumet")
				.genre("Crime Drama")
				.year(1957)
				.star("Henry Fonda")
				.star("Lee J. Cobb")
				.star("Martin Balsam")
				.type("DVD")
				.location("The shelves by the TV")
				.build()
		);

		videos.add(new StreamingVideoBuilder()
				.name("Back to the Future")
				.length(116)
				.director("Robert Zemeckis")
				.genre("Sci-Fi Adventure Comedy")
				.year(1985)
				.star("Michael J. Fox")
				.star("Christopher Lloyd")
				.star("Lea Thompson")
				.site("NOW TV")
				.url("https://www.nowtv.com/watch/back-to-the-future-1985/A5EK6sKrAaybSz79U1yGQ")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("Gladiator")
				.length(155)
				.director("Ridley Scott")
				.genre("Action Adventure Drama")
				.year(2000)
				.star("Russell Crowe")
				.star("Joaquin Phoenix")
				.star("Connie Nielsen")
				.star("Oliver Reed")
				.type("BluRay")
				.location("The high shelf in the bedroom")
				.build()
		);

		videos.add(new DownloadedVideoBuilder()
				.name("Casino")
				.length(178)
				.director("Martin Scorsese")
				.genre("Crime Drama")
				.year(1995)
				.star("Robert De Niro")
				.star("Sharon Stone")
				.star("Joe Pesci")
				.filepath("E:\\My Films\\Mafia Films\\Casino (1995).mp4")
				.build()
		);

		videos.add(new StreamingVideoBuilder()
				.name("Soul")
				.length(100)
				.director("Pete Docter & Kemp Powers")
				.genre("Family Animation Adventure Comedy")
				.year(2020)
				.star("Jamie Foxx")
				.star("Tina Fey")
				.star("Graham Norton")
				.site("Disney+")
				.url("https://www.disneyplus.com/en-gb/movies/soul/77zlWrb9vRYp")
				.build()
		);

		videos.add(new StreamingVideoBuilder()
				.name("Hamilton")
				.length(160)
				.director("Thomas Kail")
				.genre("Musical Biography History Drama")
				.year(2020)
				.star("Lin-Manuel Miranda")
				.star("Phillipa Soo")
				.star("Leslie Odom Jr.")
				.star("Daveed Diggs")
				.site("Disney+")
				.url("https://www.disneyplus.com/en-gb/movies/hamilton/3uPmBHWlO6HJ")
				.build()
		);

		videos.add(new StreamingVideoBuilder()
				.name("Palm Springs")
				.length(90)
				.director("Max Barbakow")
				.genre("Fantasy Mystery Comedy")
				.year(2020)
				.star("Andy Samberg")
				.star("Cristin Milioti")
				.star("J.K. Simmons")
				.site("Hulu")
				.url("https://www.hulu.com/movie/palm-springs-f70dfd4d-dbfb-46b8-abb3-136c841bba11")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("Whiplash")
				.length(106)
				.director("Damien Chazelle")
				.genre("Music Drama")
				.year(2014)
				.star("Miles Teller")
				.star("J.K. Simmons")
				.star("Melissa Benoist")
				.type("BluRay")
				.location("The high shelf in the bedroom")
				.build()
		);

		videos.add(new DownloadedVideoBuilder()
				.name("Parasite")
				.length(132)
				.director("Bong Joon Ho")
				.genre("Comedy Drama Thriller")
				.year(2019)
				.star("Kang-ho Song")
				.star("Lee Sun-kyun")
				.star("Cho Yeo-jeong")
				.filepath("E:\\My Films\\Subtitled Films\\Parasite (Gisaengchung).mp4")
				.build()
		);

		videos.add(new PhysicalVideoBuilder()
				.name("Django Unchained")
				.length(165)
				.director("Quentin Tarantino")
				.genre("Western Drama")
				.year(2012)
				.star("Jamie Foxx")
				.star("Christoph Waltz")
				.star("Leonardo DiCaprio")
				.star("Kerry Washington")
				.star("Samuel L. Jackson")
				.type("BluRay")
				.location("Next to the BluRay player")
				.build()
		);

		videos.add(new StreamingVideoBuilder()
				.name("The Martian")
				.length(144)
				.director("Ridley Scott")
				.genre("Sci-Fi Adventure Drama")
				.year(2015)
				.star("Matt Damon")
				.star("Jessica Chastain")
				.star("Kristen Wiig")
				.site("Netflix")
				.url("https://www.netflix.com/gb/title/80058399")
				.build()
		);

		/*copy & paste code below
		videos.add(new PhysicalVideoBuilder()
				.name("")
				.length(0)
				.director("")
				.genre("")
				.year(0)
				.star("")
				.star("")
				.star("")
				.type("")
				.location("")
				.build()
		);

		videos.add(new DownloadedVideoBuilder()
				.name("")
				.length(0)
				.director("")
				.genre("")
				.year(0)
				.star("")
				.star("")
				.star("")
				.star("")
				.filepath("")
				.build()
		);

		videos.add(new StreamingVideoBuilder()
				.name("")
				.length(0)
				.director("")
				.genre("")
				.year(0)
				.star("")
				.star("")
				.star("")
				.site("")
				.url("")
				.build()
		);
		end copy and paste*/

		serializeToDisk(videos);
	}

	private abstract class VideoBuilder<T extends VideoBuilder<T>> {
		protected int length;
		protected String director;
		protected String name;
		protected String genre;
		protected int releaseYear;
		protected List<String> stars;

		public VideoBuilder() {
			stars = new ArrayList<>();
		}

		public T length(int length) {
			this.length = length;
			return (T)this;
		}

		public T director(String dir) {
			director = dir;
			return (T)this;
		}

		public T name(String name) {
			this.name = name;
			return (T)this;
		}

		public T genre(String genre) {
			this.genre = genre;
			return (T)this;
		}

		public T year(int year) {
			releaseYear = year;
			return (T)this;
		}

		public T star(String star) {
			stars.add(star);
			return (T)this;
		}
	}

	private class StreamingVideoBuilder extends VideoBuilder<StreamingVideoBuilder> {
		private String site;
		private String URL;

		public StreamingVideoBuilder site(String site) {
			this.site = site;
			return this;
		}

		public StreamingVideoBuilder url(String url) {
			this.URL = url;
			return this;
		}

		public StreamingVideo build() {
			return new StreamingVideo(
					name,
					length,
					director,
					genre,
					releaseYear,
					stars,
					site,
					URL
			);
		}
	}

	private class PhysicalVideoBuilder extends VideoBuilder<PhysicalVideoBuilder> {
		protected String location;
		protected String mediaType;

		public PhysicalVideoBuilder location(String loc) {
			location = loc;
			return this;
		}

		public PhysicalVideoBuilder type(String type) {
			mediaType = type;
			return this;
		}

		public PhysicalVideo build() {
			return new PhysicalVideo(
					name,
					length,
					director,
					genre,
					releaseYear,
					stars,
					location,
					mediaType
			);
		}
	}

	private class DownloadedVideoBuilder extends VideoBuilder<DownloadedVideoBuilder> {
		protected String filepath;

		public DownloadedVideoBuilder filepath(String path) {
			filepath = path;
			return this;
		}

		public DownloadedVideo build() {
			return new DownloadedVideo(
					name,
					length,
					director,
					genre,
					releaseYear,
					stars,
					filepath
			);
		}
	}
}
