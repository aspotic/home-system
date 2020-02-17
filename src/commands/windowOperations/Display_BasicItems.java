package commands.windowOperations;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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

public class Display_BasicItems extends JPanel {
	private static final long serialVersionUID = 1L;

	public Display_BasicItems(final String type, final Display_History history) {
		final Operations_Basic ItemOps = new Operations_Basic();
		DefaultListModel sensors = new DefaultListModel();
		final JList sensorList = new JList(sensors);
		JScrollPane centerScroll = new JScrollPane(sensorList);
		
		sensorList.setForeground(new Color(0,0,0));
		sensorList.setBackground(new Color(255,255,255));
		
		sensorList.setCellRenderer(new TextPaneRenderer());
		//sensors.add(0, "[Location]"+"\t\t"+"[Up time]"+"\t"+" [Enabled]");
		for (int i = 0; i < ItemOps.getNumItems(); i++) {
			sensors.add(i, ItemOps.getLocation(i) + "\t" + ItemOps.getUpTime(i) + "             \t" + ItemOps.getFunctionality(i));
		}
		
		sensorList.addListSelectionListener(new ListSelectionListener () {
			public void valueChanged(ListSelectionEvent e) {
				if (type.equals("monitor")) {
					history.refresh(sensorList.getSelectedIndex());
					validate();
				} else if (type.equals("config")) {
					
				}
			}
		});
	
		
		centerScroll.setMaximumSize(new Dimension(450, 300));
		
		centerScroll.setAlignmentX(Component.CENTER_ALIGNMENT);
		centerScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		centerScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setAlignmentX(Component.CENTER_ALIGNMENT);
		JLabel sensorTitle = new JLabel("Sensor List");
		sensorTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(sensorTitle);
		this.add(centerScroll);
		this.setVisible(true);
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
