import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Επιτρέπει τη δημιουργία νέας ομάδας με την εισαγωγή του ονόματος της ομάδας
 * και την επιλογή δημόσιας ή ιδιωτικής δημιουργείται η νέα ομάδα και ο χρήστης
 * παραπέμπεται στο χρονολόγιο της ομάδας που δημιούργησε. (Group_Timeline)
 */

public class CreateGroupScreen extends JFrame {

	private JFrame mainFrame;
	
	private JTextField name;
	private JTextField info;

	private JButton GECK;
	private ButtonGroup group;
	private JRadioButton opengroup;
	private JRadioButton privategroup;
	public Group m_Group;
	public DataBase m_DataBase;

	public CreateGroupScreen() {
		
		mainFrame = new JFrame("Create Group Screen");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));

		JPanel contentPane = new JPanel();
		name = new JTextField(15);
		info = new JTextField(20);
		contentPane.add(name);
		contentPane.add(info);


		GECK = new JButton("Create Group");
		contentPane.add(GECK);
		GECK.addActionListener(new GECKActionListener());


		opengroup = new JRadioButton("Open Group", true);
		privategroup = new JRadioButton("Private Group", false);

		group = new ButtonGroup();
		group.add(opengroup);
		group.add(privategroup);

		contentPane.add(opengroup);
		contentPane.add(privategroup);

		mainFrame.add(contentPane);
		this.setSize(getPreferredSize());
		pack();
		mainFrame.setVisible(true);


	}
	class GECKActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if( !DataBase.isGroup(name.getText())) {	//TODO change syso to popup window
				if(group.getSelection() == opengroup )
				{
					if(!DataBase.createGroup(name.getText(), info.getText(), true)) System.out.println("Error-Create Group Failed!");
				}
				else if(group.getSelection() == privategroup )
				{
					if(!DataBase.createGroup(name.getText(), info.getText(), false)) System.out.println("Error-Create Group Failed!");
				}
				else System.out.println("Error-Create Group Failed!");

			}
		}
	}
}

class GECKActionListener implements ActionListener {

	public GECKActionListener(){

	}

	public void finalize() throws Throwable {

	}

	public void actionPerformed(ActionEvent e){

	}
}
