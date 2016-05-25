import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * Επιτρέπει τη δημιουργία νέας ομάδας με την εισαγωγή του ονόματος της ομάδας
 * και την επιλογή δημόσιας ή ιδιωτικής δημιουργείται η νέα ομάδα και ο χρήστης
 * παραπέμπεται στο χρονολόγιο της ομάδας που δημιούργησε. (Group_Timeline)
 */

public class CreateGroupScreen extends JFrame {

	private JPanel contentPane;
	
	private JFrame frame;

	private JTextField name;
	private JTextField info;

	private JButton GECK;
	private ButtonGroup buttongroup;
	private JRadioButton opengroup;
	private JRadioButton privategroup;
	public Group m_Group;
	public DataBase m_DataBase;

	public CreateGroupScreen() {
		

		contentPane = new JPanel();
		name = new JTextField("Group name",15);
		info = new JTextField("Write some info...",20);
		contentPane.add(name);
		contentPane.add(info);


		GECK = new JButton("Create Group");
		contentPane.add(GECK);
		GECK.addActionListener(new GECKActionListener());


		opengroup = new JRadioButton("Open Group", true);
		privategroup = new JRadioButton("Private Group", false);

		buttongroup = new ButtonGroup();
		buttongroup.add(opengroup);
		buttongroup.add(privategroup);

		contentPane.add(opengroup);
		contentPane.add(privategroup);
		
		GridLayout grid = new GridLayout(3, 2);
		contentPane.setLayout(grid);
		

		this.add(contentPane);
		this.getContentPane().setSize(900, 900);
		pack();
		this.setVisible(true);


	}
	class GECKActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!DataBase.isGroup(name.getText())) {	//TODO change syso to popup window
				
				String groupname = name.getText();
				String groupinfo = info.getText();
				
				if(buttongroup.getSelection() == opengroup ) {
					if(!(DataBase.createGroup(groupname, groupinfo, true))) 
						JOptionPane.showMessageDialog(frame, "Error-Create Group Failed!");
				}
				else {
					if(!(DataBase.createGroup(name.getText(), info.getText(), false)))
						JOptionPane.showMessageDialog(frame, "Error-Create Group Failed!");
				}
			}
			else
				JOptionPane.showMessageDialog(frame, "Error-Group already exists!");
		}
	}
}
