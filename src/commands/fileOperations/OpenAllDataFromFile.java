package commands.fileOperations;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

import commands.itemOperations.Operations_Basic;


public class OpenAllDataFromFile {
	
	public OpenAllDataFromFile () {
		boolean activated = false;
		int itemID = 0;
		String location = "";
		
		//Read the files into the system
		try {
			FileReader input = new FileReader("Alarms.dat");
			BufferedReader bufferInput = new BufferedReader(input); 
			String line = bufferInput.readLine();
			Operations_Basic alarmOp = new Operations_Basic();

			while (!(line.equals("END FILE"))) {

				if (line.equals("SENSOR")) {
					location = bufferInput.readLine();
					itemID = Integer.valueOf(bufferInput.readLine());
					activated = Boolean.valueOf(bufferInput.readLine());
					alarmOp.newItem(itemID, location, activated);
					
					line = bufferInput.readLine();
					if (line.equals("SENSOR HISTORY")) {
						line = bufferInput.readLine();
						while (!(line.equals("END SENSOR HISTORY"))) {
							alarmOp.newHistory(itemID, line);
							line = bufferInput.readLine();
						}
					}    
				}
				line = bufferInput.readLine();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Alarm file does not exist, system shuting down");
			System.exit(1);
		}	
	}	
}