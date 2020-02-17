package gui.tertiaryWindow;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

import commands.itemOperations.Operations_Basic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Insets;

public class Panel_ConfigureAlarms extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JTextField location;
	private JComboBox enabled; 
	private JButton save;
	private JButton delete;

	public Panel_ConfigureAlarms () {
		this.setLayout(new BorderLayout());

		final Operations_Basic alarmOps = new Operations_Basic ();
		
		//LINE_START
		String sensorDescription = "This window is for creating, editing, and deleting sensors." +
		"To add a sensor, select 'add sensor' at the bottom of the sensor list, then put in the" +
		" new information into the window on the right, and save.  To edit a sensor, select it" +
		" in the list, then edit in the right pane. to rewove a sensor, select it in the list, " +
		"then click the delete button.";
		
		JTextArea descArea = new JTextArea(sensorDescription);
		JScrollPane lineStartScroll = new JScrollPane(descArea);
		JPanel lineStart = new JPanel();
		
		descArea.setWrapStyleWord(true);
		descArea.setLineWrap(true);
		
		lineStartScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		lineStartScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		lineStartScroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		lineStartScroll.setMinimumSize(new Dimension(250, 300));
		lineStart.setMinimumSize(new Dimension(250, 300));
		descArea.setMinimumSize(new Dimension(250, 300));
		lineStartScroll.setMaximumSize(new Dimension(250, 300));
		lineStart.setMaximumSize(new Dimension(250, 300));
		descArea.setMaximumSize(new Dimension(250, 300));
		lineStartScroll.setPreferredSize(new Dimension(250, 300));
		lineStart.setPreferredSize(new Dimension(250, 300));
		descArea.setPreferredSize(new Dimension(250, 300));
		
		lineStart.setLayout(new BoxLayout(lineStart, BoxLayout.Y_AXIS));
		lineStart.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel descTitle = new JLabel("Category Description");
		descTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lineStart.add(descTitle);
		lineStart.add(lineStartScroll);
		lineStart.setVisible(true);
		
		add(lineStart, BorderLayout.LINE_START);

		
		//LINE_END
/////////////////////Must still add the create, edit, and delete options
		final JPanel lineEnd = new JPanel();
		
		//historyList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		lineEnd.setLayout(new BoxLayout(lineEnd, BoxLayout.Y_AXIS));
		lineEnd.setAlignmentX(Component.CENTER_ALIGNMENT);
		final JLabel editTitle = new JLabel("Edit Selected Sensor");
		
		editTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lineEnd.setMinimumSize(new Dimension(50, 300));
		lineEnd.setMaximumSize(new Dimension(50, 300));
		lineEnd.setPreferredSize(new Dimension(50, 300));
		lineEnd.add(editTitle);
		lineEnd.setVisible(true);
		
		add(lineEnd, BorderLayout.LINE_END);
		
		
		//CENTER
		DefaultListModel sensors = new DefaultListModel();
		final JList sensorList = new JList(sensors);
		JScrollPane centerScroll = new JScrollPane(sensorList);
		JPanel center = new JPanel();
		
		sensorList.setForeground(new Color(0,0,0));
		sensorList.setBackground(new Color(255,255,255));
		
		sensorList.setCellRenderer(new TextPaneRenderer());
		for (int i = 0; i < alarmOps.getNumItems(); i++) {
			sensors.add(i, alarmOps.getLocation(i) + "\t" + alarmOps.getUpTime(i) + "\t" + alarmOps.getFunctionality(i));
		}
		
		sensors.add((alarmOps.getNumItems()), "new sensor");
			
		sensorList.addListSelectionListener(new ListSelectionListener () {
			public void valueChanged(ListSelectionEvent e) {
				//Show data is textfields if in proper range,
				//Show nothing in textFields if add sensor is selected
				//Add save, and delete buttons
				//Add save, and delete button listeners
				lineEnd.removeAll();
				lineEnd.add(editTitle);
			
				location = new JTextField();
				location.setMaximumSize(new Dimension(300, 30));
				location.setMinimumSize(new Dimension(300, 30));
				location.setSize(300, 30);
				lineEnd.add(location);
				
				enabled = new JComboBox();
				enabled.addItem("");
				enabled.addItem("disabled");
				enabled.addItem("enabled");
				lineEnd.add(enabled);
				
				JPanel buttons = new JPanel();
				buttons.setLayout(new BoxLayout(buttons, BoxLayout.X_AXIS));
				
				save = new JButton("Save");
				delete = new JButton("Delete");
				
				buttons.add(save);
				buttons.add(delete);
				
				lineEnd.add(buttons);
				
				add(lineEnd, BorderLayout.LINE_END);

				lineEnd.revalidate();
			}
		});
		
		centerScroll.setMaximumSize(new Dimension(450, 300));
		
		centerScroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		centerScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		centerScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
		center.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel sensorTitle = new JLabel("Sensor List");
		sensorTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		center.add(sensorTitle);
		center.add(centerScroll);
		center.setVisible(true);
		
		add(center, BorderLayout.CENTER);
	
	}
	
	
	class TextPaneRenderer extends JTextPane implements ListCellRenderer
	{
		private static final long serialVersionUID = 1L;
		private final int TAB_COLUMN = 10;
 
		public TextPaneRenderer()
		{
			setMargin( new Insets(0, 0, 0, 0) );
 
			FontMetrics fm = getFontMetrics( getFont() );
			int width = fm.charWidth( 'w' ) * TAB_COLUMN;
 
			TabStop[] tabs = new TabStop[2];
			tabs[0] = new TabStop( width, TabStop.ALIGN_RIGHT, TabStop.LEAD_NONE );
            tabs[1] = new TabStop( width * 2, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE );  
			TabSet tabSet = new TabSet(tabs);
 
			SimpleAttributeSet attributes = new SimpleAttributeSet();
			StyleConstants.setTabSet(attributes, tabSet);
			getStyledDocument().setParagraphAttributes(0, 0, attributes, false);
		}
 
		public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus)
		{
			this.setText( value.toString() );
			this.setBackground(isSelected ? list.getSelectionBackground() : new Color(255,255,255));
			this.setForeground(new Color(0,0,0));
			return this;
		}
	}
	
}
