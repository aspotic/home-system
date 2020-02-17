package commands.fileOperations;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

import containers.HM_Users;

public class OpenUsers {
	
	public OpenUsers () {
		String username = "";
		String password = "";
		
		//Read the files into the system
		try {
			FileReader input = new FileReader("Users.dat");
			BufferedReader bufferInput = new BufferedReader(input); 
			String line = bufferInput.readLine();

			while (!(line.equals("END FILE"))) {
				if (line.equals("NEWUSER")) {
					username = bufferInput.readLine();
					password = bufferInput.readLine();
					if (!HM_Users.users().containsKey(username)) {
						HM_Users.users().put(username, password);
					} else {
						JOptionPane.showMessageDialog(null, "Error reading in user. Duplicate username in username file");
					}
				} else if (line.equals("NEWADMIN")) {
					username = bufferInput.readLine();
					password = bufferInput.readLine();
					if (!HM_Users.admins().containsKey(username)) {
						HM_Users.admins().put(username, password);
					} else {
						JOptionPane.showMessageDialog(null, "Error reading in admin. Duplicate username in username file");
					}
				}
				line = bufferInput.readLine();
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "User file does not exist, system shuting down");
			System.exit(1);
		}	
	}	
}