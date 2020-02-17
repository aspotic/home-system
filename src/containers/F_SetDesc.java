package containers;

import java.util.HashMap;

import containers.Globals;

public class F_SetDesc {
	private static HashMap<Globals.opt, String> Descriptions;
	
	private F_SetDesc () {}
	
	public static String getDescription () {
		if (Descriptions == null) {
			Descriptions = new HashMap<Globals.opt, String>(1);
			Descriptions.put(Globals.opt.ALARM, "This sensor type does not make any measurements," +
					" but rather is used to notify the home occupants of new information" +
					" like someone at the door, fire, high CO concentrations, and anything" +
					" else that other devices are set up to measure.");
		}
		return Descriptions.get(Globals.mon);
	}
}
