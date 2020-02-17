package containers;

import java.awt.Toolkit;

import gui.secondaryWindow.Frame_Secondary;
import gui.tertiaryWindow.Frame_Tertiary;

public class Globals {
	private final static int WINDOW_WIDTH_PADDING = (int)(0.02 * Toolkit.getDefaultToolkit().getScreenSize().width * Toolkit.getDefaultToolkit().getScreenSize().height/Toolkit.getDefaultToolkit().getScreenSize().width);
	private final static int WINDOW_HEIGHT_PADDING = (int)(0.02 * Toolkit.getDefaultToolkit().getScreenSize().height * Toolkit.getDefaultToolkit().getScreenSize().width/Toolkit.getDefaultToolkit().getScreenSize().height);
	
	public final static int DEFAULT_MENU_WIDTH = 150;
	public final static int DEFAULT_MENU_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	public final static int DEFAULT_MENU_X = 0;
	public final static int DEFAULT_MENU_Y = 0;
	
	public final static int DEFAULT_MONITOR_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - DEFAULT_MENU_WIDTH - 2 * WINDOW_WIDTH_PADDING;
	public final static int DEFAULT_MONITOR_HEIGHT = (int)(Toolkit.getDefaultToolkit().getScreenSize().height * 0.5 - 1.5 * WINDOW_HEIGHT_PADDING);
	public final static int DEFAULT_MONITOR_X = DEFAULT_MENU_WIDTH + WINDOW_WIDTH_PADDING;
	public final static int DEFAULT_MONITOR_Y = WINDOW_HEIGHT_PADDING;
	
	public final static int DEFAULT_CONFIGURE_WIDTH = DEFAULT_MONITOR_WIDTH;
	public final static int DEFAULT_CONFIGURE_HEIGHT = DEFAULT_MONITOR_HEIGHT;
	public final static int DEFAULT_CONFIGURE_X = DEFAULT_MONITOR_X;
	public final static int DEFAULT_CONFIGURE_Y = DEFAULT_MONITOR_Y + DEFAULT_MONITOR_HEIGHT + WINDOW_HEIGHT_PADDING;
	
	public static enum opt {SYSTEMMON, ALARM, APPLIANCE, AUDIO, DOOR, LGSENSOR, LIGHTING, NETWORKNODE, POWERSENSOR, WINDOW};
	public static opt mon;
	public static opt set;
	
	public static Frame_Secondary secondaryAddress;
	public static Frame_Tertiary tertiaryAddress;
	
}
