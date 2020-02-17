package commands.windowOperations;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import containers.F_MonDesc;
import containers.F_SetDesc;

public class Display_Description extends JPanel {
	private static final long serialVersionUID = 1L;

	public Display_Description (int type) {
		String sensorDescription;
		
		if (type == 0)
			sensorDescription = F_MonDesc.getDescription();
		else
			sensorDescription = F_SetDesc.getDescription();
		
		JTextArea descArea = new JTextArea(sensorDescription);
		JScrollPane lineStartScroll = new JScrollPane(descArea);
		
		descArea.setWrapStyleWord(true);
		descArea.setLineWrap(true);
		
		lineStartScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		lineStartScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		lineStartScroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		lineStartScroll.setMinimumSize(new Dimension(250, 300));
		this.setMinimumSize(new Dimension(250, 300));
		descArea.setMinimumSize(new Dimension(250, 300));
		lineStartScroll.setMaximumSize(new Dimension(250, 300));
		this.setMaximumSize(new Dimension(250, 300));
		descArea.setMaximumSize(new Dimension(250, 300));
		lineStartScroll.setPreferredSize(new Dimension(250, 300));
		this.setPreferredSize(new Dimension(250, 300));
		descArea.setPreferredSize(new Dimension(250, 300));
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel descTitle = new JLabel("Category Description");
		descTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(descTitle);
		this.add(lineStartScroll);
		this.setVisible(true);
	}
}
