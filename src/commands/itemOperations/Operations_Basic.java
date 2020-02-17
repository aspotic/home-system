package commands.itemOperations;

import java.util.HashMap;

import containers.HM_Alarm;
import entities.Alarms;

public class Operations_Basic {
	private Object hash;
	
	public Operations_Basic () {
		//if (Globals.mon==Globals.opt.ALARM) {
			hash=HM_Alarm.dictionary();
		//}
	}
	
	@SuppressWarnings("unchecked")
	public int getNumItems () {
		return ((HashMap<Integer, Alarms>) hash).size();
	}
	
	public void newItem (int itemID, String location, boolean activated) {
		HM_Alarm.dictionary().put(HM_Alarm.dictionary().size(), new Alarms(location, itemID, activated));
	}
	
	public boolean newHistory (int ID, String history) {
		if (HM_Alarm.dictionary().containsKey(ID)) {
			HM_Alarm.dictionary().get(ID).addUseHistory(history);
			return true;
		} else {
			return false;
		}
	}
	
	public void editItem (int itemID, String location, boolean activated) {
		if (activated != HM_Alarm.dictionary().get(itemID).getFunctionality())
			HM_Alarm.dictionary().get(itemID).setFunctionality(activated);
		if (!location.equals(HM_Alarm.dictionary().get(itemID).getLocation()))
			HM_Alarm.dictionary().get(itemID).setLocation(location);
	}
	
	public void incrementUpTime (int itemID, int incSize) {
		HM_Alarm.dictionary().get(itemID).setUpTime(HM_Alarm.dictionary().get(itemID).getUpTime()+incSize);
	}
	
	public String getHistoryEntry(int itemID, int key) {
		if (HM_Alarm.dictionary().get(itemID).getUseHistory().containsKey(key))
			return HM_Alarm.dictionary().get(itemID).getUseHistory().get(key);
		else
			return "INVALID ALARM HISTORY KEY";
	}
	
	public int getHistorySize(int itemID) {
		return HM_Alarm.dictionary().get(itemID).getUseHistory().size(); 
	}

	public long getUpTime(int ID) {
		return HM_Alarm.dictionary().get(ID).getUpTime();
	}
	

	public boolean getFunctionality(int ID) {
		return HM_Alarm.dictionary().get(ID).getFunctionality();
	}
	

	public String getLocation(int ID) {
		return HM_Alarm.dictionary().get(ID).getLocation();
	}
	
}
