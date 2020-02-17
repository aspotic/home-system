package containers;

import java.util.HashMap;

import entities.LGSensors;

public class HM_LGSensors {
	private static HashMap<Integer, LGSensors> dictionary;
	
	public HM_LGSensors () {}
	
	public static HashMap<Integer, LGSensors> dictionary () {
		if (dictionary == null) {
			dictionary = new HashMap<Integer, LGSensors>(0);
		}
		return dictionary;
	}
}
