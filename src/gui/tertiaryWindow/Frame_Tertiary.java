package gui.tertiaryWindow;

import gui.tertiaryWindow.Panel_ConfigureAlarms;
import gui.tertiaryWindow.Panel_ConfigureAppliances;
import gui.tertiaryWindow.Panel_ConfigureAudio;
import gui.tertiaryWindow.Panel_ConfigureDoors;
import gui.tertiaryWindow.Panel_ConfigureLGSensors;
import gui.tertiaryWindow.Panel_ConfigureLighting;
import gui.tertiaryWindow.Panel_ConfigureNetwork;
import gui.tertiaryWindow.Panel_ConfigurePower;
import gui.tertiaryWindow.Panel_ConfigureWindows;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import containers.Globals;

public class Frame_Tertiary extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public int type = 0;
	public boolean isChanged = false;

	public Frame_Tertiary () {
		
		//Constantly check for any changes to the screen
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new Refresh_Screen(), 0, 1);
	}
	
	class Refresh_Screen extends TimerTask {
		public void run () {
			
			if (isChanged == true) {
				isChanged = false;
			
				//Clear secondary frame of any old contents
				Globals.tertiaryAddress.getContentPane().removeAll();
				
				//Add the necessary panel
				if (Globals.set == null) {
					
				} else if (Globals.set == Globals.opt.POWERSENSOR) {
					Panel_ConfigurePower configure_Power = new Panel_ConfigurePower();
					Globals.tertiaryAddress.setTitle("Configure: Power System Sensors");
					Globals.tertiaryAddress.add(configure_Power);
					
				} else if (Globals.set == Globals.opt.LGSENSOR) {
					Panel_ConfigureLGSensors configure_LGSensors = new Panel_ConfigureLGSensors();
					Globals.tertiaryAddress.setTitle("Configure: Liquid and Gas Sensors");
					Globals.tertiaryAddress.add(configure_LGSensors);
					
				} else if (Globals.set == Globals.opt.APPLIANCE) {
					Panel_ConfigureAppliances configure_Appliances = new Panel_ConfigureAppliances();
					Globals.tertiaryAddress.setTitle("Configure: Appliances");
					Globals.tertiaryAddress.add(configure_Appliances);
					
				} else if (Globals.set == Globals.opt.WINDOW) {
					Panel_ConfigureWindows configure_Windows = new Panel_ConfigureWindows();
					Globals.tertiaryAddress.setTitle("Configure: Windows and Blinds");
					Globals.tertiaryAddress.add(configure_Windows);
					
				} else if (Globals.set == Globals.opt.DOOR) {
					Panel_ConfigureDoors configure_Doors = new Panel_ConfigureDoors();
					Globals.tertiaryAddress.setTitle("Configure: Door Locks");
					Globals.tertiaryAddress.add(configure_Doors);
				
				} else if (Globals.set == Globals.opt.AUDIO) {
					Panel_ConfigureAudio configure_Audio = new Panel_ConfigureAudio();
					Globals.tertiaryAddress.setTitle("Configure: Home Audio System");
					Globals.tertiaryAddress.add(configure_Audio);
					
				} else if (Globals.set == Globals.opt.LIGHTING) {
					Panel_ConfigureLighting configure_Lighting = new Panel_ConfigureLighting();
					Globals.tertiaryAddress.setTitle("Configure: Room Lighting");
					Globals.tertiaryAddress.add(configure_Lighting);
					
				} else if (Globals.set == Globals.opt.NETWORKNODE) {
					Panel_ConfigureNetwork configure_Network = new Panel_ConfigureNetwork();
					Globals.tertiaryAddress.setTitle("Configure: Network Options");
					Globals.tertiaryAddress.add(configure_Network);
					
				} else if (Globals.set == Globals.opt.ALARM) {
					Panel_ConfigureAlarms configure_Alarms = new Panel_ConfigureAlarms();
					Globals.tertiaryAddress.setTitle("Configure: Alarms");
					Globals.tertiaryAddress.add(configure_Alarms);
					
				} else {
					//Show nothing
				}
				
				//Revalidate the frame for future use
				Globals.tertiaryAddress.validate();
			}
		}
	}
}
