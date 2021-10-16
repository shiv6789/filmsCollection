import java.util.List;

public class StreamingVideo extends Video {
    
	private String URL;
    private String site; //the name of the streaming service hosting the video (e.g. YouTube, Amazon Prime, Netflix)


    public StreamingVideo(String name, int length, String director, String genre, int releaseYear, List<String> stars, String site, String URL) {
        super(name, length, director, genre, releaseYear, stars);
        this.site = site;
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public String getSite() {
        return site;
    }

    public String toString() {
        String superString =  super.toString();
        return String.format("%s%nStreaming on %s%nURL: %s", superString, site, URL);
    }
}
