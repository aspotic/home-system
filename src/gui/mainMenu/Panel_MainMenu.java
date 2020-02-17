package gui.mainMenu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import containers.Globals;


public class Panel_MainMenu extends JPanel {
	private static final long serialVersionUID = 1L;

	public Panel_MainMenu () {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}
	
	
	
	public void enableMonitor() {
		//Create Button
		JButton monitor_System = new JButton("System");
		JButton monitor_Power = new JButton("Power");
		JButton monitor_LGSensors = new JButton("L/G Sensors");
		JButton monitor_Appliances = new JButton("Appliances");
		JButton monitor_Windows = new JButton("Windows");
		JButton monitor_Doors = new JButton("Doors");
		JButton monitor_Audio = new JButton("Audio System");
		JButton monitor_Lighting = new JButton("Lighting");
		JButton monitor_Network = new JButton("Network");
		JButton monitor_Alarms = new JButton("Alarms");
		
		//Set Layout off buttons & labels
		monitor_System.setAlignmentX(Component.CENTER_ALIGNMENT);
		monitor_Power.setAlignmentX(Component.CENTER_ALIGNMENT);
		monitor_LGSensors.setAlignmentX(Component.CENTER_ALIGNMENT);
		monitor_Appliances.setAlignmentX(Component.CENTER_ALIGNMENT);
		monitor_Windows.setAlignmentX(Component.CENTER_ALIGNMENT);
		monitor_Doors.setAlignmentX(Component.CENTER_ALIGNMENT);
		monitor_Audio.setAlignmentX(Component.CENTER_ALIGNMENT);
		monitor_Lighting.setAlignmentX(Component.CENTER_ALIGNMENT);
		monitor_Network.setAlignmentX(Component.CENTER_ALIGNMENT);
		monitor_Alarms.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//Enable proper buttons
		monitor_System.setEnabled(false);
		monitor_Power.setEnabled(true);
		monitor_LGSensors.setEnabled(true);
		monitor_Appliances.setEnabled(true);
		monitor_Windows.setEnabled(true);
		monitor_Doors.setEnabled(true);
		monitor_Audio.setEnabled(false);
		monitor_Lighting.setEnabled(false);
		monitor_Network.setEnabled(false);
		monitor_Alarms.setEnabled(true);
		
		//Add Buttons
		JLabel monitorsLabel = new JLabel("Monitors");
		monitorsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(monitorsLabel);
		this.add(Box.createVerticalGlue());
		this.add(monitor_System);
		this.add(Box.createVerticalGlue());
		this.add(monitor_Power);
		this.add(Box.createVerticalGlue());
		this.add(monitor_LGSensors);
		this.add(Box.createVerticalGlue());
		this.add(monitor_Appliances);
		this.add(Box.createVerticalGlue());
		this.add(monitor_Windows);
		this.add(Box.createVerticalGlue());
		this.add(monitor_Doors);
		this.add(Box.createVerticalGlue());
		this.add(monitor_Audio);
		this.add(Box.createVerticalGlue());
		this.add(monitor_Lighting);
		this.add(Box.createVerticalGlue());
		this.add(monitor_Network);
		this.add(Box.createVerticalGlue());
		this.add(monitor_Alarms);
		this.add(Box.createVerticalGlue());
		
		
		//Monitor Button Action Listeners
		monitor_System.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Open system monitor window
				Globals.mon = Globals.opt.SYSTEMMON;
				Globals.secondaryAddress.isChanged = true;
				Globals.secondaryAddress.setVisible(true);
			}
		});	
		
		monitor_Power.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open power system monitor
				Globals.mon = Globals.opt.POWERSENSOR;
				Globals.secondaryAddress.isChanged = true;
				Globals.secondaryAddress.setVisible(true);
			}
		});
		
		monitor_LGSensors.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open water sensors setup window
				Globals.mon = Globals.opt.LGSENSOR;
				Globals.secondaryAddress.isChanged = true;
				Globals.secondaryAddress.setVisible(true);
			}
		});

		monitor_Appliances.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open Appliances setup window
				Globals.mon = Globals.opt.APPLIANCE;
				Globals.secondaryAddress.isChanged = true;
				Globals.secondaryAddress.setVisible(true);
			}
		});
		
		monitor_Windows.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open windows setup window
				Globals.mon = Globals.opt.WINDOW;
				Globals.secondaryAddress.isChanged = true;
				Globals.secondaryAddress.setVisible(true);
			}
		});
		
		monitor_Doors.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open doors setup window
				Globals.mon = Globals.opt.DOOR;
				Globals.secondaryAddress.isChanged = true;
				Globals.secondaryAddress.setVisible(true);
			}
		});
		
		monitor_Audio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open oudio system setup window
				Globals.mon = Globals.opt.AUDIO;
				Globals.secondaryAddress.isChanged = true;
				Globals.secondaryAddress.setVisible(true);
			}
		});

		monitor_Lighting.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open lighting setup window
				Globals.mon = Globals.opt.LIGHTING;
				Globals.secondaryAddress.isChanged = true;
				Globals.secondaryAddress.setVisible(true);
			}
		});

		monitor_Network.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open network setup window
				Globals.mon = Globals.opt.NETWORKNODE;
				Globals.secondaryAddress.isChanged = true;
				Globals.secondaryAddress.setVisible(true);
			}
		});

		monitor_Alarms.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open alarm setup window
				Globals.mon = Globals.opt.ALARM;
				Globals.secondaryAddress.isChanged = true;
				Globals.secondaryAddress.setVisible(true);
			}
		});
	}
	
	
	
	
	public void enableConfig() {
		//Create Button
		JButton configure_Power = new JButton("Power");
		JButton configure_LGSensors = new JButton("L/G Sensors");
		JButton configure_Appliances = new JButton("Appliances");
		JButton configure_Windows = new JButton("Windows");
		JButton configure_Doors = new JButton("Doors");
		JButton configure_Audio = new JButton("Audio System");
		JButton configure_Lighting = new JButton("Lighting");
		JButton configure_Network = new JButton("Network");
		JButton configure_Alarms = new JButton("Alarms");
		JButton configure_Users = new JButton("Manage Users");
		
		//Set Layout off buttons & labels
		configure_Power.setAlignmentX(Component.CENTER_ALIGNMENT);
		configure_LGSensors.setAlignmentX(Component.CENTER_ALIGNMENT);
		configure_Appliances.setAlignmentX(Component.CENTER_ALIGNMENT);
		configure_Windows.setAlignmentX(Component.CENTER_ALIGNMENT);
		configure_Doors.setAlignmentX(Component.CENTER_ALIGNMENT);
		configure_Audio.setAlignmentX(Component.CENTER_ALIGNMENT);
		configure_Lighting.setAlignmentX(Component.CENTER_ALIGNMENT);
		configure_Network.setAlignmentX(Component.CENTER_ALIGNMENT);
		configure_Alarms.setAlignmentX(Component.CENTER_ALIGNMENT);		
		configure_Users.setAlignmentX(Component.CENTER_ALIGNMENT);	
		
		//Enable proper buttons
		configure_Power.setEnabled(false);
		configure_LGSensors.setEnabled(false);
		configure_Appliances.setEnabled(false);
		configure_Windows.setEnabled(false);
		configure_Doors.setEnabled(false);
		configure_Audio.setEnabled(false);
		configure_Lighting.setEnabled(false);
		configure_Network.setEnabled(false);
		configure_Alarms.setEnabled(false);
		configure_Users.setEnabled(false);
		
		//Add Buttons
		JLabel configurationLabel = new JLabel("Configuration");
		configurationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(configurationLabel);
		this.add(Box.createVerticalGlue());
		this.add(configure_Power);
		this.add(Box.createVerticalGlue());
		this.add(configure_LGSensors);
		this.add(Box.createVerticalGlue());
		this.add(configure_Appliances);
		this.add(Box.createVerticalGlue());
		this.add(configure_Windows);
		this.add(Box.createVerticalGlue());
		this.add(configure_Doors);
		this.add(Box.createVerticalGlue());
		this.add(configure_Audio);
		this.add(Box.createVerticalGlue());
		this.add(configure_Lighting);
		this.add(Box.createVerticalGlue());
		this.add(configure_Network);
		this.add(Box.createVerticalGlue());
		this.add(configure_Alarms);
		this.add(Box.createVerticalGlue());
		this.add(configure_Users);
		this.add(Box.createVerticalGlue());
		
		//Configure Button Action Listeners
		configure_Power.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open power system monitor
				Globals.set = Globals.opt.POWERSENSOR;
				Globals.tertiaryAddress.isChanged = true;
				Globals.tertiaryAddress.setVisible(true);
			}
		});
		
		configure_LGSensors.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open water sensors setup window
				Globals.set = Globals.opt.LGSENSOR;
				Globals.tertiaryAddress.isChanged = true;
				Globals.tertiaryAddress.setVisible(true);
			}
		});

		configure_Appliances.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open Appliances setup window
				Globals.set = Globals.opt.APPLIANCE;
				Globals.tertiaryAddress.isChanged = true;
				Globals.tertiaryAddress.setVisible(true);
			}
		});
		
		configure_Windows.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open windows setup window
				Globals.set = Globals.opt.WINDOW;
				Globals.tertiaryAddress.isChanged = true;
				Globals.tertiaryAddress.setVisible(true);
			}
		});
		
		configure_Doors.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open doors setup window
				Globals.set = Globals.opt.DOOR;
				Globals.tertiaryAddress.isChanged = true;
				Globals.tertiaryAddress.setVisible(true);
			}
		});
		
		configure_Audio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open oudio system setup window
				Globals.set = Globals.opt.AUDIO;
				Globals.tertiaryAddress.isChanged = true;
				Globals.tertiaryAddress.setVisible(true);
			}
		});

		configure_Lighting.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open lighting setup window
				Globals.set = Globals.opt.LIGHTING;
				Globals.tertiaryAddress.isChanged = true;
				Globals.tertiaryAddress.setVisible(true);
			}
		});

		configure_Network.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open network setup window
				Globals.set = Globals.opt.NETWORKNODE;
				Globals.tertiaryAddress.isChanged = true;
				Globals.tertiaryAddress.setVisible(true);
			}
		});

		configure_Alarms.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//Open alarm setup window
				Globals.set = Globals.opt.ALARM;
				Globals.tertiaryAddress.isChanged = true;
				Globals.tertiaryAddress.setVisible(true);
			}
		});
	}
}
