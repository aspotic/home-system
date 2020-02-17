package commands.windowOperations;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import commands.itemOperations.Operations_Basic;
import containers.Globals;

public class Display_History extends JPanel {
	private static final long serialVersionUID = 1L;

	public Display_History () { }
	
	public void refresh (int sensorID) { 
		this.removeAll();
		
		DefaultListModel items = new DefaultListModel();
		JList historyList = new JList(items);
		JScrollPane lineEndScroll = new JScrollPane(historyList);
		
		lineEndScroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		lineEndScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		lineEndScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel histTitle = new JLabel("Selected Sensor History");
		
		histTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lineEndScroll.setMinimumSize(new Dimension(350, 300));
		this.setMinimumSize(new Dimension(350, 300));
		historyList.setMinimumSize(new Dimension(350, 300));
		lineEndScroll.setMaximumSize(new Dimension(350, 300));
		this.setMaximumSize(new Dimension(350, 300));
		historyList.setMaximumSize(new Dimension(350, 300));
		lineEndScroll.setPreferredSize(new Dimension(350, 300));
		this.setPreferredSize(new Dimension(350, 300));
		historyList.setPreferredSize(new Dimension(350, 300));
		
		if (Globals.mon == Globals.opt.ALARM) {
			if (sensorID != -1) {
				Operations_Basic AlarmOps = new Operations_Basic();
				for (int i = 0; i < AlarmOps.getHistorySize(sensorID); i++) {
					items.add(i, AlarmOps.getHistoryEntry(sensorID, i));
				}
			}
		} else {
		}
		
		this.add(histTitle);
		this.add(lineEndScroll);
		
		this.add(histTitle);
		this.add(lineEndScroll);
		this.validate();
		this.setVisible(true);
	}
}
