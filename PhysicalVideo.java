import java.util.List;

public class PhysicalVideo extends Video {
   
	private String location;
    private String mediaType; //what type of media is the film stored on? (e.g. VHS, DVD, BluRay)

    public PhysicalVideo(String name, int length, String director, String genre, int releaseYear, List<String> stars, String location, String mediaType) {
        super(name, length, director, genre, releaseYear, stars);
        this.location = location;
        this.mediaType = mediaType;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getLocation() {
        return location;
    }

    public String toString() {
        String superString = super.toString();
        return String.format("%s%nPhysically owned on %s%nLocation of %s: %s", superString, mediaType, mediaType, location);
    }
}
