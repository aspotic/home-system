package commands.windowOperations;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Display_ConfigForm extends JPanel {
	private static final long serialVersionUID = 1L;
	public Display_ConfigForm () {
		JLabel title = new JLabel("Configuration Form");
		JLabel id = new JLabel("ID");
		JTextField location = new JTextField(15);
		JLabel upTime = new JLabel("Up Time");
		JComboBox enabled  = new JComboBox();
		JButton save = new JButton("save");
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(title);
		this.add(id);
		this.add(upTime);
		this.add(location);
		this.add(enabled);
		this.add(save);
		
	}
}
