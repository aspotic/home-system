package startup;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import gui.mainMenu.Frame_MainMenu;
import gui.secondaryWindow.Frame_Secondary;
import gui.tertiaryWindow.Frame_Tertiary;

import commands.fileOperations.OpenAllDataFromFile;
import commands.fileOperations.OpenUsers;
import containers.Globals;
import containers.HM_Users;

public class StartSystem {

	/**
	 * Main Function, starts the program running by starting up the main menu frame and panel, and the secondary frame
	 * @param argv
	 */
	@SuppressWarnings("deprecation")
	public static void main (String argv[]) {
		final JPasswordField password = new JPasswordField(15);
		final JTextField username = new JTextField(15);
		final JDialog passwordBox = new JDialog();

		new OpenUsers();

		JButton submitPass = new JButton("Submit Password");
	
		passwordBox.setLayout(new GridLayout(3,1));
		passwordBox.add(username);
		passwordBox.add(password);
		passwordBox.add(submitPass);
		passwordBox.setBounds((int)(Toolkit.getDefaultToolkit().getScreenSize().width * 0.5 - 100), (int)(Toolkit.getDefaultToolkit().getScreenSize().height * 0.5 - 50), 200, 100);
		passwordBox.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		passwordBox.setVisible(true);

		final Thread runMenu = new Thread(){
			public void run() {
				passwordBox.setVisible(false);
				
				if (HM_Users.admins().containsKey(username.getText())) {
					if (password.getText().equals(HM_Users.admins().get(username.getText()))) {
						new OpenAllDataFromFile();
	
						////Start Administrator Interactive System////
						//Make and set visible the frame for the main menu
						Frame_MainMenu menuFrame = new Frame_MainMenu();
						menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
						menuFrame.setBounds(new Rectangle(Globals.DEFAULT_MENU_X, Globals.DEFAULT_MENU_Y, Globals.DEFAULT_MENU_WIDTH, Globals.DEFAULT_MENU_HEIGHT));
						menuFrame.setTitle("System Menu");
						menuFrame.setAlwaysOnTop(true);
						menuFrame.enableMonitor();
						menuFrame.enableConfig();
						menuFrame.setVisible(true);
						
						//Make and set visible the secondary monitoring frame
						Frame_Secondary secondaryFrame = new Frame_Secondary();
						Globals.secondaryAddress = secondaryFrame;
						secondaryFrame.setBounds(new Rectangle(Globals.DEFAULT_MONITOR_X, Globals.DEFAULT_MONITOR_Y, Globals.DEFAULT_MONITOR_WIDTH, Globals.DEFAULT_MONITOR_HEIGHT));
						secondaryFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
						secondaryFrame.setVisible(true);
						
						//Make and set visible the tertiary configuration frame
						Frame_Tertiary tertiaryFrame = new Frame_Tertiary();
						Globals.tertiaryAddress = tertiaryFrame;
						tertiaryFrame.setBounds(new Rectangle(Globals.DEFAULT_CONFIGURE_X, Globals.DEFAULT_CONFIGURE_Y, Globals.DEFAULT_CONFIGURE_WIDTH, Globals.DEFAULT_CONFIGURE_HEIGHT));
						tertiaryFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
						tertiaryFrame.setVisible(true);	
					} else {
						System.exit(0);
					}
				} else if (HM_Users.users().containsKey(username.getText())) {
					if (password.getText().equals(HM_Users.users().get(username.getText()))) {
						
						new OpenAllDataFromFile();
		
						////Start Viewer Interactive System////
						//Make and set visible the frame for the main menu
						Frame_MainMenu menuFrame = new Frame_MainMenu();
						menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
						menuFrame.setBounds(new Rectangle(Globals.DEFAULT_MENU_X, Globals.DEFAULT_MENU_Y, Globals.DEFAULT_MENU_WIDTH, Globals.DEFAULT_MENU_HEIGHT));
						menuFrame.setTitle("System Menu");
						menuFrame.setAlwaysOnTop(true);
						menuFrame.enableMonitor();
						menuFrame.setVisible(true);
						
						//Make and set visible the secondary monitoring frame
						Frame_Secondary secondaryFrame = new Frame_Secondary();
						Globals.secondaryAddress = secondaryFrame;
						secondaryFrame.setBounds(new Rectangle(Globals.DEFAULT_MONITOR_X, Globals.DEFAULT_MONITOR_Y, Globals.DEFAULT_MONITOR_WIDTH, Globals.DEFAULT_MONITOR_HEIGHT));
						secondaryFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
						secondaryFrame.setVisible(true);
							
						//Make and set visible the tertiary configuration frame
						Globals.tertiaryAddress = null;		
					} else {
						System.exit(0);
					}
				} else {
					System.exit(0);
				}
			}
		};
		
		password.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				runMenu.start();
			}
		}); 
		
		submitPass.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				runMenu.start();
			}
		}); 
	}
}
