package containers;

import java.util.HashMap;

import entities.Alarms;

public class HM_Alarm {

	private static HashMap<Integer, Alarms> dictionary;
	
	public HM_Alarm () {}
	
	public static HashMap<Integer, Alarms> dictionary () {
		if (dictionary == null) {
			dictionary = new HashMap<Integer, Alarms>(0);
		}
		return dictionary;
	}
	
}
