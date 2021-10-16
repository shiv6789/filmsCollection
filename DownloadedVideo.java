import java.util.List;

public class DownloadedVideo extends Video {

	public DownloadedVideo(String name, int length, String director, String genre, int releaseYear, List<String> stars,
			String filepath) {
		super(name, length, director, genre, releaseYear, stars);
		this.path = filepath;
	}

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\n Downloaded to: "+path;
	}

}
