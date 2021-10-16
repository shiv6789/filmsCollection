import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class VideoFileParser {
	private static String serialFilename = "videos.ser";

	public static void serializeToDisk(List<Video> videos) throws IOException {
		FileOutputStream fos = new FileOutputStream(serialFilename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(videos);
		fos.close();
		oos.close();
	}

	public static List<Video> fromSerialized(String filename) throws IOException, ClassNotFoundException {
		
		List<Video> videos = null;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
		videos = (List<Video>) in.readObject();
		in.close();

		return videos;
//		FileInputStream fileIn = new FileInputStream(filename);
//		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
//		List<Video> videos = new ArrayList<>();
//		boolean cont = true;
//
//		while (cont) {
//			Object obj = objectIn.readObject();
//			if (obj != null) {
//				videos.add((Video) obj);
//			} else {
//				cont = false;
//			}
//		}
//
//		objectIn.close();
//		return videos;

	}
}
