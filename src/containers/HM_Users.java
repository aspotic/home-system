package containers;

import java.util.HashMap;

public class HM_Users {

	private static HashMap<String, String> users;
	private static HashMap<String, String> admins;
	
	public HM_Users () {}
	
	public static HashMap<String, String> users () {
		if (users == null) {
			users = new HashMap<String, String>(0);
		}
		return users;
	}

	public static HashMap<String, String> admins () {
		if (admins == null) {
			admins = new HashMap<String, String>(0);
		}
		return admins;
	}
}
