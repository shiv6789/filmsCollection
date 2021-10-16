import java.util.UUID;

public class ServerUtils {

	static ServerUtils instance = null;

	private ServerUtils() {
	}

	static public ServerUtils getInstance() {
		if (instance == null)
			instance = new ServerUtils();

		return instance;
	}

	private static final String EOM = "2c727b25-2836-4ab0-b496-8100434ecb21"; // The magic string that signifies End Of
																				// Message. generated using
																				// UUID.randomUUID(). Probably overkill
																				// for our needs.

	public static String getEOM() {
		return EOM;
	}
}
